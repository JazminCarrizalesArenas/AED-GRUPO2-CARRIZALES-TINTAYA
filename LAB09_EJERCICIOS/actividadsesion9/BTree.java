
public class BTree<E extends Comparable<E>> {

    private BNode<E> root;
    private int orden;

    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(E key) {

        up = false;

        E median;
        BNode<E> newRoot;

        median = push(root, key);

        if (up) {

            newRoot = new BNode<>(orden);

            newRoot.count = 1;
            newRoot.keys.set(0, median);

            newRoot.childs.set(0, root);
            newRoot.childs.set(1, nDes);

            root = newRoot;
        }
    }

    private E push(BNode<E> current, E key) {

        int[] pos = new int[1];
        E median;

        if (current == null) {
            up = true;
            nDes = null;
            return key;
        }

        boolean found = current.searchNode(key, pos);

        if (found) {
            System.out.println("Duplicado");
            up = false;
            return null;
        }

        median = push(current.childs.get(pos[0]), key);

        if (up) {

            if (current.nodeFull(orden - 1)) {
                median = dividedNode(current, median, pos[0]);
            } else {
                putNode(current, median, nDes, pos[0]);
                up = false;
            }
        }

        return median;
    }

    private void putNode(BNode<E> current, E key, BNode<E> right, int pos) {

        int i;

        for (i = current.count - 1; i >= pos; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }

        current.keys.set(pos, key);
        current.childs.set(pos + 1, right);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E key, int pos) {

    int maxKeys = orden - 1;

    ArrayList<E> tempKeys = new ArrayList<>();
    ArrayList<BNode<E>> tempChilds = new ArrayList<>();

    // copiar claves actuales
    for (int i = 0; i < current.count; i++) {
        tempKeys.add(current.keys.get(i));
    }

    // copiar hijos actuales
    for (int i = 0; i <= current.count; i++) {
        tempChilds.add(current.childs.get(i));
    }

    // insertar nueva clave en posición correcta
    tempKeys.add(pos, key);

    // insertar nuevo hijo derecho asociado
    tempChilds.add(pos + 1, nDes);

    // posición de la mediana
    int medianPos = tempKeys.size() / 2;

    E median = tempKeys.get(medianPos);

    // crear nodo derecho
    BNode<E> right = new BNode<>(orden);

    // reconstruir nodo izquierdo
    current.count = 0;

    for (int i = 0; i < medianPos; i++) {
        current.keys.set(i, tempKeys.get(i));
        current.count++;
    }

    for (int i = 0; i <= medianPos; i++) {
        current.childs.set(i, tempChilds.get(i));
    }

    // limpiar sobrantes del izquierdo
    for (int i = current.count; i < orden - 1; i++) {
        current.keys.set(i, null);
    }

    // reconstruir nodo derecho
    int j = 0;

    for (int i = medianPos + 1; i < tempKeys.size(); i++) {
        right.keys.set(j, tempKeys.get(i));
        right.count++;
        j++;
    }

    j = 0;

    for (int i = medianPos + 1; i < tempChilds.size(); i++) {
        right.childs.set(j, tempChilds.get(i));
        j++;
    }

    nDes = right;
    up = true;

    return median;
}

    public BNode<E> getRoot() {
        return root;
    }
    
    @Override
    public String toString() {
        String s = "";
        if (isEmpty()) {
            s += "BTree is empty...";
        } else {
            s = writeTree(this.root);
        }

        return s;
    }
    
    private String writeTree(BNode<E> current) {

    // caso base
    if (current == null) {
        return "";
    }

    StringBuilder sb = new StringBuilder();

    // -----------------------------
    // Mostrar ID del nodo
    // -----------------------------
    sb.append("Id.Nodo: ")
      .append(current.getIdNode())
      .append(" | Claves: (");

    // -----------------------------
    // Mostrar claves del nodo
    // -----------------------------
    for (int i = 0; i < current.count; i++) {

        sb.append(current.keys.get(i));

        if (i < current.count - 1) {
            sb.append(", ");
        }
    }

    sb.append(") | Hijos: [");

    // -----------------------------
    // Mostrar hijos del nodo
    // -----------------------------
    for (int i = 0; i <= current.count; i++) {

        if (current.childs.get(i) != null) {

            sb.append(current.childs.get(i).getIdNode());

            if (i < current.count) {
                sb.append(", ");
            }
        }
    }

    sb.append("]\n");

    // -----------------------------
    // Recursión: recorrer hijos
    // -----------------------------
    for (int i = 0; i <= current.count; i++) {

        BNode<E> child = current.childs.get(i);

        if (child != null) {
            sb.append(writeTree(child));
        }
    }

    return sb.toString();
}
}