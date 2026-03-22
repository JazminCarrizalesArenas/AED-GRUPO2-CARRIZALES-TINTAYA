package ejercicios;
public class Golosina {

    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
     //Ejercicio 1: override del método equals para comparar dos objetos de tipo Golosina
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Golosina other = (Golosina) obj;
        return nombre.equals(other.nombre) && peso == other.peso;
    }


    @Override
    public String toString() {
        return "Golosina{nombre='" + nombre + "', peso=" + peso + "}";
    }
}