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

            System.out.println("ELIMINAR 8");
            bst.delete(8);   

        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
