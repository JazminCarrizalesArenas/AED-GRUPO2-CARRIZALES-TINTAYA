public class TestAVLRotaciones {

    public static void main(String[] args) {

        try {

            AVLTree<Integer> avl =
                    new AVLTree<>();

            // =========================================
            // INSERTAR ELEMENTOS
            // =========================================

            int datos[] =
                    {30,20,10,40,50,25,27};

            System.out.println("\n==========================");
            System.out.println("INSERTANDO ELEMENTOS");
            System.out.println("==========================");

            for(int x : datos) {

                avl.insert(x);
            }

            // =========================================
            // MOSTRAR ÁRBOL
            // =========================================

            System.out.println("\n==========================");
            System.out.println("ÁRBOL AVL");
            System.out.println("==========================");

            avl.printTree();

            // =========================================
            // RECORRIDOS
            // =========================================

            System.out.println("\nINORDER:");
            avl.inOrder();

            System.out.println("\nPREORDER:");
            avl.preOrder();

            System.out.println("\nPOR NIVELES:");
            avl.recorridoPorNiveles();

            // =========================================
            // ELIMINAR 50
            // =========================================

            System.out.println("\n==========================");
            System.out.println("ELIMINANDO 50");
            System.out.println("==========================");

            avl.delete(50);

            avl.printTree();

            // =========================================
            // ELIMINAR 40
            // =========================================

            System.out.println("\n==========================");
            System.out.println("ELIMINANDO 40");
            System.out.println("==========================");

            avl.delete(40);

            avl.printTree();

            // =========================================
            // ELIMINAR 30
            // =========================================

            System.out.println("\n==========================");
            System.out.println("ELIMINANDO 30");
            System.out.println("==========================");

            avl.delete(30);

            avl.printTree();

            // =========================================
            // RECORRIDOS FINALES
            // =========================================

            System.out.println("\n==========================");
            System.out.println("ÁRBOL FINAL");
            System.out.println("==========================");

            System.out.println("\nINORDER:");
            avl.inOrder();

            System.out.println("\nPREORDER:");
            avl.preOrder();

            System.out.println("\nPOR NIVELES:");
            avl.recorridoPorNiveles();
        }

        catch(Exception e) {

            System.out.println(
                    "ERROR: "
                            + e.getMessage()
            );
        }
    }
}