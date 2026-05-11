public class LinkedBST<E extends Comparable<E>>implements BinarySearchTree<E> {

    // Nodo raíz del árbol
    private Node<E> root;

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
    public void insert(E data)
    throws ItemDuplicated {
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
    public E search(E data)
    throws ItemNoFound {
        // Llamar búsqueda recursiva
        return searchRec(root, data);
    }

    // Método recursivo de búsqueda
    private E searchRec(Node<E> node,E data)throws ItemNoFound {
        // Si nodo no existe
        if (node == null) {
            throw new ItemNoFound("Dato no encontrado");
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

    // =================================================
    // Elimina un nodo
    // =================================================
    @Override
    public void delete(E data)
    throws ExceptionIsEmpty {

        // Validar árbol vacío
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Árbol vacío");
        }
        // Llamar eliminación recursiva
        root = deleteRec(root, data);
    }

    // Método recursivo delete
    private Node<E> deleteRec(Node<E> node, E data) {
        // Si nodo es null
        if (node == null)
            return null;

        // Comparar datos
        int cmp =data.compareTo(node.data);

        // Buscar izquierda
        if (cmp < 0) {
            node.left =deleteRec(node.left, data);
        }

        // Buscar derecha
        else if (cmp > 0) {
            node.right =deleteRec(node.right, data);
        }

        // Nodo encontrado
        else {

            // Caso hoja
            if (node.left == null&& node.right == null) {
                return null;
            }
            // Solo hijo derecho
            if (node.left == null)
                return node.right;

            // Solo hijo izquierdo
            if (node.right == null)
                return node.left;

            // Buscar sucesor
            Node<E> successor =findMin(node.right);
            // Reemplazar dato
            node.data =successor.data;
            // Eliminar sucesor
            node.right =deleteRec(node.right,successor.data);
        }
        // Retornar nodo
        return node;
    }

    // =================================================
    // Busca el menor nodo
    // =================================================
    private Node<E> findMin(Node<E> node) {

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // =================================================
    // Busca el mayor nodo
    // =================================================
    private Node<E> findMax(Node<E> node) {
        // Mientras exista derecha
        while (node.right != null) {
            // Avanzar derecha
            node = node.right;
        }
        // Retornar máximo
        return node;
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
    // PREORDER
    // =================================================

    @Override
    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }
    
    private void preOrderRec(Node<E> node) {
        if(node == null)
            return;
    
        System.out.print(node.data + " ");
        preOrderRec(node.left);
        preOrderRec(node.right);
    }
    // =================================================
    // POSTORDER
    // =================================================
    
    @Override
    public void postOrder() {
    
        postOrderRec(root);
        System.out.println();
    }
    
    private void postOrderRec(Node<E> node) {
    
        if(node == null)
            return;
    
        postOrderRec(node.left);
        postOrderRec(node.right);
        System.out.print(node.data + " ");
    }
    
    // =================================================
    // FIND MIN NODE
    // =================================================
    
    @Override
    public E findMinNode() throws ItemNoFound {
    
        if(isEmpty()) {
            throw new ItemNoFound("Arbol vacio");
        }
        Node<E> min = findMin(root);
        return min.data;
    }
    
    // =================================================
    // FIND MAX NODE
    // =================================================
    
    @Override
    public E findMaxNode() throws ItemNoFound {
    
        if(isEmpty()) {
            throw new ItemNoFound("Arbol vacio");
        }
        Node<E> max = findMax(root);
        return max.data;
    }
    
}