
import java.util.ArrayList;

public interface Graph<V, E> {

    void insertVertex(V data);

    void insertEdge(V origin, V destination);

    void removeVertex(V data);

    void removeEdge(V origin, V destination);

    boolean searchVertex(V data);

    boolean searchEdge(V origin, V destination);

    ArrayList<V> adjacentVertices(V data);
}