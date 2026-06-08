package ejercicio4;

import btree.BTree;
import excepciones.ExcepcionArbolB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Biblioteca {

    private BTree<Libro> arbolLibros;
    private int totalLibros;

    public Biblioteca(int ordenArbol) {
        this.arbolLibros = new BTree<>(ordenArbol);
        this.totalLibros = 0;
    }

    // Agrega un libro al árbol B
    public void agregarLibro(Libro libro) throws ExcepcionArbolB {
        if (libro == null) throw new ExcepcionArbolB("No se puede agregar un libro nulo.");
        arbolLibros.insertar(libro);
        totalLibros++;
    }

    // Busca un libro por ISBN mostrando el camino recorrido en el árbol B
    public boolean buscarPorIsbn(String isbn) throws ExcepcionArbolB {
        if (isbn == null || isbn.isBlank())
            throw new ExcepcionArbolB("El ISBN no puede estar vacío.");
        Libro clave = new Libro(isbn, "", "", 0);
        return arbolLibros.searchConCamino(clave);
    }

    // Elimina un libro por ISBN
    public void eliminarLibro(String isbn) throws ExcepcionArbolB {
        if (isbn == null || isbn.isBlank())
            throw new ExcepcionArbolB("El ISBN no puede estar vacío.");
        Libro clave = new Libro(isbn, "", "", 0);
        arbolLibros.remove(clave);
        totalLibros--;
    }

    // Muestra todos los libros en orden ascendente por ISBN
    public void mostrarLibrosOrdenados() {
        java.util.List<Libro> lista = new java.util.ArrayList<>();
        arbolLibros.recolectarInOrden(lista);
        for (Libro l : lista) {
            System.out.println(l.toDetalle());
        }
    }

    // Muestra la estructura interna del árbol B
    public void mostrarEstructuraArbol() {
        System.out.println(arbolLibros);
    }

    public int obtenerAltura() {
        return arbolLibros.altura();
    }

    public int obtenerTotalLibros() {
        return totalLibros;
    }

    // Carga libros desde un archivo: primera línea = orden del árbol,
    // luego líneas con formato ISBN,título,autor,año
    public static Biblioteca cargarDesdeArchivo(String rutaArchivo) throws IOException, ExcepcionArbolB {
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String primeraLinea = lector.readLine();
            if (primeraLinea == null || primeraLinea.isBlank())
                throw new ExcepcionArbolB("El archivo está vacío o no contiene el orden del árbol.");

            int orden;
            try {
                orden = Integer.parseInt(primeraLinea.trim());
                if (orden < 3) throw new ExcepcionArbolB("El orden del árbol debe ser al menos 3.");
            } catch (NumberFormatException e) {
                throw new ExcepcionArbolB("La primera línea debe ser el orden del árbol.");
            }

            Biblioteca biblioteca = new Biblioteca(orden);
            String linea;
            int numeroLinea = 1;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                linea = linea.trim();
                if (linea.isBlank() || linea.startsWith("#")) continue;

                String[] partes = linea.split(",", 4);
                if (partes.length < 4) {
                    System.out.println("Línea " + numeroLinea + " con formato incorrecto, se ignora.");
                    continue;
                }

                String isbn   = partes[0].trim();
                String titulo = partes[1].trim();
                String autor  = partes[2].trim();
                int anio;

                try {
                    anio = Integer.parseInt(partes[3].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Año inválido en línea " + numeroLinea + ", se ignora.");
                    continue;
                }

                biblioteca.agregarLibro(new Libro(isbn, titulo, autor, anio));
            }

            return biblioteca;
        }
    }
}