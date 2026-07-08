package ejer2;

public class AVLTree {

    NodoAVL raiz;

    public void insertar(int dato) {
        raiz = insertar(raiz, dato);
    }

    private NodoAVL insertar(NodoAVL nodo, int dato) {

        if (nodo == null) return new NodoAVL(dato);

        if (dato < nodo.dato)
            nodo.izq = insertar(nodo.izq, dato);
        else if (dato > nodo.dato)
            nodo.der = insertar(nodo.der, dato);
        else
            return nodo;

        nodo.bf = altura(nodo.der) - altura(nodo.izq);

        // Derecha pesada
        if (nodo.bf > 1) {
            if (dato < nodo.der.dato)
                nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        // Izquierda pesada
        if (nodo.bf < -1) {
            if (dato > nodo.izq.dato)
                nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }

        return nodo;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.der;
        NodoAVL t = y.izq;

        y.izq = x;
        x.der = t;

        actualizar(x);
        actualizar(y);

        return y;
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izq;
        NodoAVL t = x.der;

        x.der = y;
        y.izq = t;

        actualizar(y);
        actualizar(x);

        return x;
    }

    private void actualizar(NodoAVL n) {
        n.bf = altura(n.der) - altura(n.izq);
    }

    private int altura(NodoAVL n) {
        if (n == null) return 0;
        return 1 + Math.max(altura(n.izq), altura(n.der));
    }

    public boolean buscar(int dato) {
        return buscar(raiz, dato);
    }

    private boolean buscar(NodoAVL n, int dato) {
        if (n == null) return false;
        if (n.dato == dato) return true;

        return dato < n.dato
                ? buscar(n.izq, dato)
                : buscar(n.der, dato);
    }

    public int altura() {
        return altura(raiz);
    }

    public void inorden() {
        inorden(raiz);
        System.out.println();
    }

    private void inorden(NodoAVL n) {
        if (n != null) {
            inorden(n.izq);
            System.out.print(n.dato + " ");
            inorden(n.der);
        }
    }
}