package actividad1;

// Implementación de cola con arreglo circular
public class QueueArray<E> {

    private E[] array;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public QueueArray(int n) {
        array = (E[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(E x) {
        if (isFull()) throw new RuntimeException("Cola llena");
        rear = (rear + 1) % array.length;
        array[rear] = x;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E val = array[front];
        front = (front + 1) % array.length;
        size--;
        return val;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }
}