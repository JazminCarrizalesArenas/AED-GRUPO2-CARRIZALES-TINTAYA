package avltree;

import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;
import exceptions.ExceptionIsEmpty;

public class AVLTree<E extends Comparable<E>> {

    private NodeAVL<E> root;

    private int height(NodeAVL<E> n) {
        return (n == null) ? 0 : n.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getBalance(NodeAVL<E> n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    private NodeAVL<E> rightRotate(NodeAVL<E> y) {
        NodeAVL<E> x = y.left;
        NodeAVL<E> T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private NodeAVL<E> leftRotate(NodeAVL<E> x) {
        NodeAVL<E> y = x.right;
        NodeAVL<E> T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // INSERT
    public void insert(E data) throws ItemDuplicated {
        root = insertRec(root, data);
    }

    private NodeAVL<E> insertRec(NodeAVL<E> node, E data) throws ItemDuplicated {

        if (node == null) return new NodeAVL<>(data);

        int cmp = data.compareTo(node.data);

        if (cmp < 0) node.left = insertRec(node.left, data);
        else if (cmp > 0) node.right = insertRec(node.right, data);
        else throw new ItemDuplicated("Duplicado");

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && data.compareTo(node.left.data) < 0)
            return rightRotate(node);

        // RR
        if (balance < -1 && data.compareTo(node.right.data) > 0)
            return leftRotate(node);

        // LR
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // SEARCH
    public E search(E data) throws ItemNoFound {
        NodeAVL<E> r = searchRec(root, data);
        if (r == null) throw new ItemNoFound("No encontrado");
        return r.data;
    }

    private NodeAVL<E> searchRec(NodeAVL<E> node, E data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);

        if (cmp == 0) return node;
        if (cmp < 0) return searchRec(node.left, data);
        return searchRec(node.right, data);
    }

    // DELETE
    public void delete(E data) throws ExceptionIsEmpty, ItemNoFound {
        if (root == null) throw new ExceptionIsEmpty("Vacio");
        root = deleteRec(root, data);
    }

    private NodeAVL<E> deleteRec(NodeAVL<E> node, E data) throws ItemNoFound {

        if (node == null) throw new ItemNoFound("No existe");

        int cmp = data.compareTo(node.data);

        if (cmp < 0) node.left = deleteRec(node.left, data);
        else if (cmp > 0) node.right = deleteRec(node.right, data);
        else {

            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            NodeAVL<E> min = min(node.right);
            node.data = min.data;
            node.right = deleteRec(node.right, min.data);
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);

        // LR
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);

        // RL
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private NodeAVL<E> min(NodeAVL<E> node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // INORDER
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(NodeAVL<E> node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }
}