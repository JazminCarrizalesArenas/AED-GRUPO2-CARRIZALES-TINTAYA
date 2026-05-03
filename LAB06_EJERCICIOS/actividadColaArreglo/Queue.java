package actividadColaArreglo;

import actividad1.ExceptionIsEmpty;

public interface Queue<E> {

    void enqueue(E x); // Inserta un elemento en la cola

    E dequeue() throws ExceptionIsEmpty; // Elimina el elemento del frente

    E front() throws ExceptionIsEmpty; // Consulta el frente sin eliminar

    boolean isEmpty(); // Verifica si la cola está vacía
}


