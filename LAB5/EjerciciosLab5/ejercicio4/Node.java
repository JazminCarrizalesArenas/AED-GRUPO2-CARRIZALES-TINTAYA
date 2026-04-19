package ejercicio4;
class Node<T> {
    T dato; // almacena el dato del nodo
    Node<T> siguiente; // referencia al siguiente nodo

    public Node(T dato) {
        this.dato = dato; // asigna el valor al nodo
        this.siguiente = null; // inicialmente no apunta a nada
    }
}