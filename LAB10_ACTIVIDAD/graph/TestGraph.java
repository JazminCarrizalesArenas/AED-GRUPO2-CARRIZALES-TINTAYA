package graph;

// Clase de prueba para el TAD GraphLink
// Primero reproduce exactamente la prueba del laboratorio,
// luego prueba los metodos adicionales implementados
public class TestGraph {

    public static void main(String[] args) {

     
        GraphLink<String> g = new GraphLink<>();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");

        System.out.println(g);

        // Prueba de recorridos
        g.BFS("A");
        g.DFS("A");
        System.out.println();

        // Prueba de busquedas
        System.out.println("Existe vertice A: " + g.searchVertex("A"));
        System.out.println("Existe vertice Z: " + g.searchVertex("Z"));
        System.out.println("Existe arista A-B: " + g.searchEdge("A", "B"));
        System.out.println("Existe arista A-D: " + g.searchEdge("A", "D"));
        System.out.println();

        // Prueba de vertices adyacentes
        g.adjacentVertices("A");
        System.out.println();

        // Prueba de isConnected
        System.out.println("El grafo es conexo: " + g.isConnected());
        System.out.println();

        // Prueba de removeEdge
        System.out.println("Despues de eliminar arista A-C:");
        g.removeEdge("A", "C");
        System.out.println(g);

        // Prueba de removeVertex
        System.out.println("Despues de eliminar vertice B:");
        g.removeVertex("B");
        System.out.println(g);

        // Grafo no conexo para verificar isConnected
        GraphLink<String> g2 = new GraphLink<>();
        g2.insertVertex("X");
        g2.insertVertex("Y");
        g2.insertVertex("Z");
        g2.insertEdge("X", "Y");
        // Z queda aislado
        System.out.println("Grafo con vertice aislado, es conexo: " + g2.isConnected());
    }
}
