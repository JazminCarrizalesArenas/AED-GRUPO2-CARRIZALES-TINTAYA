package ejercicio3;

public class Main {
    // insertar nodo al final
    public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> nuevo = new Node<>(valor); // crear nodo
        // si lista vacía
        if (head == null) return nuevo;
        Node<T> actual = head;
        // recorrer hasta el último
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo; // insertar
        return head;
    }

    public static void main(String[] args) {
        Node<String> head = null;
        // insertar nodos
        head = insertarAlFinal(head, "A");
        head = insertarAlFinal(head, "B");

        // imprimir lista
        Node<String> temp = head;
        while (temp != null) {
            System.out.println(temp.dato);
            temp = temp.siguiente;
        }
    }
}