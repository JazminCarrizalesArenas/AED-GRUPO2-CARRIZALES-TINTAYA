package ejercicio4;

// Representa un libro con ISBN como clave de comparación para el árbol B
public class Libro implements Comparable<Libro> {

    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn()            { return isbn; }
    public String getTitulo()          { return titulo; }
    public String getAutor()           { return autor; }
    public int    getAnioPublicacion() { return anioPublicacion; }

    // Comparación por ISBN para mantener el orden en el árbol B
    @Override
    public int compareTo(Libro otro) {
        return this.isbn.compareTo(otro.isbn);
    }

    // Devuelve solo el ISBN para que la tabla del árbol sea legible
    @Override
    public String toString() {
        return isbn;
    }

    // Información completa del libro
    public String toDetalle() {
        return String.format("ISBN: %-17s | Título: %-40s | Autor: %-25s | Año: %d",
                isbn, titulo, autor, anioPublicacion);
    }
}