package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;

// ACTIVIDAD 1
// Inserciones AVL
public class TestActividad1 {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        int[] datos = {
                30, 15, 20, 50, 40,
                60, 70, 10, 25,
                45, 55, 65, 75
        };

        try {

            System.out.println(
                    "ACTIVIDAD 1 - INSERCIÓN AVL");

            for (int x : datos) {

                System.out.println(
                        "\nInsertando: " + x);

                avl.insert(x);

                System.out.println();

                avl.printTree();

                System.out.println(
                        "\nEstado: Balanceado");
            }

            System.out.println(
                    "\nRECORRIDO INORDER");

            avl.inOrder();

        } catch (ItemDuplicated e) {

            System.out.println(e.getMessage());
        }
    }
}