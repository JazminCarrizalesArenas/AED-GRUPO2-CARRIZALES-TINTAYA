package btree;

import java.util.ArrayList;

public class BNode<E> {

    private static int contadorGlobal = 0;

    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected int idNodo;

    public BNode(int n) {
        this.keys   = new ArrayList<E>(n);
        this.childs = new ArrayList<BNode<E>>(n + 1);
        this.count  = 0;
        this.idNodo = ++contadorGlobal;

        for (int i = 0; i < n; i++) {
            this.keys.add(null);
        }
        for (int i = 0; i <= n; i++) {
            this.childs.add(null);
        }
    }

    // Reinicia el contador de IDs entre pruebas independientes
    public static void reiniciarContador() {
        contadorGlobal = 0;
    }

    // Retorna true si el nodo está lleno
    public boolean nodoLleno(int maxClaves) {
        return this.count == maxClaves;
    }

    // Retorna true si el nodo no tiene claves
    public boolean nodoVacio() {
        return this.count == 0;
    }

    // Busca la clave en el nodo; si la encuentra retorna true y su posición,
    // si no retorna false y la posición del hijo por el que descender
    @SuppressWarnings("unchecked")
    public boolean buscarEnNodo(E cl, int[] pos) {
        int i = 0;
        Comparable<E> clave = (Comparable<E>) cl;

        while (i < this.count && clave.compareTo(this.keys.get(i)) > 0) {
            i++;
        }

        if (i < this.count && clave.compareTo(this.keys.get(i)) == 0) {
            pos[0] = i;
            return true;
        }

        pos[0] = i;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nodo[id=").append(idNodo).append("] claves: (");
        for (int i = 0; i < count; i++) {
            sb.append(keys.get(i));
            if (i < count - 1) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }
}
