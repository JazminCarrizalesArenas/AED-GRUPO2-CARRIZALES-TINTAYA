package actividadPilaLista;

import actividad1.ExceptionIsEmpty;

public interface Stack<E> {

    void push(E x); // Inserta un elemento en la pila (apilar)

    E pop() throws ExceptionIsEmpty; // Elimina y retorna el elemento del tope

    E top() throws ExceptionIsEmpty; // Retorna el elemento del tope sin eliminarlo

    boolean isEmpty(); // Verifica si la pila está vacía
}


