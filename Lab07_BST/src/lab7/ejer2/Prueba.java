public class Prueba {

    public static void main(String[] args) {
        try {

            LinkedBST<Integer> bst =new LinkedBST<>();

            bst.insert(15);
            bst.insert(8);
            bst.insert(22);
            bst.insert(5);
            bst.insert(12);
            bst.insert(18);
            bst.insert(30);

            System.out.println("INORDER");
            bst.inOrder();

            System.out.println("PREORDER");
            bst.preOrder();

            System.out.println("POSTORDER");
            bst.postOrder();

            System.out.println("BUSCAR 12");
            System.out.println(bst.search(12));

            System.out.println("MINIMO");
            System.out.println(bst.findMinNode());

            System.out.println("MAXIMO");
            System.out.println(bst.findMaxNode());

            System.out.println("TOTAL NODOS");
            System.out.println(bst.countAllNodes());

            System.out.println("NODOS NO HOJA");
            System.out.println(bst.countNodes());

            System.out.println("ALTURA");
            System.out.println(bst.height(15));

            System.out.println("AMPLITUD");
            System.out.println(bst.amplitude());

            System.out.println("ELIMINAR 8");
            bst.delete(8);   

        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
