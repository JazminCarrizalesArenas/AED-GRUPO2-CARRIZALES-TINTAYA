// EJERCICIO 2: COLA CON ARREGLO (QueueArray)
package actividadColaArreglo;

import actividad1.ExceptionIsEmpty;

class QueueArray<E> implements Queue<E> {

    private E[] array; // Arreglo que almacena los elementos
    private int front, rear, size; // Índices y tamaño actual

    @SuppressWarnings("unchecked")
    public QueueArray(int n) {
        array = (E[]) new Object[n]; // Se crea el arreglo
        front = 0; 
        rear = -1; 
        size = 0;
    }

    public void enqueue(E x) {
        if (isFull()) throw new RuntimeException("Cola llena"); // Verifica si está llena
        rear = (rear + 1) % array.length; // Movimiento circular
        array[rear] = x; // Inserta el elemento
        size++; // Aumenta tamaño
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía"); // Verifica vacío
        E val = array[front]; // Obtiene el valor del frente
        front = (front + 1) % array.length; // Avanza circularmente
        size--; // Reduce tamaño
        return val;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return array[front]; // Retorna el frente
    }

    public boolean isEmpty() { return size == 0; } // Cola vacía si size es 0

    private boolean isFull() { return size == array.length; } // Cola llena

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[(front + i) % array.length]); // Acceso circular
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) throws ExceptionIsEmpty {
        QueueArray<String> q = new QueueArray<>(6);
        q.enqueue("Lima"); q.enqueue("Arequipa"); q.enqueue("Cusco");
        System.out.println("Cola: " + q);
        System.out.println("front(): " + q.front());
        System.out.println("dequeue(): " + q.dequeue());
        System.out.println("Cola tras dequeue: " + q);
        q.enqueue("Puno");
        System.out.println("Tras enqueue(Puno): " + q);
    }
}