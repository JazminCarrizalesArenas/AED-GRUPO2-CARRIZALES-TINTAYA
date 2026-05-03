// actividadEjercicio4/PriorityQueueHybrid.java 
package actividadEjercicio4; 
import actividad1.ExceptionIsEmpty; 
public class PriorityQueueHybrid<E> { 
    // Nodo interno: dato + valor secundario (para orden dentro del nivel) 
    private static class Entry<E> implements Comparable<Entry<E>> { 
        E   data; 
        int secondary; 
        Entry(E data, int secondary) { 
            this.data      = data; 
            this.secondary = secondary; 
        } 

        public int compareTo(Entry<E> o) { 
            return Integer.compare(this.secondary, o.secondary); 
        } 

        public String toString() { 
            return "(" + data + "," + secondary + ")"; 
        } 
    } 
    // Lista enlazada con inserción ordenada ascendente por compareTo 
    private static class SortedLinkedList<T extends Comparable<T>> { 
        private static class Node<T> { 
            T data; Node<T> next; 
            Node(T d) { data = d; } 
        } 
        private Node<T> head = null; 
        void insertSorted(T val) {            // O(m) total — m = elementos en la lista 
            Node<T> nw = new Node<>(val);    // O(1) — crea nodo 
            // Insertar al inicio si está vacía o es el menor 
            if (head == null || val.compareTo(head.data) < 0) {  // O(1) — caso inserción al inicio 
                nw.next = head; head = nw; return;  // O(1) — inserción al frente 
            } 
            Node<T> cur = head;               // O(1) — inicio del recorrido 
            while (cur.next != null && val.compareTo(cur.next.data) >= 0)  // O(m) — recorre hasta posición 
                cur = cur.next;               // O(1) — avanza un nodo 
            nw.next = cur.next;               // O(1) — enlaza nodo nuevo 
            cur.next = nw;                    // O(1) — inserta en posición 
        } 
        T removeFirst() throws ExceptionIsEmpty { 
            if (head == null) throw new ExceptionIsEmpty("Lista vacía"); 
            T val = head.data; head = head.next; return val; 
        } 
        boolean isEmpty() { return head == null; } 
        public String toString() { 
            StringBuilder sb = new StringBuilder(); 
            Node<T> cur = head; 
            while (cur != null) { 
                sb.append(cur.data); 
                if (cur.next != null) sb.append(" -> "); 
                cur = cur.next; 
            } 
            return sb.length() == 0 ? "(vacío)" : sb.toString(); 
        } 
    } 
    private SortedLinkedList<Entry<E>>[] levels; 
    private int numLevels; 
    @SuppressWarnings("unchecked") 
    public PriorityQueueHybrid(int numLevels) { 
        this.numLevels = numLevels; 
        levels = new SortedLinkedList[numLevels]; 
        for (int i = 0; i < numLevels; i++) 
            levels[i] = new SortedLinkedList<>(); 
    } 
    // priority: nivel de prioridad (0=menor, numLevels-1=mayor) 
    // secondary: valor de orden dentro del nivel (menor → antes) 
    public void enqueue(E x, int priority, int secondary) { 
        levels[priority].insertSorted(new Entry<>(x, secondary));  // O(m) — inserción ordenada en la lista del nivel 
    } 
    public E dequeue() throws ExceptionIsEmpty { 
        for (int i = numLevels - 1; i >= 0; i--)  // O(k) — recorre niveles de mayor a menor 
            if (!levels[i].isEmpty())         // O(1) — verifica nivel 
                return levels[i].removeFirst().data;  // O(1) — removeFirst es O(1) 
        throw new ExceptionIsEmpty("All levels empty");  // O(1) 
    } 
    public void printLevels() { 
        for (int i = numLevels - 1; i >= 0; i--) 
            System.out.println("Nivel " + i + ": " + levels[i]); 
    } 
    public static void main(String[] args) throws ExceptionIsEmpty { 
        PriorityQueueHybrid<String> pq = new PriorityQueueHybrid<>(3); 

        pq.enqueue("A", 2, 5); 
        pq.enqueue("B", 2, 1); 
        pq.enqueue("C", 1, 3); 
        pq.enqueue("D", 2, 3); 

        System.out.println("Estado interno:"); 
        pq.printLevels(); 
        System.out.println("\nOrden de dequeue:"); 

        while (true) { 
            try { System.out.print(pq.dequeue() + " "); } 
            catch (ExceptionIsEmpty e) { break; } 
        } 

        // Nivel 2: (B,1) -> (D,3) -> (A,5) 
        // Nivel 1: (C,3) 
        // Resultado: B D A C 

    } 

} 