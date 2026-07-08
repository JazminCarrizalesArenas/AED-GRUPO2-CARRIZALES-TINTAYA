
public class LinkedList<T> implements Iterable<T> {

    /**
     * Clase interna que representa un nodo de la lista enlazada.
     */
    private static class Node<T> {
        T data;        // Dato almacenado en el nodo
        Node<T> next;  // Referencia al siguiente nodo de la lista

        Node(T data) {
            this.data = data; // Se guarda el dato recibido en el nodo
            this.next = null; // Un nodo nuevo nunca apunta a otro nodo todavía
        }
    }

    private Node<T> head; // Referencia al primer nodo de la lista (cabeza)
    private int size;     // Cantidad de elementos actualmente en la lista

    /** Constructor: crea una lista enlazada vacía. */
    public LinkedList() {
        this.head = null; // Una lista nueva no tiene nodos
        this.size = 0;     // El tamaño inicial es cero
    }

    /**
     * Inserta un nuevo elemento al final de la lista.
     */
    public void addLast(T data) {
        Node<T> nuevo = new Node<>(data); // Se crea el nodo que contendrá el nuevo dato
        if (head == null) {
            head = nuevo; // Si la lista estaba vacía, el nuevo nodo pasa a ser la cabeza
        } else {
            Node<T> actual = head;
            while (actual.next != null) { // Se avanza hasta llegar al último nodo
                actual = actual.next;
            }
            actual.next = nuevo; // Se enlaza el nuevo nodo al final de la lista
        }
        size++; // Se incrementa la cantidad de elementos almacenados
    }

    /**
     * Elimina la primera ocurrencia de un elemento igual a "data"
     * (la comparación se hace mediante el método equals() del tipo T).
     */
    public boolean remove(T data) {
        if (head == null) return false; // Lista vacía: no hay nada que eliminar

        if (head.data.equals(data)) {   // Caso especial: el elemento a eliminar es la cabeza
            head = head.next;            // La cabeza pasa a ser el segundo nodo (o null)
            size--;
            return true;
        }

        Node<T> anterior = head; // Puntero al nodo previo al que se está revisando
        Node<T> actual = head.next; // Puntero al nodo que se está revisando
        while (actual != null) {
            if (actual.data.equals(data)) {
                anterior.next = actual.next; // Se "saltea" el nodo actual desenlazándolo de la lista
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.next;
        }
        return false; // Se recorrió toda la lista y no se encontró el elemento
    }

    /**
     * Busca el primer elemento de la lista igual a "data" (mediante equals()).
     */
    public T search(T data) {
        Node<T> actual = head; // Se inicia el recorrido desde la cabeza
        while (actual != null) {
            if (actual.data.equals(data)) {
                return actual.data; // Se encontró un nodo cuyo dato es igual al buscado
            }
            actual = actual.next; // Se avanza al siguiente nodo
        }
        return null; // No se encontró ningún elemento igual
    }

    public boolean isEmpty() {
        return size == 0; // La lista está vacía cuando su tamaño es 0
    }
    public int size() {
        return size; // Devuelve el contador interno de elementos
    }

    /**
     * Representación en texto de la lista completa, mostrando todos sus
     * elementos en orden, separados por " -> " (simula la cadena de nodos).
     */
    @Override
    public String toString() {
        if (head == null) return "[vacía]"; // Caso especial: lista sin elementos
        StringBuilder sb = new StringBuilder();
        Node<T> actual = head;
        while (actual != null) {
            sb.append(actual.data);             // Se agrega la representación del dato actual
            if (actual.next != null) sb.append(" -> "); // Se agrega el separador si hay más nodos
            actual = actual.next;
        }
        return sb.toString();
    }

    /**
     * Implementación de Iterable<T> para poder recorrer la lista con un
     * for-each: for (T item : miLista) { ... }
     */
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> actual = head; // Puntero que recorrerá la lista nodo por nodo

            @Override
            public boolean hasNext() {
                return actual != null; // Existe un siguiente elemento mientras no se llegue al final
            }

            @Override
            public T next() {
                T dato = actual.data;  // Se obtiene el dato del nodo actual
                actual = actual.next;  // Se avanza el puntero al siguiente nodo
                return dato;            // Se retorna el dato leído
            }
        };
    }
}
