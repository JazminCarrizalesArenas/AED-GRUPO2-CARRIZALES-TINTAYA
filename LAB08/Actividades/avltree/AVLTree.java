package avltree;

import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

// Árbol AVL
public class AVLTree {
    // NODO AVL
    class NodeAVL {

        int data;
        int bf;

        NodeAVL left;
        NodeAVL right;

        public NodeAVL(int data) {
            this.data = data;
            this.bf = 0;
        }

        @Override
        public String toString() {
            return data + "(bf=" + bf + ")";
        }
    }

    // Raíz del árbol
    private NodeAVL root;

    // =====================================
    // INSERTAR
    // =====================================
    public void insert(int data)
            throws ItemDuplicated {

        root = insert(root, data);
    }

    private NodeAVL insert(NodeAVL node, int data)
            throws ItemDuplicated {

        // Crear nodo
        if (node == null) {
            return new NodeAVL(data);
        }

        // Insertar izquierda
        if (data < node.data) {

            node.left = insert(node.left, data);
        }

        // Insertar derecha
        else if (data > node.data) {

            node.right = insert(node.right, data);
        }

        // Duplicado
        else {
            throw new ItemDuplicated(
                    "Elemento duplicado");
        }

        // Actualizar balance
        node.bf = balance(node);

        // =============================
        // DESBALANCE IZQUIERDA
        // =============================
        if (node.bf < -1) {

            // Caso II
            if (data < node.left.data) {

                System.out.println(
                        "Rotación Simple Derecha");

                return rotateSR(node);
            }

            // Caso ID
            else {

                System.out.println(
                        "Rotación Doble Izquierda-Derecha");

                node.left = rotateSL(node.left);

                return rotateSR(node);
            }
        }

        // DESBALANCE DERECHA
        if (node.bf > 1) {

            // Caso DD
            if (data > node.right.data) {

                System.out.println(
                        "Rotación Simple Izquierda");

                return rotateSL(node);
            }

            // Caso DI
            else {

                System.out.println(
                        "Rotación Doble Derecha-Izquierda");

                node.right = rotateSR(node.right);

                return rotateSL(node);
            }
        }

        return node;
    }

    // =====================================
    // ELIMINAR
    // =====================================
    public void delete(int data)
            throws ItemNotFound {

        root = delete(root, data);
    }

    private NodeAVL delete(NodeAVL node,
                           int data)
            throws ItemNotFound {

        if (node == null) {

            throw new ItemNotFound(
                    "Elemento no encontrado");
        }

        // Buscar izquierda
        if (data < node.data) {

            node.left = delete(node.left, data);
        }

        // Buscar derecha
        else if (data > node.data) {

            node.right = delete(node.right, data);
        }

        // Nodo encontrado
        else {

            // Caso 1
            if (node.left == null &&
                    node.right == null) {

                return null;
            }

            // Caso 2
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            // Caso 3
            NodeAVL successor =
                    findMin(node.right);

            node.data = successor.data;

            node.right = delete(
                    node.right,
                    successor.data);
        }

        // Actualizar balance
        node.bf = balance(node);

        // Balancear izquierda
        if (node.bf < -1) {
            return balanceToRight(node);
        }

        // Balancear derecha
        if (node.bf > 1) {
            return balanceToLeft(node);
        }

        return node;
    }

    // BALANCE TO LEFT
    private NodeAVL balanceToLeft(
            NodeAVL node) {

        NodeAVL rightChild =
                node.right;

        // Caso DD
        if (balance(rightChild) >= 0) {

            return rotateSL(node);
        }

        // Caso DI
        else {

            node.right =
                    rotateSR(rightChild);

            return rotateSL(node);
        }
    }

    // BALANCE TO RIGHT
    private NodeAVL balanceToRight(
            NodeAVL node) {

        NodeAVL leftChild =
                node.left;

        // Caso II
        if (balance(leftChild) <= 0) {

            return rotateSR(node);
        }

        // Caso ID
        else {

            node.left =
                    rotateSL(leftChild);

            return rotateSR(node);
        }
    }

    // ROTACIÓN SIMPLE IZQUIERDA
    private NodeAVL rotateSL(
            NodeAVL node) {

        NodeAVL newRoot =
                node.right;

        NodeAVL temp =
                newRoot.left;

        newRoot.left = node;

        node.right = temp;

        node.bf = balance(node);
        newRoot.bf = balance(newRoot);

        return newRoot;
    }

    // ROTACIÓN SIMPLE DERECHA
    private NodeAVL rotateSR(
            NodeAVL node) {

        NodeAVL newRoot =
                node.left;

        NodeAVL temp =
                newRoot.right;

        newRoot.right = node;

        node.left = temp;

        node.bf = balance(node);
        newRoot.bf = balance(newRoot);

        return newRoot;
    }

    // FACTOR DE EQUILIBRIO
    private int balance(NodeAVL node) {

        if (node == null) {
            return 0;
        }

        return height(node.right)
                - height(node.left);
    }

    // ALTURA
    private int height(NodeAVL node) {

        if (node == null) {
            return 0;
        }

        return 1 + Math.max(
                height(node.left),
                height(node.right));
    }

    // =====================================
    // MÍNIMO
    // =====================================
    private NodeAVL findMin(
            NodeAVL node) {

        while (node.left != null) {

            node = node.left;
        }

        return node;
    }

    // =====================================
    // RECORRIDO INORDER
    // =====================================
    public void inOrder() {

        inOrder(root);

        System.out.println();
    }

    private void inOrder(NodeAVL node) {

        if (node != null) {

            inOrder(node.left);

            System.out.print(
                    node.data + " ");

            inOrder(node.right);
        }
    }



 // IMPRIMIR ÁRBOL

 public void printTree() {

     printTree(root, 0);
 }

 private void printTree(NodeAVL node,
                        int level) {

     if (node != null) {

         printTree(node.right, level + 1);

         for (int i = 0; i < level; i++) {

             System.out.print("   ");
         }

         System.out.println(node);

         printTree(node.left, level + 1);
     }
 }
}