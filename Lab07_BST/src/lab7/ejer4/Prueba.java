public class Prueba {
    public static boolean sameArea(LinkedBST<?> bst1,LinkedBST<?> bst2) {
        return bst1.areaBST()==bst2.areaBST();
    }

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

            System.out.println("PARENTHESIZE");
            bst.parenthesize();
            
            System.out.println("VALID BST");
            
            System.out.println(bst.isValidBST());
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
