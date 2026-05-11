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

    //=================================================
    // INSERT
    // =================================================

    @Override
    public void insert(E data)throws ItemDuplicated {
        root = insertRec(root, data);
    }

    // Método recursivo insert
    private Node<E> insertRec(Node<E> node,E data)throws ItemDuplicated {
        // Si nodo es null
        if(node == null)  return new Node<>(data);
        // Comparar datos
        int cmp =data.compareTo(node.data);
        // Insertar izquierda
        if(cmp < 0) {
            node.left =insertRec(node.left, data);
        }
        // Insertar derecha
        else if(cmp > 0) {
            node.right =insertRec(node.right, data);
        }
        // Dato repetido
        else {
            throw new ItemDuplicated("Dato duplicado");
        }
        return node;
    }

    // =================================================
    // searchRange
    // =================================================

    @Override
    public void searchRange(E min, E max) {
        System.out.println("ELEMENTOS EN RANGO");
        searchRangeRec( root,min,max);
        System.out.println();
    }

    // Método recursivo
    private void searchRangeRec(Node<E> node,E min,E max) {
        if(node == null)
            return;
        // Buscar izquierda
        if(node.data.compareTo(min) > 0) {
            searchRangeRec(node.left, min, max);
        }

        // Imprimir rango
        if(node.data.compareTo(min) >= 0 && node.data.compareTo(max) <= 0) {
            System.out.print(node.data + " ");
        }

        // Buscar derecha
        if(node.data.compareTo(max) < 0) {
            searchRangeRec(node.right, min, max);
        }
    }

    // =================================================
    // countLeaves
    // =================================================

    @Override
    public int countLeaves() {
        return countLeavesRec(root);
    }

    // Método recursivo
    private int countLeavesRec(Node<E> node) {
        // Nodo vacío
        if(node == null)
            return 0;
        // Nodo hoja
        if(node.left == null && node.right == null) {
            return 1;
        }

        // Contar hojas
        return countLeavesRec(node.left) + countLeavesRec(node.right);
    }

    // =================================================
    // printDescending
    // =================================================

    @Override
    public void printDescending() {
        System.out.println( "ORDEN DESCENDENTE");
        descendingRec(root);
        System.out.println();
    }

    // Recorrido descendente
    private void descendingRec(Node<E> node) {
        if(node == null)
            return;
        // Derecha
        descendingRec(node.right);
        // Nodo
        System.out.print(node.data + " ");
        // Izquierda
        descendingRec(node.left);
    }
    
    // ejeriocicio 3.b: 
    @Override
    public void drawBST() {
        System.out.println("=== ARBOL BST ===");
        drawRec(root, "", true);
    }
    
    private void drawRec(Node<E> node,String prefix,boolean isRight) {
        if(node == null)
            return;
    
        System.out.println(prefix+(isRight ? "└── " : "├── ")+node.data);
        String nuevoPrefijo =prefix+(isRight ? "    " : "│   ");
    
        if(node.left != null|| node.right != null) {
            drawRec(node.right,nuevoPrefijo,false);
    
            drawRec(node.left,nuevoPrefijo,true);
        }
    }
}