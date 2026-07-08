import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {

    // ID autoincremental del nodo
    private static int nextId = 1;

    // Identificador único del nodo
    private int idNode;

    // Claves del nodo
    protected ArrayList<E> keys;

    // Hijos del nodo (IMPORTANTE: debe llamarse igual que en BTree -> childs)
    protected ArrayList<BNode<E>> childs; // FIX: antes estaba "chils"

    // Número de claves actuales
    protected int count;

    /**
     * Constructor del nodo B
     */
    public BNode(int order) {

        this.idNode = nextId++;

        this.keys = new ArrayList<>(order);

        // FIX: un nodo B necesita order + 1 hijos
        this.childs = new ArrayList<>(order + 1);

        this.count = 0;

        // Inicializa espacios para claves e hijos
        for (int i = 0; i < order; i++) {
            keys.add(null);
        }

        for (int i = 0; i <= order; i++) {
            childs.add(null);
        }
    }

    /**
     * Verifica si el nodo está lleno
     */
    public boolean nodeFull(int maxKeys) {
        return count == maxKeys;
    }

    /**
     * Verifica si el nodo está vacío
     */
    public boolean nodeEmpty() {
        return count == 0;
    }

    /**
     * Busca una clave dentro del nodo
     * - position[0] devuelve índice o hijo donde bajar
     */
    public boolean searchNode(E key, int[] position) {

        int i = 0;

        // Avanza mientras la clave sea mayor
        while (i < count && key.compareTo(keys.get(i)) > 0) {
            i++;
        }

        position[0] = i;

        // Si encuentra la clave
        if (i < count &&key.compareTo(keys.get(i)) == 0) {
            return true;
        }

        return false;
    }

    /**
     * Obtiene ID del nodo
     */
    public int getIdNode() {
        return idNode;
    }

    /**
     * Representación del nodo (debug)
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Node ").append(idNode).append(": [");

        for (int i = 0; i < count; i++) {

            sb.append(keys.get(i));

            if (i < count - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}