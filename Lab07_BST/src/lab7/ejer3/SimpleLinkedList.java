
public class SimpleLinkedList<E> {

    // Referencia al primer nodo
    private ListNode<E> head;

    // Referencia al último nodo
    private ListNode<E> tail;

    public SimpleLinkedList() {
        // La lista inicia vacía
        head = null;
        // No existe último nodo todavía
        tail = null;
    }

    // =================================================
    // Verifica si la lista está vacía
    // =================================================
    public boolean isEmpty() {

        // Si head es null la lista está vacía
        return head == null;
    }

    // =================================================
    // Inserta un elemento al final
    // =================================================
    public void addLast(E data) {

        // Crear nuevo nodo con el dato recibido
        ListNode<E> newNode =
                new ListNode<>(data);

        // Verificar si la lista está vacía
        if (isEmpty()) {

            // El nuevo nodo será el primero
            head = newNode;

            // También será el último
            tail = newNode;

            // Finalizar método
            return;
        }
        // El último nodo apunta al nuevo nodo
        tail.next = newNode;
        // Actualizar tail
        tail = newNode;
    }

    // =================================================
    // Elimina el primer nodo
    // =================================================
    public E removeFirst() {
        // Verificar si la lista está vacía
        if (isEmpty())
            // Retornar null si no hay elementos
            return null;

        // Guardar el dato del primer nodo
        E data = head.data;

        // Mover head al siguiente nodo
        head = head.next;

        // Si head quedó null
        if (head == null)
            tail = null;

        return data;
    }
}