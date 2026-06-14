package graph;

import listlinked.ListLinked;
import java.util.LinkedList;
import java.util.Queue;

// Implementacion del TAD Grafo No Dirigido usando listas de adyacencia
// Cada entrada del grafo es un AdjList que contiene un vertice y sus aristas
public class GraphLink<E> {

    private ListLinked<AdjList<E>> graph;

    public GraphLink() {
        graph = new ListLinked<>();
    }

    // Inserta un nuevo vertice al grafo
    public void insertVertex(E data) {
        Vertex<E> vertex = new Vertex<>(data);
        graph.addLast(new AdjList<>(vertex));
    }

    // Inserta una arista no dirigida entre origin y destination
    // Se agrega en ambas listas porque el grafo no tiene direccion
    public void insertEdge(E origin, E destination) {
        AdjList<E> v1 = findVertex(origin);
        AdjList<E> v2 = findVertex(destination);

        if (v1 == null || v2 == null)
            return;

        v1.getEdges().addLast(new Edge<>(v2.getVertex()));
        v2.getEdges().addLast(new Edge<>(v1.getVertex()));
    }

    // Elimina un vertice del grafo y todas las aristas que apunten a el
    public void removeVertex(E data) {
        AdjList<E> target = findVertex(data);
        if (target == null) return;

        // Quitar las aristas que apuntan a este vertice desde los demas
        for (int i = 0; i < graph.size(); i++) {
            AdjList<E> adj = graph.get(i);
            if (!adj.getVertex().getData().equals(data)) {
                removeEdgeFromList(adj, data);
            }
        }
        graph.remove(target);
    }

    // Elimina la arista entre origin y destination en ambas direcciones
    public void removeEdge(E origin, E destination) {
        AdjList<E> v1 = findVertex(origin);
        AdjList<E> v2 = findVertex(destination);

        if (v1 == null || v2 == null) return;

        removeEdgeFromList(v1, destination);
        removeEdgeFromList(v2, origin);
    }

    // Retorna true si el vertice con ese dato existe en el grafo
    public boolean searchVertex(E data) {
        return findVertex(data) != null;
    }

    // Retorna true si existe una arista entre origin y destination
    public boolean searchEdge(E origin, E destination) {
        AdjList<E> adjList = findVertex(origin);
        if (adjList == null) return false;

        ListLinked<Edge<E>> edges = adjList.getEdges();
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getDestination().getData().equals(destination))
                return true;
        }
        return false;
    }

    // Muestra los vertices adyacentes al vertice dado
    public void adjacentVertices(E data) {
        AdjList<E> adjList = findVertex(data);
        if (adjList == null) {
            System.out.println("El vertice no existe");
            return;
        }
        System.out.println("Adyacentes de " + data + ": " + adjList.getEdges());
    }

    // Recorrido en anchura (BFS) a partir del vertice start
    // Usa una cola: visita primero todos los vecinos antes de ir mas profundo
    public void BFS(E start) {
        AdjList<E> startAdj = findVertex(start);
        if (startAdj == null) {
            System.out.println("El vertice no existe");
            return;
        }

        ListLinked<E> visited = new ListLinked<>();
        Queue<E> queue = new LinkedList<>();

        queue.add(start);
        visited.addLast(start);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            E current = queue.poll();
            System.out.print(current + " ");

            AdjList<E> currentAdj = findVertex(current);
            if (currentAdj == null) continue;

            ListLinked<Edge<E>> edges = currentAdj.getEdges();
            for (int i = 0; i < edges.size(); i++) {
                E neighbor = edges.get(i).getDestination().getData();
                if (!visited.contains(neighbor)) {
                    visited.addLast(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Recorrido en profundidad (DFS) a partir del vertice start
    // Usa recursividad: avanza lo mas profundo posible antes de retroceder
    public void DFS(E start) {
        AdjList<E> startAdj = findVertex(start);
        if (startAdj == null) {
            System.out.println("El vertice no existe");
            return;
        }

        ListLinked<E> visited = new ListLinked<>();
        System.out.print("DFS: ");
        dfsRecursive(start, visited);
        System.out.println();
    }

    // Metodo auxiliar recursivo del DFS
    private void dfsRecursive(E current, ListLinked<E> visited) {
        visited.addLast(current);
        System.out.print(current + " ");

        AdjList<E> currentAdj = findVertex(current);
        if (currentAdj == null) return;

        ListLinked<Edge<E>> edges = currentAdj.getEdges();
        for (int i = 0; i < edges.size(); i++) {
            E neighbor = edges.get(i).getDestination().getData();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    // Retorna true si el grafo es conexo (todos los vertices estan conectados)
    // Usa BFS desde el primer vertice y verifica que visite todos
    public boolean isConnected() {
        if (graph.isEmpty()) return true;

        ListLinked<E> visited = new ListLinked<>();
        Queue<E> queue = new LinkedList<>();

        E start = graph.get(0).getVertex().getData();
        queue.add(start);
        visited.addLast(start);

        while (!queue.isEmpty()) {
            E current = queue.poll();
            AdjList<E> currentAdj = findVertex(current);
            if (currentAdj == null) continue;

            ListLinked<Edge<E>> edges = currentAdj.getEdges();
            for (int i = 0; i < edges.size(); i++) {
                E neighbor = edges.get(i).getDestination().getData();
                if (!visited.contains(neighbor)) {
                    visited.addLast(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // Si visito todos los vertices, el grafo es conexo
        return visited.size() == graph.size();
    }

    // Busca y retorna el AdjList del vertice con el dato dado
    // Retorna null si no lo encuentra
    private AdjList<E> findVertex(E data) {
        for (int i = 0; i < graph.size(); i++) {
            AdjList<E> adj = graph.get(i);
            if (adj.getVertex().getData().equals(data))
                return adj;
        }
        return null;
    }

    // Elimina de la lista de aristas de adj la que apunta a destination
    private void removeEdgeFromList(AdjList<E> adj, E destination) {
        ListLinked<Edge<E>> edges = adj.getEdges();
        for (int i = 0; i < edges.size(); i++) {
            Edge<E> edge = edges.get(i);
            if (edge.getDestination().getData().equals(destination)) {
                edges.remove(edge);
                return;
            }
        }
    }

    // Muestra el grafo como lista de adyacencia
    // Formato igual al del laboratorio: A -> B C
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.size(); i++) {
            AdjList<E> adj = graph.get(i);
            sb.append(adj.getVertex()).append(" -> ");
            for (int j = 0; j < adj.getEdges().size(); j++) {
                sb.append(adj.getEdges().get(j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
