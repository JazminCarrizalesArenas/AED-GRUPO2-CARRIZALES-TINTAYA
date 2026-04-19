public class Tarea {
    private String titulo; // nombre de la tarea
    private int prioridad; // prioridad (mayor = más importante)

    public Tarea(String titulo, int prioridad){
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo; // devuelve el título
    }

    public int getPrioridad() {
        return prioridad; // devuelve la prioridad
    }
}