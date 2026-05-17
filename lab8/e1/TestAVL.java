public class TestAVL {

    public static void main(String[] args) throws ExceptionIsEmpty {

        AVLTree<Integer> arbol =
                new AVLTree<>();

        try {

            // =================================
            // INSERTAR 30
            // =================================
            arbol.insert(30);

            // =================================
            // INSERTAR 10
            // =================================
            arbol.insert(10);

            // =================================
            // INSERTAR 20
            // Genera:
            // IZQUIERDA - DERECHA
            // =================================
            arbol.insert(20);

            // =================================
            // INSERTAR 40
            // =================================
            arbol.insert(40);

            // =================================
            // INSERTAR 50
            // Genera:
            // DERECHA - DERECHA
            // =================================
            arbol.insert(50);

            // =================================
            // INSERTAR 25
            // =================================
            arbol.insert(25);

            // =================================
            // RECORRIDO INORDER
            // =================================
            System.out.println("\n=================================");
            System.out.println("RECORRIDO INORDER");
            System.out.println("=================================");

            arbol.inOrder();


              // =========================================
            // BÚSQUEDA
            // =========================================
            System.out.println("\n==============================");
            System.out.println("BUSCANDO TICKETS");
            System.out.println("==============================");

            try {

                arbol.search(20);

                System.out.println(
                        "Ticket 20 ENCONTRADO."
                );

            } catch (ItemNotFound e) {

                System.out.println(
                        "Ticket 20 NO encontrado."
                );
            }

            try {

                arbol.search(60);

                System.out.println(
                        "Ticket 60 ENCONTRADO."
                );

            } catch (ItemNotFound e) {

                System.out.println(
                        "Ticket 60 NO encontrado."
                );
            }
            arbol.delete(10);
            arbol.delete(40);
            arbol.delete(30);

        }
        catch (ItemDuplicated e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}