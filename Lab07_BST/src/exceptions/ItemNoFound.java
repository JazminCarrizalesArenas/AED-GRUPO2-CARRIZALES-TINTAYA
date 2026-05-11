package exceptions;

// Excepción personalizada para elementos no encontrados en el BST
public class ItemNoFound extends Exception {

    // Constructor que recibe un mensaje de error
    public ItemNoFound(String msg) {
        super(msg);
    }

    // Constructor vacío
    public ItemNoFound() {
        super();
    }
}


