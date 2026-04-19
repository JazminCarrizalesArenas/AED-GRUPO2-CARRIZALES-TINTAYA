public class GestorDeTareas {
    private ListaEnlazada<Tarea> tareas;
    
    public GestorDeTareas(){
        tareas= new ListaEnlazada<>();
    }
    
    public void agregarTarea(Tarea tarea){
        tareas.insertar(tarea);
        System.out.println("Tarea agregada: " + tarea.getTitulo());
    }

    public boolean eliminarTarea(Tarea tarea){
        return tareas.eliminar(tarea);
    }

    public boolean contieneTarea(Tarea tarea){
        for (int i=0; i<tareas.size(); i++){
            if (tareas.get(i).equals(tarea)){
                return true;
            }
        }
        return false;
    }

    public void imprimirTareas(){
        for (int i = 0; i < tareas.size(); i++){
            Tarea tarea = tareas.get(i);
            System.out.println(tarea.getTitulo());
        }
    }

    public void contabilizarTareas(){
        System.out.println("Número total de tareas: " + tareas.size());
    }

    public Tarea obtenerTareaMasPrioritaria(){
        if (tareas.size() == 0){
            return null;
        }
        Tarea masPrioritaria = tareas.get(0);
        for (int i = 1; i < tareas.size(); i++){
            Tarea tareaActual = tareas.get(i);
            if (tareaActual.getPrioridad() > masPrioritaria.getPrioridad()){
                masPrioritaria = tareaActual;
            }
        }
        return masPrioritaria;
    }

    public void invertirTareas(){
        ListaEnlazada<Tarea> invertida = new ListaEnlazada<>();
        for (int i = tareas.size() - 1; i >= 0; i--){
            invertida.insertar(tareas.get(i));
        }
        tareas = invertida;
    }

}
