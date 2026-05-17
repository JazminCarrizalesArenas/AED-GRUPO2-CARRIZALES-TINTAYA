public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E data) throws ItemDuplicated;
    E search(E data) throws ItemNotFound;
    void inOrder();
}