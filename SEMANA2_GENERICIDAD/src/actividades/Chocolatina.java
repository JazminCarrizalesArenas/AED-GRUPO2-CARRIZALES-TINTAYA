package actividades;
public class Chocolatina {

    private String marca;

    public Chocolatina(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    //Ejercicio 1: override del método equals para comparar dos objetos de tipo Chocolatina
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Chocolatina other = (Chocolatina) obj;
        return marca.equals(other.marca);
    }

    @Override
    public String toString() {
        return "Chocolatina{marca='" + marca + "'}";
    }
}