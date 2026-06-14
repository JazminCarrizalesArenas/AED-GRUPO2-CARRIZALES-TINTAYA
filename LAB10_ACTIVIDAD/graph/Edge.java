package graph;

// Representa una arista hacia un vertice destino
// Incluye el peso de la arista (por defecto 1 si no se especifica)
public class Edge<E> {

    private Vertex<E> destination;
    private int weight;

    public Edge(Vertex<E> destination) {
        this(destination, 1);
    }

    public Edge(Vertex<E> destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex<E> getDestination() {
        return destination;
    }

    public void setDestination(Vertex<E> destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return destination.toString();
    }
}
