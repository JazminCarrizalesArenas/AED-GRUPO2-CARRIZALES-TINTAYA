public interface BinarySearchTree<E extends Comparable<E>> {

    void insert(E data) throws ItemDuplicated;
    E search(E data) throws ItemNoFound;
    void delete(E data) throws ExceptionIsEmpty;
    void destroyNodes() throws ExceptionIsEmpty;
    int countAllNodes();
    int countNodes();
    int height(E x);
    int amplitude();
    void inOrder();
    void preOrder();
    void postOrder();
    int areaBST();
    void drawBST();
    E findMinNode() throws ItemNoFound;
    E findMaxNode() throws ItemNoFound;
}