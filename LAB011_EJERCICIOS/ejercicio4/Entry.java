package ejercicio4;

// Representa una celda de la tabla hash con su estado
public class Entry {

    public static final int EMPTY = 0;
    public static final int OCCUPIED = 1;
    public static final int DELETED = 2;

    private int clave;
    private int estado;

    public Entry() {
        this.clave = -1;
        this.estado = EMPTY;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String nombreEstado() {
        if (estado == EMPTY) return "EMPTY";
        if (estado == OCCUPIED) return "OCCUPIED";
        return "DELETED";
    }
}
