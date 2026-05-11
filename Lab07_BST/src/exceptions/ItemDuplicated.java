package exceptions;

// Excepción personalizada para elementos duplicados en el BST
public class ItemDuplicated extends Exception {

    // Constructor que recibe un mensaje de error
    public ItemDuplicated(String msg) {
        super(msg);
    }

    // Constructor vacío
    public ItemDuplicated() {
        super();
    }
}


