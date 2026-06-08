package ejercicio1;

import btree.BNode;
import btree.BTree;
import excepciones.ExcepcionArbolB;

public class TestEjercicio1 {

    public static void main(String[] args) {
        BNode.reiniciarContador();

        BTree<Integer> arbol = construirArbol();
        System.out.println("Árbol construido:");
        System.out.println(arbol);

        try {
            // Caso 1: clave en la raíz
            System.out.println("Buscar 31 (raíz):");
            System.out.println(arbol.search(31));

            // Caso 2: clave en hoja izquierda, extremo inicial
            System.out.println("Buscar 3 (hoja izquierda, extremo inicial):");
            System.out.println(arbol.search(3));

            // Caso 3: clave en hoja derecha, extremo final
            System.out.println("Buscar 72 (hoja derecha, extremo final):");
            System.out.println(arbol.search(72));

            // Caso 4: clave inexistente
            System.out.println("Buscar 99 (no existe):");
            System.out.println(arbol.search(99));

            // Caso 5: clave en hoja interior (ejemplo del PDF figura 10.14)
            System.out.println("Buscar 52 (hoja interior):");
            System.out.println(arbol.search(52));

        } catch (ExcepcionArbolB e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Árbol de la figura 10.14 del PDF
    private static BTree<Integer> construirArbol() {
        BTree<Integer> arbol = new BTree<>(4);
        int[] claves = {
            31, 12, 19, 3, 10, 13, 16, 22, 25, 28,
            41, 57, 63, 33, 35, 40, 49, 52, 55, 60, 62, 67, 70, 72
        };
        try {
            for (int c : claves) arbol.insertar(c);
        } catch (ExcepcionArbolB e) {
            System.err.println("Error construyendo árbol: " + e.getMessage());
        }
        return arbol;
    }
}
