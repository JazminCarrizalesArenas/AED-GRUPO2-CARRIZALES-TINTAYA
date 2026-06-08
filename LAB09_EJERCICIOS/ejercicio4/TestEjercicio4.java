package ejercicio4;

import btree.BNode;
import excepciones.ExcepcionArbolB;
import java.io.IOException;

public class TestEjercicio4 {

    public static void main(String[] args) {
        BNode.reiniciarContador();

        Biblioteca biblioteca;

        try {
            biblioteca = Biblioteca.cargarDesdeArchivo("src/ejercicio4/biblioteca.txt");
        } catch (IOException | ExcepcionArbolB e) {
            System.err.println("Error al cargar: " + e.getMessage());
            return;
        }

        System.out.println("Total de libros cargados: " + biblioteca.obtenerTotalLibros());

        System.out.println("Estructura del árbol B:");
        biblioteca.mostrarEstructuraArbol();

        System.out.println("Búsqueda por ISBN (978612200001):");
        try {
            biblioteca.buscarPorIsbn("978612200001");
        } catch (ExcepcionArbolB e) {
            System.err.println("Error en búsqueda: " + e.getMessage());
        }

        System.out.println("Búsqueda por ISBN inexistente (978612200099):");
        try {
            biblioteca.buscarPorIsbn("978612200099");
        } catch (ExcepcionArbolB e) {
            System.err.println("Error en búsqueda: " + e.getMessage());
        }

        System.out.println("Libros ordenados por ISBN:");
        biblioteca.mostrarLibrosOrdenados();

        System.out.println("Altura del árbol: " + biblioteca.obtenerAltura());

        try {
            biblioteca.eliminarLibro("978612200001");
            System.out.println("Libro eliminado. Libros restantes: " + biblioteca.obtenerTotalLibros());
        } catch (ExcepcionArbolB e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}
