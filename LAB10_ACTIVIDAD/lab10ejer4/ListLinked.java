
public class ListLinked<E> {

    private Node<E> head;
    private int size;

    public ListLinked() {
        head = null;
        size = 0;
    }

    public void addLast(E data) {

        Node<E> nuevo = new Node<>(data);

        if (head == null) {
            head = nuevo;
        } else {
            Node<E> aux = head;

            while (aux.next != null) {
                aux = aux.next;
            }

            aux.next = nuevo;
        }

        size++;
    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            return null;
        }

        Node<E> aux = head;

        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux.data;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
    
        if (index < 0 || index >= size) {
            return;
        }
    
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
    
        Node<E> anterior = head;
    
        for (int i = 0; i < index - 1; i++) {
            anterior = anterior.next;
        }
    
        anterior.next = anterior.next.next;
    
        size--;
    }

}
