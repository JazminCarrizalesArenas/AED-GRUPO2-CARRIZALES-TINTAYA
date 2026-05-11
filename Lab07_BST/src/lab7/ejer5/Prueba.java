
public class Prueba {
    public static void main(String[] args) {
        try {
            // Crear BST
            LinkedBST<Integer> bst =new LinkedBST<>();
            // Insertar productos
            bst.insert(1050);
            bst.insert(500);
            bst.insert(2000);
            bst.insert(300);
            bst.insert(750);
            bst.insert(1500);
            bst.insert(3000);


            System.out.println(  "DIBUJO DEL BST");
            bst.drawBST();

            // BUSQUEDA POR RANGO
            System.out.println("BUSQUEDA ENTRE 500 Y 2000");
            bst.searchRange(500, 2000);

            // CONTAR HOJAS
            System.out.println("CANTIDAD DE HOJAS");
            System.out.println(bst.countLeaves());

            // DESCENDENTE
            bst.printDescending();
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}