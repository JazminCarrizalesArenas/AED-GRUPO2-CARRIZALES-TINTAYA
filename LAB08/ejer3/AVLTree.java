package ejer3;

public class AVLTree {

    Nodo raiz;

    // INSERTAR 
    public void insertar(int dato) {
        raiz = insertar(raiz, dato);
    }

    private Nodo insertar(Nodo n, int dato) {

        if (n == null) return new Nodo(dato);

        if (dato < n.dato)
            n.izq = insertar(n.izq, dato);
        else if (dato > n.dato)
            n.der = insertar(n.der, dato);
        else
            return n;

        actualizar(n);
        return balancear(n, dato);
    }

    // ELIMINAR 
    public void eliminar(int dato) {
        raiz = eliminar(raiz, dato);
    }

    private Nodo eliminar(Nodo n, int dato) {

        if (n == null) return null;

        // 1. Buscar
        if (dato < n.dato) {
            n.izq = eliminar(n.izq, dato);
        } else if (dato > n.dato) {
            n.der = eliminar(n.der, dato);
        } else {

            // CASO 1: hoja
            if (n.izq == null && n.der == null) {
                return null;
            }

            // CASO 2: un hijo
            if (n.izq == null) return n.der;
            if (n.der == null) return n.izq;

            // CASO 3: dos hijos (sucesor inorden)
            Nodo sucesor = minimo(n.der);
            n.dato = sucesor.dato;
            n.der = eliminar(n.der, sucesor.dato);
        }

        actualizar(n);
        return balancearEliminacion(n);
    }

    private Nodo minimo(Nodo n) {
        while (n.izq != null)
            n = n.izq;
        return n;
    }

    //  BALANCEO 
    private void actualizar(Nodo n) {
        n.bf = altura(n.der) - altura(n.izq);
    }

    private Nodo balancear(Nodo n, int dato) {

        if (n.bf > 1) {
            if (dato < n.der.dato)
                n.der = rotarDerecha(n.der);
            return rotarIzquierda(n);
        }

        if (n.bf < -1) {
            if (dato > n.izq.dato)
                n.izq = rotarIzquierda(n.izq);
            return rotarDerecha(n);
        }

        return n;
    }

    private Nodo balancearEliminacion(Nodo n) {

        if (n.bf > 1) {

            if (n.der != null && n.der.bf < 0)
                n.der = rotarDerecha(n.der);

            return rotarIzquierda(n);
        }

        if (n.bf < -1) {

            if (n.izq != null && n.izq.bf > 0)
                n.izq = rotarIzquierda(n.izq);

            return rotarDerecha(n);
        }

        return n;
    }

    //  ROTACIONES 
    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.der;
        Nodo t = y.izq;

        y.izq = x;
        x.der = t;

        actualizar(x);
        actualizar(y);

        return y;
    }

    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izq;
        Nodo t = x.der;

        x.der = y;
        y.izq = t;

        actualizar(y);
        actualizar(x);

        return x;
    }

    //  ALTURA 
    private int altura(Nodo n) {
        if (n == null) return 0;
        return 1 + Math.max(altura(n.izq), altura(n.der));
    }

    public int altura() {
        return altura(raiz);
    }

    // RECORRIDO 
    public void inorden() {
        inorden(raiz);
        System.out.println();
    }

    private void inorden(Nodo n) {
        if (n != null) {
            inorden(n.izq);
            System.out.print(n.dato + " ");
            inorden(n.der);
        }
    }
}