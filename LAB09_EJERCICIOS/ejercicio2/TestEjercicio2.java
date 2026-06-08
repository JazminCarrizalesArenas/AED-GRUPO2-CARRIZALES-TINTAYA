package ejercicio2;

import btree.BNode;
import btree.BTree;
import excepciones.ExcepcionArbolB;

public class TestEjercicio2 {

    public static void main(String[] args) {
        BNode.reiniciarContador();

        BTree<Integer> arbol = new BTree<>(4);
        int[] claves = {10, 15, 20, 25, 30, 35, 40, 45};

        try {
            for (int c : claves) arbol.insertar(c);
            System.out.println("Árbol construido:");
            System.out.println(arbol);

            // Rango existente
            System.out.println("searchRange(20, 40):");
            arbol.searchRange(20, 40);

            // Rango inválido
            System.out.println("searchRange(50, 10) - rango inválido:");
            arbol.searchRange(50, 10);

            // Rango inexistente
            System.out.println("searchRange(100, 200) - rango inexistente:");
            arbol.searchRange(100, 200);

        } catch (ExcepcionArbolB e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}