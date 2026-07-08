package ejercicio2;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;

//  TAD RedCiudades
 //  Representa una red de ciudades conectadas por carreteras//
//  mediante un grafo ponderado no dirigido usando JGraphT.//
 
// Vértices : ciudades (String)//
// Aristas  : carreteras con distancia en km (DefaultWeightedEdge)//
public class RedCiudades {

    // Grafo ponderado no dirigido de JGraphT
    private final Graph<String, DefaultWeightedEdge> grafo;

    // Constructor: inicializa el grafo vacío
    public RedCiudades() {
        grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
    }

    
    // Agrega una ciudad al grafo como vértice.
    //@param ciudad Nombre de la ciudad.
    
    public void agregarCiudad(String ciudad) {
        grafo.addVertex(ciudad);
    }

    //  Agrega una carretera entre dos ciudades con su distancia en km.
      //  Al ser no dirigido, la conexión funciona en ambos sentidos.
      //  @param origen      Ciudad de origen.
      //  @param destino     Ciudad de destino.
      // @param distanciaKm Distancia en kilómetros.
     //
    public void agregarCarretera(String origen, String destino, double distanciaKm) {
        DefaultWeightedEdge arista = grafo.addEdge(origen, destino);
        if (arista != null) {
            grafo.setEdgeWeight(arista, distanciaKm);
        }
    }

   
    // Muestra en consola la lista de ciudades registradas.
  
    public void mostrarCiudades() {
        System.out.println("          CIUDADES REGISTRADAS");
        int num = 1;
        for (String ciudad : grafo.vertexSet()) {
            System.out.println("  " + num + ". " + ciudad);
            num++;
        }
        System.out.println();
    }

    /**
     * Muestra en consola todas las carreteras del grafo
     * con sus ciudades y distancias.
     */
    public void mostrarCarreteras() {
        System.out.println("          CARRETERAS REGISTRADAS");
        System.out.printf("  %-15s %-15s %s%n", "Origen", "Destino", "Distancia (km)");
        for (DefaultWeightedEdge arista : grafo.edgeSet()) {
            String origen  = grafo.getEdgeSource(arista);
            String destino = grafo.getEdgeTarget(arista);
            double peso    = grafo.getEdgeWeight(arista);
            System.out.printf("  %-15s %-15s %.0f km%n", origen, destino, peso);
        }
        System.out.println();
    }


    public void caminoMasCorto(String origen, String destino) {
        System.out.println("  CAMINO MÁS CORTO: " + origen + " → " + destino);

        // Verificar que ambas ciudades existen
        if (!grafo.containsVertex(origen) || !grafo.containsVertex(destino)) {
            System.out.println("  ERROR: Una o ambas ciudades no existen en el grafo.");
            System.out.println();
            return;
        }

        // Aplicar Dijkstra
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra =
                new DijkstraShortestPath<>(grafo);

        var camino = dijkstra.getPath(origen, destino);

        if (camino == null) {
            System.out.println("  No existe un camino entre " + origen + " y " + destino + ".");
            System.out.println();
            return;
        }

        // Mostrar la ruta con el costo de cada tramo
        List<String> ruta = camino.getVertexList();
        double costoTotal = camino.getWeight();

        System.out.print("  Ruta: ");
        for (int i = 0; i < ruta.size(); i++) {
            System.out.print(ruta.get(i));
            if (i < ruta.size() - 1) {
                DefaultWeightedEdge tramo = grafo.getEdge(ruta.get(i), ruta.get(i + 1));
                System.out.printf(" --[%.0f km]--> ", grafo.getEdgeWeight(tramo));
            }
        }
        System.out.println();
        System.out.printf("  Costo total: %.0f km%n", costoTotal);
        System.out.println();
    }
}
