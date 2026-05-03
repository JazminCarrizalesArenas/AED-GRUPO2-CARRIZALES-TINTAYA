package actividad1;

// Excepción personalizada para estructuras vacías
public class ExceptionIsEmpty extends Exception {

    public ExceptionIsEmpty(String mensaje) {
        super(mensaje);
    }
}