package ejer4;

public class AVLTree {

    Nodo raiz;

    // ================= INSERTAR AVL =================
    public void insertar(int dato) {
        raiz = insertar(raiz, dato);
    }

    private Nodo insertar(Nodo n, int dato) {

        if (n == null) return new Nodo(dato);

        if (dato < n.dato)
            n.izq = insertar(n.izq, dato);
        else if (dato > n.dato)
            n.der = insertar(n.der, dato);

        return n;
    }

    // ================= ALTURA =================
    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo n) {
        if (n == null) return 0;
        return 1 + Math.max(altura(n.izq), altura(n.der));
    }

    // ================= BFS RECURSIVO =================
    public void recorridoPorNiveles() {
        int h = altura();
        for (int i = 1; i <= h; i++) {
            imprimirNivel(raiz, i);
        }
        System.out.println();
    }

    private void imprimirNivel(Nodo n, int nivel) {
        if (n == null) return;

        if (nivel == 1) {
            System.out.print(n.dato + " ");
        } else {
            imprimirNivel(n.izq, nivel - 1);
            imprimirNivel(n.der, nivel - 1);
        }
    }

    // OTROS RECORRIDOS
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

    public void preorden() {
        preorden(raiz);
        System.out.println();
    }

    private void preorden(Nodo n) {
        if (n != null) {
            System.out.print(n.dato + " ");
            preorden(n.izq);
            preorden(n.der);
        }
    }
}