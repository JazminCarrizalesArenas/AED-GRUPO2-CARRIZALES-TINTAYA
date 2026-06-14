package listlinked;

// Lista enlazada simple generica
// Permite insertar al inicio, al final, obtener por indice,
// eliminar un elemento y verificar si existe
public class ListLinked<E> {

    private Node<E> head;
    private int size;

    public ListLinked() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Inserta un elemento al final de la lista
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Inserta un elemento al inicio de la lista
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Retorna el elemento en la posicion index (base 0)
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Indice invalido: " + index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.getData();
    }

    // Elimina la primera ocurrencia del elemento, retorna true si lo encontro
    public boolean remove(E data) {
        if (head == null) return false;
        if (head.getData().equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        Node<E> current = head;
        while (current.next != null) {
            if (current.next.getData().equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Verifica si un elemento esta en la lista
    public boolean contains(E data) {
        Node<E> current = head;
        while (current != null) {
            if (current.getData().equals(data)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.next != null) sb.append(" ");
            current = current.next;
        }
        return sb.toString();
    }
}
