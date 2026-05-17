
public class TestAVL {

    public static void main(String[] args) {

        try {

            // =========================================
            // CASO 1
            // =========================================

            LinkedBST<Integer> bst1 =new LinkedBST<>();
            AVLTree<Integer> avl1 =new AVLTree<>();

            int datos1[] ={10,20,30,40,50};

            for(int x : datos1) {
                bst1.insert(x);
                avl1.insert(x);
            }

            System.out.println("\n==========================");
            System.out.println( "BST CASO 1");
            System.out.println("==========================");
            bst1.printTree();
            System.out.println("\nINORDER:" );

            bst1.inOrder();
            System.out.println("ALTURA BST: "+ bst1.height());

            System.out.println("\n==========================");
            System.out.println("AVL CASO 1");
            System.out.println("==========================");

            avl1.printTree();

            System.out.println("\nINORDER:" );
            avl1.inOrder();
            System.out.println( "ALTURA AVL: " + avl1.height());

            // =========================================
            // BÚSQUEDA
            // =========================================

            System.out.println( "\nBUSCAR 40 BST:");
            System.out.println( bst1.search(40) );
            System.out.println(  "\nBUSCAR 40 AVL:");
            System.out.println(avl1.search(40));

            // =========================================
            // CASO 2
            // =========================================

            LinkedBST<Integer> bst2 =new LinkedBST<>();
            AVLTree<Integer> avl2 =new AVLTree<>();
            int datos2[] ={50,40,30,20,10};

            for(int x : datos2) {
                bst2.insert(x);
                avl2.insert(x);
            }


            System.out.println("\n==========================");
            System.out.println("BST CASO 2");
            System.out.println("==========================");
            bst2.printTree();
            System.out.println("\nINORDER:");
            bst2.inOrder();
            System.out.println("ALTURA BST: "+ bst2.height());

            System.out.println("\n==========================");
            System.out.println("AVL CASO 2");
            System.out.println("==========================");
            avl2.printTree();
            System.out.println("\nINORDER:");
            avl2.inOrder();
            System.out.println("ALTURA AVL: "+ avl2.height());

            // =========================================
            // BÚSQUEDA
            // =========================================

            System.out.println( "\nBUSCAR 20 BST:");
            System.out.println(bst2.search(20));
            System.out.println("\nBUSCAR 20 AVL:");
            System.out.println(avl2.search(20));
        }

        catch(Exception e) {

            System.out.println("ERROR: "+ e.getMessage());
        }
    }
}