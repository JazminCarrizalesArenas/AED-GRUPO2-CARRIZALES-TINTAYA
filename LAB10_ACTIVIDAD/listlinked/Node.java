package listlinked;

// Nodo generico para la lista enlazada simple
public class Node<E> {

    private E data;
    public Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
