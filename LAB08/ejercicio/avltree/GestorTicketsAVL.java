package avltree;

import exceptions.*;

public class GestorTicketsAVL {

    public static void main(String[] args) {

        AVLTree<Integer> avl = new AVLTree<>();

        try {
            int[] tickets = {30, 10, 20, 40, 50, 25};

            for (int t : tickets) {
                avl.insert(t);
                System.out.print("InOrden: ");
                avl.inOrder();
            }

            System.out.println("\nBuscar 20: " + avl.search(20));

            try {
                avl.search(60);
            } catch (ItemNoFound e) {
                System.out.println("60 no encontrado");
            }

            avl.delete(10);
            avl.inOrder();

            avl.delete(40);
            avl.inOrder();

            avl.delete(30);
            avl.inOrder();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}