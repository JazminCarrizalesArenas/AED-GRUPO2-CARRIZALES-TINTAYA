public class Main {
    public static void main(String[] args) {

        // 1. Crear instancia
        GestorDeTareas gestor = new GestorDeTareas();

        // 2. Agregar tareas
        Tarea t1 = new Tarea("Estudiar", 3);
        Tarea t2 = new Tarea("Dormir", 1);
        Tarea t3 = new Tarea("Comer", 2);

        gestor.agregarTarea(t1);
        gestor.agregarTarea(t2);
        gestor.agregarTarea(t3);

        Tarea tareaMasPrioritaria = gestor.obtenerTareaMasPrioritaria();
        System.out.println("\nTarea más prioritaria: " + tareaMasPrioritaria.getTitulo());
        
        gestor.contabilizarTareas(); 
        // 4. Imprimir tareas
        System.out.println("\nTareas actuales:");
        gestor.imprimirTareas();

        // 5. Verificar si existe una tarea
        System.out.println("\n¿Existe 'Dormir'? " + gestor.contieneTarea(t2));

        // 3. Eliminar una tarea
        gestor.eliminarTarea(t2);
        System.out.println("\nDespués de eliminar 'Dormir':");
        gestor.imprimirTareas();

        // 6. Invertir lista
        gestor.invertirTareas();
        System.out.println("\nLista invertida:");
        gestor.imprimirTareas();

        System.out.println("\nTareas pendientes:");
        gestor.imprimirTareas();

    }
}