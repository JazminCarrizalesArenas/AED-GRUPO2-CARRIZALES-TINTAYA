package exceptions;

// Excepción personalizada para indicar que el árbol está vacío
public class ExceptionIsEmpty extends Exception {

    // Constructor que recibe un mensaje de error
    public ExceptionIsEmpty(String msg) {
        super(msg);
    }

    // Constructor vacío
    public ExceptionIsEmpty() {
        super();
    }
}



