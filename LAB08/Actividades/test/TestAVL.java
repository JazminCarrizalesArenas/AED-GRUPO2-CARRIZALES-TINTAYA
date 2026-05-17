package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

// ACTIVIDAD 3.5
// Prueba de rotaciones AVL
public class TestAVL {
    public static void main(String[] args) {
        probarCaso(
                "CASO II",
                new int[]{30, 20, 10});
        probarCaso(
                "CASO DD",
                new int[]{10, 20, 30});
        probarCaso(
                "CASO ID",
                new int[]{30, 10, 20});

        probarCaso(
                "CASO DI",
                new int[]{10, 30, 20});
    }

    public static void probarCaso(
            String titulo,
            int[] valores) {

        AVLTree avl = new AVLTree();

        System.out.println(
                "\n" + titulo);

        try {

            for (int x : valores) {

                System.out.println(
                        "\nInsertando: " + x);

                avl.insert(x);

                System.out.println();

                avl.printTree();

                System.out.println(
                        "\nEstado: Balanceado");
            }
        } catch (ItemDuplicated e) {

            System.out.println(e.getMessage());
        }
    }
}
