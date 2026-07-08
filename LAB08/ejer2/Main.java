package ejer2;

public class Main {

    public static void main(String[] args) {

        // CASOS DE PRUEBA (dos secuencias diferentes)
        int[] caso1 = {10, 20, 30, 40, 50, 25};
        int[] caso2 = {50, 40, 30, 20, 10, 5};

        System.out.println(" CASO 1");
        comparar(caso1);

        System.out.println("\nCASO 2 ");
        comparar(caso2);
    }

    public static void comparar(int[] datos) {

        BST bst = new BST();
        AVLTree avl = new AVLTree();

        // INSERTAR MISMO CONJUNTO
        for (int d : datos) {
            bst.insertar(d);
            avl.insertar(d);
        }

        // RECORRIDOS
        System.out.println("\nBST inorden:");
        bst.inorden();

        System.out.println("AVL inorden:");
        avl.inorden();

        // ALTURAS 
        System.out.println("\nAltura BST: " + bst.altura());
        System.out.println("Altura AVL: " + avl.altura());

        // BUSQUEDAS
        int buscarOK = datos[2];
        int buscarNO = 999;

        System.out.println("\nBuscar " + buscarOK);
        System.out.println("BST: " + bst.buscar(buscarOK));
        System.out.println("AVL: " + avl.buscar(buscarOK));

        System.out.println("\nBuscar " + buscarNO);
        System.out.println("BST: " + bst.buscar(buscarNO));
        System.out.println("AVL: " + avl.buscar(buscarNO));
    }
}