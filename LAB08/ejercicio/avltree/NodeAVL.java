package avltree;

class NodeAVL<E> {
    E data;
    int height;
    NodeAVL<E> left;
    NodeAVL<E> right;

    public NodeAVL(E data) {
        this.data = data;
        this.height = 1;
    }
}