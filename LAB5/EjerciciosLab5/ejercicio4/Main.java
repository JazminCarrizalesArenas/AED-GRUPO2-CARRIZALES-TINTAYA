package ejercicio4;

public class Main {
    // contar nodos
    public static <T> int contarNodos(Node<T> head) {

        int count = 0; // contador
        Node<T> actual = head;

        // recorrer lista
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }

        return count;
    }
    public static void main(String[] args) {

        Node<Integer> head = null;

        head = new Node<>(1);
        head.siguiente = new Node<>(2);
        head.siguiente.siguiente = new Node<>(3);

        // mostrar cantidad
        System.out.println("Total: " + contarNodos(head));
    }
}