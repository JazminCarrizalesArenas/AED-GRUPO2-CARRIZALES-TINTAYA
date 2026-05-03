// EJERCICIO 3: COLA DE PRIORIDAD CON MÚLTIPLES COLAS
package actividadPrioridadColas;

import actividad1.ExceptionIsEmpty;
import actividad1.QueueArray;

public class PriorityQueueMulti<E> {

    private QueueArray<E>[] queues; // Arreglo de colas por nivel
    private int levels; // Número de niveles de prioridad

    @SuppressWarnings("unchecked")
    public PriorityQueueMulti(int levels, int capacity) {
        this.levels = levels;
        queues = new QueueArray[levels]; // Se crea arreglo de colas
        for (int i = 0; i < levels; i++)
            queues[i] = new QueueArray<>(capacity); // Inicializa cada cola
    }

    public void enqueue(E x, int priority) {
        queues[priority].enqueue(x); // Inserta en el nivel correspondiente
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = levels - 1; i >= 0; i--) { // Recorre de mayor a menor prioridad
            if (!queues[i].isEmpty())
                return queues[i].dequeue(); // Retorna el primero disponible
        }
        throw new ExceptionIsEmpty("All queues are empty");
    }

    public E front() throws ExceptionIsEmpty {
        for (int i = levels - 1; i >= 0; i--) {
            if (!queues[i].isEmpty())
                return queues[i].front(); // Consulta el primero disponible
        }
        throw new ExceptionIsEmpty("All queues are empty");
    }

    public boolean isEmpty() {
        for (int i = 0; i < levels; i++)
            if (!queues[i].isEmpty()) return false; // Si alguna cola tiene elementos
        return true;
    }

    public static void main(String[] args) throws ExceptionIsEmpty {
        PriorityQueueMulti<String> pq = new PriorityQueueMulti<>(3, 10);
        pq.enqueue("A", 0);
        pq.enqueue("B", 2);
        pq.enqueue("C", 1);
        pq.enqueue("D", 2);
        System.out.println("Orden de salida:");
        while (!pq.isEmpty())
            System.out.print(pq.dequeue() + " ");
    }
}