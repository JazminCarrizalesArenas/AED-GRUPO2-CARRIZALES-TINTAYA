public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E data) throws ItemDuplicated;
    void searchRange(E min, E max);
    int countLeaves();
    void printDescending();
    void drawBST();

}