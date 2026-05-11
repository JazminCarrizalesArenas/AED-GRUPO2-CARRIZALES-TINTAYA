public class Queue<E> {

    // Lista enlazada interna
    private SimpleLinkedList<E> list;

    public Queue() {
        // Crear lista enlazada vacía
        list = new SimpleLinkedList<>();
    }

    public boolean isEmpty() {
        // Llama al método de la lista
        return list.isEmpty();
    }

    // =================================================
    // Inserta un elemento al final
    // =================================================
    public void enqueue(E data) {
        // Agregar al final de la lista
        list.addLast(data);
    }

    // =================================================
    // Elimina el primer elemento
    // =================================================
    public E dequeue() {
        // Elimina el primer nodo de la lista
        return list.removeFirst();
    }
}