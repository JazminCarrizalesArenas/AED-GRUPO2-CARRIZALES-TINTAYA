// EJERCICIO 1: PILA CON LISTA ENLAZADA (StackLink)
package actividadPilaLista;

import actividad1.ExceptionIsEmpty;

class StackLink<E> implements Stack<E> {

    private Node<E> top; // Referencia al nodo tope de la pila

    public StackLink() { 
        this.top = null; // Inicializa la pila vacía
    }

    public void push(E x) {                  // O(1)
        Node<E> node = new Node<>(x); // Se crea un nuevo nodo con el dato
        node.setNext(top);   // El nuevo nodo apunta al antiguo tope
        top = node;          // El nuevo nodo pasa a ser el tope
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty"); // Verifica si está vacía
        E val = top.getData(); // Guarda el dato del tope
        top = top.getNext();   // El tope avanza al siguiente nodo
        return val;            // Retorna el dato eliminado
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Stack is empty"); // Verifica si está vacía
        return top.getData(); // Retorna el dato del tope
    }

    public boolean isEmpty() { 
        return top == null; // La pila está vacía si top es null
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[TOP] "); 
        Node<E> cur = top; // Empieza desde el tope
        while (cur != null) { // Recorre toda la pila
            sb.append(cur.getData()); 
            if (cur.getNext() != null) sb.append(" -> "); // Flecha entre nodos
            cur = cur.getNext(); // Avanza al siguiente nodo
        }
        return sb.toString(); 
    }

    public static void main(String[] args) throws ExceptionIsEmpty {
        StackLink<Integer> s = new StackLink<>();
        s.push(10); s.push(20); s.push(30); // Inserta elementos
        System.out.println("Pila: " + s);
        System.out.println("top():  " + s.top()); // Consulta el tope
        System.out.println("pop():  " + s.pop()); // Elimina el tope
        System.out.println("Pila tras pop: " + s);
        s.push(99); // Inserta nuevo elemento
        System.out.println("Tras push(99): " + s);
    }
}