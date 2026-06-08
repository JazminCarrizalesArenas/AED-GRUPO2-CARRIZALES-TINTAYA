package excepciones;

// Excepción personalizada para errores en las operaciones del árbol B
public class ExcepcionArbolB extends Exception {

    private static final long serialVersionUID = 1L;

    public ExcepcionArbolB(String mensaje) {
        super(mensaje);
    }

    public ExcepcionArbolB(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}