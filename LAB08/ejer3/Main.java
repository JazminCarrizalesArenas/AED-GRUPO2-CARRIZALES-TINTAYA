package ejer3;

public class Main {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        int[] datos = {30, 10, 20, 40, 50, 25};

        System.out.println("INSERTANDO: ");
        for (int d : datos) {
            avl.insertar(d);
        }

        System.out.println("\nÁrbol inicial:");
        avl.inorden();
        System.out.println("Altura: " + avl.altura());

        System.out.println("\n ELIMINACIONES ");

        eliminar(avl, 10);
        eliminar(avl, 40);
        eliminar(avl, 30);

        System.out.println("\nÁrbol final:");
        avl.inorden();
        System.out.println("Altura final: " + avl.altura());
    }

    public static void eliminar(AVLTree avl, int valor) {
        System.out.println("\nEliminar: " + valor);
        avl.eliminar(valor);
        System.out.print("Inorden: ");
        avl.inorden();
        System.out.println("Altura: " + avl.altura());
    }
}