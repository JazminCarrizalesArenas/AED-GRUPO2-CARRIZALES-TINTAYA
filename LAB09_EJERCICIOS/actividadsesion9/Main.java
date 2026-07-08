public class Main {

    public static void main(String[] args) {

        // Crear árbol B de orden 4 (puedes cambiarlo a 3, 5, etc.)
        BTree<Integer> tree = new BTree<>(4);

        // Insertar valores de prueba
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);

        // Mostrar árbol
        System.out.println("==== B-TREE ====");
        System.out.println(tree);

        // Insertar duplicado (prueba de control)
        tree.insert(10);
    }
}