package bstreelinklistinterfgeneric;

import bstreeInterface.BinarySearchTree;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    // Clase interna que representa un nodo del arbol
    class Node {
        public E data;
        public Node left;
        public Node right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public LinkedBST() {
        this.root = null;
    }

    // Verifica si el arbol esta vacio
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // ACTIVIDAD 6 - INSERT
    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp == 0) {
            throw new ItemDuplicated("El dato " + data + " ya existe en el arbol.");
        } else if (cmp < 0) {
            node.left = insertRec(node.left, data);
        } else {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    // ACTIVIDAD 6 - SEARCH
    @Override
    public E search(E data) throws ItemNoFound {
        Node result = searchRec(root, data);
        if (result == null) {
            throw new ItemNoFound("El dato " + data + " no fue encontrado.");
        }
        return result.data;
    }

    private Node searchRec(Node node, E data) {
        if (node == null) return null;
        int cmp = data.compareTo(node.data);
        if (cmp == 0) return node;
        else if (cmp < 0) return searchRec(node.left, data);
        else return searchRec(node.right, data);
    }

    // ACTIVIDAD 6 - DELETE
    @Override
    public void delete(E data) throws ExceptionIsEmpty, ItemNoFound {
        if (isEmpty()) throw new ExceptionIsEmpty("El arbol esta vacio.");
        searchRec(root, data); // lanza ItemNoFound si no existe
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node node, E data) throws ItemNoFound {
        if (node == null) throw new ItemNoFound("El dato " + data + " no existe.");
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            // Caso 1: nodo hoja
            if (node.left == null && node.right == null) {
                return null;
            }
            // Caso 2: un solo hijo
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // Caso 3: dos hijos - sucesor inorden (minimo del subarbol derecho)
            Node minNode = findMinNode(node.right);
            node.data = minNode.data;
            node.right = deleteRec(node.right, minNode.data);
        }
        return node;
    }

    // ACTIVIDAD 6 - TOSTRING
    @Override
    public String toString() {
        if (isEmpty()) return "El arbol esta vacio.";
        StringBuilder sb = new StringBuilder();
        toStringRec(root, sb);
        return sb.toString().trim();
    }

    private void toStringRec(Node node, StringBuilder sb) {
        if (node == null) return;
        toStringRec(node.left, sb);
        sb.append(node.data).append(" ");
        toStringRec(node.right, sb);
    }

    // ACTIVIDAD 7 - INORDER (izquierda - raiz - derecha)
    public void inOrder() {
        System.out.print("InOrden: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.print(node.data + " ");
        inOrderRec(node.right);
    }

    // ACTIVIDAD 8 - PREORDER (raiz - izquierda - derecha)
    public void preOrder() {
        System.out.print("PreOrden: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }

    // ACTIVIDAD 9 - POSTORDER (izquierda - derecha - raiz)
    public void postOrder() {
        System.out.print("PostOrden: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node == null) return;
        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.data + " ");
    }

    // ACTIVIDAD 10 - MINIMO Y MAXIMO

    // Busca el nodo con el valor minimo a partir de un nodo dado
    private Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Metodo publico: retorna el valor minimo del arbol completo
    public E findMin() throws ItemNoFound {
        if (isEmpty()) throw new ItemNoFound("El arbol esta vacio, no hay minimo.");
        return findMinNode(root).data;
    }

    // Busca el nodo con el valor maximo a partir de un nodo dado
    private Node findMaxNode(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Metodo publico: retorna el valor maximo del arbol completo
    public E findMax() throws ItemNoFound {
        if (isEmpty()) throw new ItemNoFound("El arbol esta vacio, no hay maximo.");
        return findMaxNode(root).data;
    }
}