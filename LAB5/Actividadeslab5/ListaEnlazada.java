public class ListaEnlazada<T>{
    Node<T> head; // primer nodo de la lista
    int size; // cantidad de elementos

    public ListaEnlazada(){
        head = null; // lista vacía
        size = 0;
    }

    public void insertar(T dato){
        Node<T> nuevo = new Node<>(dato); // crear nuevo nodo

        if (head == null){
            head = nuevo; // si está vacía, el nuevo es el primero
            size++; // aumentar tamaño
            return;
        }

        Node<T> actual = head;

        // recorrer hasta el último nodo
        while(actual.siguiente != null){
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo; // enlazar al final
        size++; // aumentar tamaño
    }

    public boolean eliminar(T daton) {
        Node<T> actual = head;
        Node<T> anterior = null;

        // recorrer la lista
        while (actual != null) {

            // comparar datos
            if (actual.dato.equals(daton)) {

                // si es el primer nodo
                if (anterior == null) {
                    head = actual.siguiente;
                } else {
                    // saltar el nodo a eliminar
                    anterior.siguiente = actual.siguiente;
                }

                size--; // disminuir tamaño
                return true;
            }

            anterior = actual; // avanzar anterior
            actual = actual.siguiente; // avanzar actual
        }

        return false; // no se encontró
    }

    public T get(int index){
        // validar rango
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<T> actual = head;

        // recorrer hasta el índice
        for (int i = 0; i < index; i++){
            actual = actual.siguiente;
        }

        return actual.dato; // retornar dato
    }

    public int size(){
        return size; // devolver cantidad de elementos
    }
}