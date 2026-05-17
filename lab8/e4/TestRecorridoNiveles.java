// =====================================================
// MAIN
// =====================================================
public class TestRecorridoNiveles {

    public static void main(String[] args) {

        try {

            // =========================================
            // ÁRBOL AVL 1
            // =========================================
            AVLTree<Integer> avl1 =
                    new AVLTree<>();

            int datos1[] =
                    {30,10,20,40,50,25};

            for(int x : datos1) {

                avl1.insert(x);
            }

            System.out.println("\n==========================");
            System.out.println("AVL 1");
            System.out.println("==========================");

            avl1.printTree();

            System.out.println("\nRECORRIDO INORDER:");
            avl1.inOrder();

            System.out.println("\nRECORRIDO POR NIVELES:");
            avl1.recorridoPorNiveles();

            // =========================================
            // ÁRBOL AVL 2
            // =========================================
            AVLTree<Integer> avl2 =
                    new AVLTree<>();

            int datos2[] =
                    {50,40,30,20,10,60,70};

            for(int x : datos2) {

                avl2.insert(x);
            }

            System.out.println("\n==========================");
            System.out.println("AVL 2");
            System.out.println("==========================");

            avl2.printTree();

            System.out.println("\nRECORRIDO INORDER:");
            avl2.inOrder();

            System.out.println("\nRECORRIDO POR NIVELES:");
            avl2.recorridoPorNiveles();
        }

        catch(Exception e) {

            System.out.println(
                    "ERROR: "
                            + e.getMessage()
            );
        }
    }
}