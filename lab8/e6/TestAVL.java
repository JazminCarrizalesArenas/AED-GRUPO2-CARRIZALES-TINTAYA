// =====================================================
// MAIN
// =====================================================
public class TestAVL {

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

            System.out.println("\nINORDER:");
            avl1.inOrder();

            avl1.preOrder();

            // =========================================
            // ÁRBOL AVL 2
            // =========================================

            AVLTree<Integer> avl2 =
                    new AVLTree<>();

            int datos2[] =
                    {50,30,70,20,40,60,80,10,25,65};

            for(int x : datos2) {

                avl2.insert(x);
            }

            System.out.println("\n==========================");
            System.out.println("AVL 2");
            System.out.println("==========================");

            avl2.printTree();

            System.out.println("\nINORDER:");
            avl2.inOrder();

            avl2.preOrder();

            // =========================================
            // ÁRBOL AVL 3
            // =========================================

            AVLTree<Integer> avl3 =
                    new AVLTree<>();

            int datos3[] =
                    {100,90,80,70,60,50};

            for(int x : datos3) {

                avl3.insert(x);
            }

            System.out.println("\n==========================");
            System.out.println("AVL 3");
            System.out.println("==========================");

            avl3.printTree();

            System.out.println("\nINORDER:");
            avl3.inOrder();

            avl3.preOrder();
        }

        catch(Exception e) {

            System.out.println(
                    "ERROR: "
                            + e.getMessage()
            );
        }
    }
}