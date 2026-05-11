public interface BinarySearchTree<E extends Comparable<E>> {

    void insert(E data) throws ItemDuplicated;
    E search(E data) throws ItemNoFound;
    void delete(E data) throws ExceptionIsEmpty;
    //EJER2
    void destroyNodes() throws ExceptionIsEmpty;
    int countAllNodes();
    int countNodes();
    int height(E x);
    int amplitude();


    void inOrder();
    void preOrder();
    void postOrder();
    //EJER 3
    int areaBST();
    void drawBST();

    //EJER 4 
    void parenthesize();
    boolean isValidBST();
    
    E findMinNode() throws ItemNoFound;
    E findMaxNode() throws ItemNoFound;
}