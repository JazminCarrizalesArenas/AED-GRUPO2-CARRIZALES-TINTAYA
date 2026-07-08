package ejer2;

public class BST {

    NodoBST raiz;

    public void insertar(int dato) {
        raiz = insertar(raiz, dato);
    }

    private NodoBST insertar(NodoBST nodo, int dato) {
        if (nodo == null) return new NodoBST(dato);

        if (dato < nodo.dato)
            nodo.izq = insertar(nodo.izq, dato);
        else if (dato > nodo.dato)
            nodo.der = insertar(nodo.der, dato);

        return nodo;
    }

    public boolean buscar(int dato) {
        return buscar(raiz, dato);
    }

    private boolean buscar(NodoBST nodo, int dato) {
        if (nodo == null) return false;
        if (nodo.dato == dato) return true;

        return dato < nodo.dato
                ? buscar(nodo.izq, dato)
                : buscar(nodo.der, dato);
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(NodoBST nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.izq), altura(nodo.der));
    }

    public void inorden() {
        inorden(raiz);
        System.out.println();
    }

    private void inorden(NodoBST nodo) {
        if (nodo != null) {
            inorden(nodo.izq);
            System.out.print(nodo.dato + " ");
            inorden(nodo.der);
        }
    }
}