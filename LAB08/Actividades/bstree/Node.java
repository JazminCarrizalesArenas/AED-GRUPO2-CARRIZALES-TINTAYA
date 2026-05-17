package bstree;

// Nodo base del BST
public class Node<E> {

    // IMPORTANTE:
    // protected para permitir acceso desde AVLTree
    protected E data;
    protected Node<E> left;
    protected Node<E> right;

    // Constructor
    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}


