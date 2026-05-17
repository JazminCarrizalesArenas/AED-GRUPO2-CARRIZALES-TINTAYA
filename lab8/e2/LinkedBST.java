public class LinkedBST<E extends Comparable<E>>implements BinarySearchTree<E> {
    // Nodo raíz del árbol
    protected Node<E> root;

    public LinkedBST() {

        // Árbol inicia vacío
        root = null;
    }

    public boolean isEmpty() {
        // Si root es null
        return root == null;
    }

    // =================================================
    // Inserta un elemento
    // =================================================
    @Override
    public void insert(E data)throws ItemDuplicated {
        // Llamar método recursivo
        root = insertRec(root, data);
    }

    // Método recursivo de inserción
    private Node<E> insertRec(Node<E> node,E data)throws ItemDuplicated {
        // Si nodo es null
        if (node == null)
            // Crear nuevo nodo
            return new Node<>(data);

        // Comparar dato nuevo con nodo actual
        int cmp =data.compareTo(node.data);

        // Si dato es menor
        if (cmp < 0) {
            // Insertar por izquierda
            node.left =insertRec(node.left, data);
        }

        // Si dato es mayor
        else if (cmp > 0) {
            // Insertar por derecha
            node.right =insertRec(node.right, data);
        }

        // Si es igual
        else {
            // Lanzar excepción
            throw new ItemDuplicated("Dato duplicado");
        }

        // Retornar nodo actualizado
        return node;
    }

    // =================================================
    // Busca un dato
    // =================================================
    @Override
    public E search(E data) throws ItemNotFound {
        // Llamar búsqueda recursiva
        return searchRec(root, data);
    }

    // Método recursivo de búsqueda
    private E searchRec(Node<E> node,E data)throws ItemNotFound {
        // Si nodo no existe
        if (node == null) {
            throw new ItemNotFound("Dato no encontrado");
        }

        // Comparar dato buscado
        int cmp =data.compareTo(node.data);

        // Si encontró el dato
        if (cmp == 0)
            // Retornar dato
            return node.data;

        // Si dato es menor
        if (cmp < 0)
            // Buscar izquierda
            return searchRec(node.left, data);

        // Buscar derecha
        return searchRec(node.right, data);
    }

    //ordenamiento inOrder
    @Override
    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node<E> node) {
        if(node == null)
            return;
        inOrderRec(node.left);
        System.out.print(node.data + " ");
        inOrderRec(node.right);
    }

    // =================================================
    // DELETE
    // =================================================
    @Override
    public void delete(E data)throws ExceptionIsEmpty {
        if(root == null) {
            throw new ExceptionIsEmpty("Árbol vacío" );
        }
        root = deleteRec(root,data);
    }

    private Node<E> deleteRec(Node<E> node,E data) {

        if(node == null) {
            return null;
        }

        int cmp = data.compareTo(node.data);

        if(cmp < 0) {
            node.left =deleteRec(node.left,data);
        }

        else if(cmp > 0) {
            node.right =deleteRec(node.right,data);
        }

        else {
            // hoja
            if(node.left == null && node.right == null) {
                return null;
            }

            // hijo derecho
            if(node.left == null) {
                return node.right;
            }

            // hijo izquierdo
            if(node.right == null) {
                return node.left;
            }

            // dos hijos
            Node<E> sucesor = findMin(node.right);
            node.data = sucesor.data;
            node.right =deleteRec(node.right,sucesor.data);
        }

        return node;
    }

    // =================================================
    // FIND MIN
    // =================================================
    private Node<E> findMin(Node<E> node) {

        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

     // =================================================
    // PRINT TREE
    // =================================================
    public void printTree() {
        printTreeRec(root,0);
    }

    private void printTreeRec(Node<E> node,int level) {
        if(node == null)
            return;
        printTreeRec(node.right,level + 1);

        for(int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node);
        printTreeRec(node.left,level + 1);
    }

    // =================================================
    // ALTURA
    // =================================================
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node<E> node) {
        if(node == null)
            return 0;

        int izquierda =heightRec(node.left);

        int derecha =heightRec(node.right);

        return Math.max(izquierda,derecha) + 1;
    }
}