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
}