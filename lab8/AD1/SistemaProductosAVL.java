import java.util.Scanner;
public class SistemaProductosAVL {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        AVLTree<Integer> arbol =
                new AVLTree<>();

        int opcion;

        do {

            System.out.println("\n==========================");
            System.out.println(" SISTEMA AVL PRODUCTOS");
            System.out.println("==========================");
            System.out.println("1. Insertar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar árbol");
            System.out.println("5. Recorrido inorder");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            try {

                switch(opcion) {

                    // =====================================
                    // INSERTAR
                    // =====================================
                    case 1:

                        System.out.print(
                                "\nIngrese código: "
                        );

                        int insertar =
                                sc.nextInt();

                        arbol.insert(insertar);

                        break;

                    // =====================================
                    // BUSCAR
                    // =====================================
                    case 2:

                        System.out.print(
                                "\nCódigo a buscar: "
                        );

                        int buscar =
                                sc.nextInt();

                        System.out.println(
                                "Encontrado: "
                                        + arbol.search(buscar)
                        );

                        break;

                    // =====================================
                    // ELIMINAR
                    // =====================================
                    case 3:

                        System.out.print(
                                "\nCódigo a eliminar: "
                        );

                        int eliminar =
                                sc.nextInt();

                        arbol.delete(eliminar);

                        break;

                    // =====================================
                    // MOSTRAR ÁRBOL
                    // =====================================
                    case 4:

                        System.out.println(
                                "\nÁRBOL AVL:"
                        );

                        arbol.printTree();

                        break;

                    // =====================================
                    // INORDER
                    // =====================================
                    case 5:

                        System.out.println(
                                "\nRECORRIDO INORDER:"
                        );

                        arbol.inOrder();

                        break;

                    // =====================================
                    // SALIR
                    // =====================================
                    case 6:

                        System.out.println(
                                "\nSaliendo..."
                        );

                        break;

                    // =====================================
                    // OPCIÓN INVÁLIDA
                    // =====================================
                    default:

                        System.out.println(
                                "\nOpción inválida."
                        );
                }
            }

            catch(Exception e) {

                System.out.println(
                        "\nERROR: "
                                + e.getMessage()
                );
            }

        } while(opcion != 6);

        sc.close();
    }
}