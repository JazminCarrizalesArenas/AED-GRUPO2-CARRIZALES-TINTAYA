package test;

import avltree.AVLTree;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
// ACTIVIDAD 2
// Eliminación AVL
public class TestActividad2 {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        int[] insertar = {
                45, 33, 56, 12, 40,
                50, 60, 46, 59
        };

        int[] eliminar = {
                12, 33, 46, 59, 45, 56
        };

        try {
            // Insertar nodos
            for (int x : insertar) {

                avl.insert(x);
            }
            System.out.println(
                    "ACTIVIDAD 2 - ELIMINACIÓN AVL");

            System.out.println(
                    "\nÁrbol inicial\n");

            avl.printTree();

            System.out.println(
                    "\nEstado: Balanceado");
            // Eliminaciones
            for (int x : eliminar) {

                System.out.println(
                        "\nEliminando: " + x);

                avl.delete(x);

                System.out.println();

                avl.printTree();

                System.out.println(
                        "\nEstado: Balanceado");
            }
        } catch (ItemDuplicated |
                 ItemNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}