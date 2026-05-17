package exceptions;

// Excepción cuando un elemento no existe en el árbol
public class ItemNotFound extends Exception {

    public ItemNotFound(String message) {
        super(message);
    }
}