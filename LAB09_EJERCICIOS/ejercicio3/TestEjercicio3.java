package ejercicio3;

import btree.BNode;
import btree.BTree;
import excepciones.ExcepcionArbolB;

public class TestEjercicio3 {

    public static void main(String[] args) {
        BNode.reiniciarContador();

        BTree<Integer> arbol = construirArbol();
        System.out.println("Árbol inicial:");
        System.out.println(arbol);

        try {
            // Caso A: hoja con más del mínimo
            System.out.println("Eliminar 65:");
            arbol.remove(65);
            System.out.println(arbol);

            // Caso B: nodo interno, reemplazo por sucesor
            System.out.println("Eliminar 20:");
            arbol.remove(20);
            System.out.println(arbol);

            // Caso C: redistribución
            System.out.println("Eliminar 12:");
            arbol.remove(12);
            System.out.println(arbol);

            // Caso D: fusión
            System.out.println("Eliminar 5:");
            arbol.remove(5);
            System.out.println(arbol);

            // Caso E: fusión propagada hasta raíz
            BTree<Integer> arbol2 = construirArbolPropagacion();
            System.out.println("Árbol antes de eliminar 65:");
            System.out.println(arbol2);
            arbol2.remove(65);
            System.out.println("Árbol después:");
            System.out.println(arbol2);

        } catch (ExcepcionArbolB e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static BTree<Integer> construirArbol() {
        BTree<Integer> arbol = new BTree<>(5);
        int[] claves = {10, 20, 5, 9, 12, 18, 25, 52, 65, 92, 99};
        try {
            for (int c : claves) arbol.insertar(c);
        } catch (ExcepcionArbolB e) {
            System.err.println("Error construyendo árbol: " + e.getMessage());
        }
        return arbol;
    }

    private static BTree<Integer> construirArbolPropagacion() {
        BTree<Integer> arbol = new BTree<>(5);
        int[] claves = {65, 10, 20, 5, 9, 12, 18, 25, 52, 67, 68, 69, 73, 70, 72, 92, 99};
        try {
            for (int c : claves) arbol.insertar(c);
        } catch (ExcepcionArbolB e) {
            System.err.println("Error construyendo árbol: " + e.getMessage());
        }
        return arbol;
    }
}