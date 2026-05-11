public interface BinarySearchTree<E extends Comparable<E>> {

    void insert(E data) throws ItemDuplicated;
    E search(E data) throws ItemNoFound;
    void delete(E data) throws ExceptionIsEmpty;
    void inOrder();
    void preOrder();
    void postOrder();
    E findMinNode() throws ItemNoFound;
    E findMaxNode() throws ItemNoFound;
}