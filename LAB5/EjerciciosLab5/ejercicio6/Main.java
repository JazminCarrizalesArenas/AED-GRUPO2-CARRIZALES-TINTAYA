package ejercicio6;
public class Main {
    // concatenar listas
    public static <T> ListaEnlazada<T> concatenarListas(ListaEnlazada<T> a, ListaEnlazada<T> b) {
        ListaEnlazada<T> resultado = new ListaEnlazada<>();
        // copiar lista A
        for (int i = 0; i < a.size(); i++) {
            resultado.insertar(a.get(i));
        }
        // copiar lista B
        for (int i = 0; i < b.size(); i++) {
            resultado.insertar(b.get(i));
        }

        return resultado;
    }

    public static void main(String[] args) {
        ListaEnlazada<String> a = new ListaEnlazada<>();
        ListaEnlazada<String> b = new ListaEnlazada<>();
        a.insertar("A");
        a.insertar("B");

        b.insertar("C");
        b.insertar("D");
        ListaEnlazada<String> res = concatenarListas(a, b);

        // imprimir resultado
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}