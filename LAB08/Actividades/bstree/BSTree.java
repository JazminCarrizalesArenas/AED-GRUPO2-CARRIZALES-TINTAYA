package bstree;

import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

// Implementación base del Árbol Binario de Búsqueda
public class BSTree<E extends Comparable<E>> {

    protected Node<E> root;

    // INSERTAR
    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> node, E data) throws ItemDuplicated {

        if (node == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        } else {
            throw new ItemDuplicated("Elemento duplicado: " + data);
        }

        return node;
    }

    // BUSCAR
    public Node<E> search(E data) throws ItemNotFound {

        Node<E> result = search(root, data);

        if (result == null) {
            throw new ItemNotFound("Elemento no encontrado: " + data);
        }

        return result;
    }

    private Node<E> search(Node<E> node, E data) {

        if (node == null) {
            return null;
        }

        int cmp = data.compareTo(node.data);

        if (cmp == 0) {
            return node;
        }

        if (cmp < 0) {
            return search(node.left, data);
        }

        return search(node.right, data);
    }

    // ELIMINAR
    public void delete(E data) throws ItemNotFound {
        root = delete(root, data);
    }

    private Node<E> delete(Node<E> node, E data) throws ItemNotFound {

        if (node == null) {
            throw new ItemNotFound("Elemento no encontrado: " + data);
        }

        int cmp = data.compareTo(node.data);

        // Buscar izquierda
        if (cmp < 0) {
            node.left = delete(node.left, data);
        }

        // Buscar derecha
        else if (cmp > 0) {
            node.right = delete(node.right, data);
        }

        // Nodo encontrado
        else {

            // Caso 1: sin hijos
            if (node.left == null && node.right == null) {
                return null;
            }

            // Caso 2: un hijo derecho
            if (node.left == null) {
                return node.right;
            }

            // Caso 2: un hijo izquierdo
            if (node.right == null) {
                return node.left;
            }

            // Caso 3: dos hijos
            Node<E> successor = findMin(node.right);

            node.data = successor.data;

            node.right = delete(node.right, successor.data);
        }

        return node;
    }

    // MÍNIMO
    protected Node<E> findMin(Node<E> node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // RECORRIDO INORDER
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {

        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // PREORDER
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> node) {

        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // POSTORDER
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<E> node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // ALTURA
    public int height() {
        return height(root);
    }

    protected int height(Node<E> node) {

        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    // IMPRIMIR ÁRBOL
    public void printTree() {
        printTree(root, "", true);
    }

    private void printTree(Node<E> node, String prefix, boolean isRoot) {

        if (node != null) {

            System.out.println(
                    prefix + (isRoot ? "└── " : "├── ") + node);

            printTree(node.left, prefix + "   ", false);

            printTree(node.right, prefix + "   ", false);
        }
    }
}