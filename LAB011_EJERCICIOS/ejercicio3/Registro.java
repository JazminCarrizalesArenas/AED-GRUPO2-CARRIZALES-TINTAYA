package ejercicio3;

// Registro simple con clave entera y nombre
public class Registro {

    private int clave;
    private String nombre;

    public Registro(int clave, String nombre) {
        this.clave = clave;
        this.nombre = nombre;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "(" + clave + ", " + nombre + ")";
    }
}
