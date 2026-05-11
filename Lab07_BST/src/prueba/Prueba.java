package prueba;

import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class Prueba {

    public static void main(String[] args) {

        System.out.println("LAB 07 - BINARY SEARCH TREE ");
        System.out.println();

        LinkedBST<Integer> bst = new LinkedBST<>();

        // -Actividad 6: insert 
        System.out.println("Actividad 6: Insercion ");
        int[] valores = {400, 100, 700, 50, 200, 75};
        for (int v : valores) {
            try {
                bst.insert(v);
                System.out.println("Insertando: " + v);
            } catch (ItemDuplicated e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println();

        System.out.println("Intentando insertar duplicado (400):");
        try {
            bst.insert(400);
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        //  Actividad 6: search 
        System.out.println("Actividad 6: Busqueda ");
        try {
            Integer found = bst.search(200);
            System.out.println("Buscando 200... Dato encontrado: " + found);
        } catch (ItemNoFound e) {
            System.out.println(e.getMessage());
        }
        try {
            bst.search(999);
        } catch (ItemNoFound e) {
            System.out.println("Buscando 999... " + e.getMessage());
        }
        System.out.println();

        // --- Actividad 6: toString ---
        System.out.println("Actividad 6: toString (InOrden) ");
        System.out.println(bst.toString());
        System.out.println();

        // --- Actividad 7: InOrder ---
        System.out.println("Actividad 7: Recorrido InOrden ");
        bst.inOrder();
        System.out.println();

        // --- Actividad 8: PreOrder ---
        System.out.println("Actividad 8: Recorrido PreOrden ");
        bst.preOrder();
        System.out.println();

        // --- Actividad 9: PostOrder ---
        System.out.println("Actividad 9: Recorrido PostOrden ");
        bst.postOrder();
        System.out.println();

        // --- Actividad 10: Min y Max ---
        System.out.println("Actividad 10: Minimo y Maximo ");
        try {
            System.out.println("Minimo: " + bst.findMin());
            System.out.println("Maximo: " + bst.findMax());
        } catch (ItemNoFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // --- Actividad 6: delete ---
        System.out.println("Actividad 6: Eliminacion ");
        try {
            System.out.println("Eliminando 75 (hoja)");
            bst.delete(75);
            bst.inOrder();

            System.out.println("Eliminando 50 (un hijo)");
            bst.delete(50);
            bst.inOrder();

            System.out.println("Eliminando 100 (dos hijos)");
            bst.delete(100);
            bst.inOrder();

        } catch (ExceptionIsEmpty | ItemNoFound e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        System.out.println("El arbol esta vacio? " + bst.isEmpty());
    }
}