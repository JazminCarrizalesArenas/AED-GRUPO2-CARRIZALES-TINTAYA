package actividadPilaLista;

public class Node<E> {

    private E data;        // Dato almacenado en el nodo
    private Node<E> next;  // Referencia al siguiente nodo

    public Node(E data) { 
        this.data = data; 
        this.next = null;  // Inicialmente no apunta a nadie
    }

    public E getData() { return data; } // Retorna el dato

    public Node<E> getNext() { return next; } // Retorna el siguiente nodo

    public void setNext(Node<E> n) { this.next = n; } // Asigna el siguiente nodo
}





