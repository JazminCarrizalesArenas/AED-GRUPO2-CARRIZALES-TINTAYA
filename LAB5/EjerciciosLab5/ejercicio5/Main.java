package ejercicio5;
public class Main {
    // comparar listas
    public static <T> boolean sonIguales(ListaEnlazada<T> a, ListaEnlazada<T> b) {

        // si tamaños distintos
        if (a.size() != b.size()) return false;

        // comparar elemento por elemento
        for (int i = 0; i < a.size(); i++) {

            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        ListaEnlazada<String> l1 = new ListaEnlazada<>();
        ListaEnlazada<String> l2 = new ListaEnlazada<>();
        l1.insertar("A");
        l1.insertar("B");

        l2.insertar("A");
        l2.insertar("B");

        // comparar
        System.out.println("¿Iguales? " + sonIguales(l1, l2));
    }
}