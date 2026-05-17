package exceptions;

// Excepción para árbol vacío
public class ExceptionIsEmpty extends Exception {

    public ExceptionIsEmpty(String message) {
        super(message);
    }
}