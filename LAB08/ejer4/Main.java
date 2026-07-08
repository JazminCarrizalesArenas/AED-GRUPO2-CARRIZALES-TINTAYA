package ejer4;

public class Main {

    public static void main(String[] args) {

        System.out.println(" ARBOL 1 ");
        AVLTree a1 = new AVLTree();

        int[] datos1 = {30, 10, 20, 40, 50, 25};
        for (int d : datos1) {
            a1.insertar(d);
        }

        System.out.print("Inorden: ");
        a1.inorden();

        System.out.print("Preorden: ");
        a1.preorden();

        System.out.print("Por niveles (BFS recursivo): ");
        a1.recorridoPorNiveles();

        System.out.println("\nARBOL 2 ");
        AVLTree a2 = new AVLTree();

        int[] datos2 = {50, 30, 70, 20, 40, 60, 80, 10, 25};
        for (int d : datos2) {
            a2.insertar(d);
        }

        System.out.print("Inorden: ");
        a2.inorden();

        System.out.print("Preorden: ");
        a2.preorden();

        System.out.print("Por niveles (BFS recursivo): ");
        a2.recorridoPorNiveles();
    }
}