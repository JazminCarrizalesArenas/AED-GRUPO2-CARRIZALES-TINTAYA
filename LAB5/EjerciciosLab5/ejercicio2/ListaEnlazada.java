package ejercicio2;
public class ListaEnlazada<T>{
    Node<T> head; // primer nodo de la lista
    int size; // cantidad de elementos
    public ListaEnlazada(){
        head = null; // lista vacía
        size = 0;
    }
    // insertar al final
    public void insertar(T dato){
        Node<T> nuevo = new Node<>(dato);

        if (head == null){
            head = nuevo;
            size++;
            return;
        }

        Node<T> actual = head;
        while(actual.siguiente != null){
            actual = actual.siguiente;
        }

        actual.siguiente = nuevo;
        size++;
    }
    // obtener elemento por índice
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<T> actual = head;
        for (int i = 0; i < index; i++){
            actual = actual.siguiente;
        }

        return actual.dato;
    }
    public int size(){
        return size; // devolver cantidad de elementos
    }
}