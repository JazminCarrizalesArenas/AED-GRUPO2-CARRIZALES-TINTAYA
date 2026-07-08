import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class GraphLink<E> {

    private ListLinked<AdjList<E>> graph;

    public GraphLink() {
        graph = new ListLinked<>();
    }

    public void insertVertex(E data) {

        Vertex<E> vertex = new Vertex<>(data);
        graph.addLast(new AdjList<>(vertex));
    }

    private AdjList<E> findVertex(E data) {

        for (int i = 0; i < graph.size(); i++) {

            AdjList<E> adj = graph.get(i);

            if (adj.getVertex().getData().equals(data)) {
                return adj;
            }
        }

        return null;
    }

    public void insertEdge(E origin, E destination) {

        AdjList<E> v1 = findVertex(origin);
        AdjList<E> v2 = findVertex(destination);

        if (v1 == null || v2 == null) {
            return;
        }

        v1.getEdges().addLast(
                new Edge<>(v2.getVertex())
        );

        v2.getEdges().addLast(
                new Edge<>(v1.getVertex())
        );
    }
    
    //ejercicio 1 :Inserta una arista entre dos vértices con un peso determinado.
    public void insertEdgeWeight(E origen, E destino, int peso) {
    
        AdjList<E> verticeOrigen = findVertex(origen);
        AdjList<E> verticeDestino = findVertex(destino);
    
        if (verticeOrigen == null || verticeDestino == null) {
            return;
        }
    
        verticeOrigen.getEdges().addLast(
                new Edge<>(verticeDestino.getVertex(), peso)
        );
    
        verticeDestino.getEdges().addLast(
                new Edge<>(verticeOrigen.getVertex(), peso)
        );
    }
    
    //Verifica si todos los vértices están conectados entre sí.
    public boolean isConexo() {
    
        if (graph.size() == 0) {
            return true;
        }
    
        HashSet<E> visitados = new HashSet<>();
    
        recorrer(graph.get(0).getVertex().getData(),visitados);
    
        return visitados.size() == graph.size();
    }

    //Usa la idea del algoritmo DFS (Depth First Search).
    private void recorrer(E dato, HashSet<E> visitados) {
    
        if (visitados.contains(dato)) {
            return;
        }
    
        visitados.add(dato);
    
        AdjList<E> actual = findVertex(dato);
    
        for (int i = 0; i < actual.getEdges().size(); i++) {
    
            recorrer(
                    actual.getEdges()
                          .get(i)
                          .getDestination()
                          .getData(),
                    visitados
            );
        }
    }
    //Encuentra la ruta de menor costo entre dos vértices.
    public Stack<E> dijkstra(E inicio, E fin) {
        
            HashMap<E, Integer> distancia = new HashMap<>();
            HashMap<E, E> anterior = new HashMap<>();
            HashSet<E> visitados = new HashSet<>();
        
            for (int i = 0; i < graph.size(); i++) {
        
                E vertice = graph.get(i)
                                 .getVertex()
                                 .getData();
        
                distancia.put(vertice, Integer.MAX_VALUE);
            }
        
            distancia.put(inicio, 0);
        
            while (visitados.size() < graph.size()) {
        
                E actual = null;
                int menor = Integer.MAX_VALUE;
        
                for (E v : distancia.keySet()) {
        
                    if (!visitados.contains(v)
                            && distancia.get(v) < menor) {
        
                        menor = distancia.get(v);
                        actual = v;
                    }
                }
        
                if (actual == null) {
                    break;
                }
        
                visitados.add(actual);
        
                AdjList<E> lista = findVertex(actual);
        
                for (int i = 0; i < lista.getEdges().size(); i++) {
        
                    Edge<E> arista = lista.getEdges().get(i);
        
                    E vecino =
                            arista.getDestination().getData();
        
                    int nuevaDistancia =
                            distancia.get(actual)
                            + arista.getWeight();
        
                    if (nuevaDistancia <
                            distancia.get(vecino)) {
        
                        distancia.put(
                                vecino,
                                nuevaDistancia
                        );
        
                        anterior.put(
                                vecino,
                                actual
                        );
                }
            }
        }
        
        Stack<E> camino = new Stack<>();
        
        E paso = fin;
        
        while (paso != null) {
        
            camino.push(paso);
            paso = anterior.get(paso);
        }
        
        return camino;
    }
        
    public ArrayList<E> shortPath(E origen, E destino) {
    
        Stack<E> pila =
                dijkstra(origen, destino);
    
        ArrayList<E> ruta =
                new ArrayList<>();
    
        while (!pila.isEmpty()) {
    
            ruta.add(
                    pila.pop()
            );
        }
    
        return ruta;
    }
    


    @Override
    public String toString() {
    
        StringBuilder texto =
                new StringBuilder();
    
        for (int i = 0; i < graph.size(); i++) {
    
            AdjList<E> lista =
                    graph.get(i);
    
            texto.append(
                    lista.getVertex()
            ).append(" -> ");
    
            for (int j = 0;
                 j < lista.getEdges().size();
                 j++) {
    
                Edge<E> arista =
                        lista.getEdges().get(j);
    
                texto.append("(")
                     .append(
                             arista.getDestination()
                     )
                     .append(", ")
                     .append(
                             arista.getWeight()
                     )
                     .append(") ");
            }
    
            texto.append("\n");
        }
    
        return texto.toString();
    }
}