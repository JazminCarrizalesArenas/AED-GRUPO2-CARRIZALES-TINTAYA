package ejercicio2;

public class Main {

    // método que invierte una lista
    public static <T> ListaEnlazada<T> invertirLista(ListaEnlazada<T> lista) {

        // crear nueva lista
        ListaEnlazada<T> invertida = new ListaEnlazada<>();

        // recorrer desde el final al inicio
        for (int i = lista.size() - 1; i >= 0; i--) {

            // insertar en nueva lista
            invertida.insertar(lista.get(i));
        }

        return invertida; // devolver lista invertida
    }

    public static void main(String[] args) {

        // crear lista
        ListaEnlazada<String> lista = new ListaEnlazada<>();

        // insertar datos
        lista.insertar("A");
        lista.insertar("B");
        lista.insertar("C");

        // invertir lista
        ListaEnlazada<String> inv = invertirLista(lista);

        // imprimir lista invertida
        for (int i = 0; i < inv.size(); i++) {
            System.out.println(inv.get(i));
        }
    }
}