public class GestorTicketsAVL {

    public static void main(String[] args) {

        AVLTree<Integer> avl =
                new AVLTree<>();

        LinkedBST<Integer> bst =
                new LinkedBST<>();

        try {

            // =========================================
            // INSERTAR DATOS
            // =========================================
            int datos[] = {30, 10, 20, 40, 50, 25};

            System.out.println("\n=================================");
            System.out.println("INSERTANDO EN AVL");
            System.out.println("=================================");

            for (int x : datos) {
                avl.insert(x);
            }

            // =========================================
            // RECORRIDO AVL
            // =========================================
            System.out.println("\n=================================");
            System.out.println("INORDER AVL");
            System.out.println("=================================");

            avl.inOrder();

            // =========================================
            // BÚSQUEDA 20
            // =========================================
            System.out.println("\n=================================");
            System.out.println("BUSCANDO 20");
            System.out.println("=================================");

            System.out.println("Encontrado: " + avl.search(20));

            // =========================================
            // BÚSQUEDA 60
            // =========================================
            System.out.println("\n=================================");
            System.out.println("BUSCANDO 60");
            System.out.println("=================================");

            try {

                avl.search(60);

            } catch (ItemNotFound e) {

                System.out.println("60 no existe");
            }

            // =========================================
            // ELIMINAR 10
            // =========================================
            System.out.println("\n=================================");
            System.out.println("ELIMINANDO 10");
            System.out.println("=================================");

            avl.delete(10);

            avl.printTree();

            // =========================================
            // ELIMINAR 40
            // =========================================
            System.out.println("\n=================================");
            System.out.println("ELIMINANDO 40");
            System.out.println("=================================");

            avl.delete(40);

            avl.printTree();

            // =========================================
            // ELIMINAR 30
            // =========================================
            System.out.println("\n=================================");
            System.out.println("ELIMINANDO 30");
            System.out.println("=================================");

            avl.delete(30);

            avl.printTree();
        }

        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}