package ejercicio1; // paquete donde está la clase

public class Main {

    // método genérico que busca un elemento en la lista
    public static <T> boolean buscarElemento(ListaEnlazada<T> lista, T valor) {

        // recorre toda la lista usando índices
        for (int i = 0; i < lista.size(); i++) {

            // compara el elemento actual con el valor buscado
            if (lista.get(i).equals(valor)) {
                return true; // si lo encuentra, retorna true
            }
        }

        return false; // si no lo encuentra, retorna false
    }

    public static void main(String[] args) {

        // crear una lista enlazada de tipo String
        ListaEnlazada<String> lista = new ListaEnlazada<>();

        // insertar datos en la lista
        lista.insertar("Juan");
        lista.insertar("Ana");
        lista.insertar("Luis");

        // buscar un elemento en la lista
        boolean existe = buscarElemento(lista, "Ana");

        // mostrar resultado en consola
        System.out.println("¿Existe Ana? " + existe);
    }
}