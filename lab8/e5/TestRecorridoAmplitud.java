// =====================================================
// MAIN
// =====================================================
public class TestRecorridoAmplitud {

    public static void main(String[] args) {

        try {

            AVLTree<Integer> avl =
                    new AVLTree<>();

            // =========================================
            // INSERTAR DATOS
            // =========================================
            int datos[] =
                    {50,30,70,20,40,60,80,10,25,65};

            for(int x : datos) {

                avl.insert(x);
            }

            // =========================================
            // MOSTRAR ÁRBOL
            // =========================================
            System.out.println(
                    "\n=========================="
            );

            System.out.println(
                    "ÁRBOL AVL"
            );

            System.out.println(
                    "=========================="
            );

            avl.printTree();

            // =========================================
            // RECORRIDO INORDER
            // =========================================
            System.out.println(
                    "\nINORDER:"
            );

            avl.inOrder();

            // =========================================
            // RECORRIDO POR AMPLITUD
            // =========================================
            System.out.println(
                    "\nRECORRIDO BFS:"
            );

            avl.recorridoAmplitud();
        }

        catch(Exception e) {

            System.out.println(
                    "ERROR: "
                            + e.getMessage()
            );
        }
    }
}