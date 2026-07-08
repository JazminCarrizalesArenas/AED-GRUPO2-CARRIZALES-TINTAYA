public class TestGraph {

    public static void main(String[] args) {

        GraphLink<String> red = new GraphLink<>();

        // Agregar vertices
        red.insertVertex("A");
        red.insertVertex("B");
        red.insertVertex("C");
        red.insertVertex("D");
        red.insertVertex("E");

        // Agregar aristas con peso
        red.insertEdgeWeight("A", "B", 4);
        red.insertEdgeWeight("A", "C", 2);
        red.insertEdgeWeight("B", "D", 5);
        red.insertEdgeWeight("C", "D", 1);
        red.insertEdgeWeight("D", "E", 3);

        System.out.println("\nGRAFO REGISTRADO");
        System.out.println(red);

        // Buscar vertices
        System.out.println("------------------------------------");
        System.out.println("BUSQUEDA DE VERTICES");
        System.out.println("------------------------------------");

        System.out.println("Existe A: " + red.searchVertex("A"));
        System.out.println("Existe Z: " + red.searchVertex("Z"));

        // Buscar aristas
        System.out.println("\n------------------------------------");
        System.out.println("BUSQUEDA DE ARISTAS");
        System.out.println("------------------------------------");

        System.out.println("Existe A - B: " + red.searchEdge("A", "B"));

        System.out.println("Existe A - E: "+ red.searchEdge("A", "E"));

        // Vertices adyacentes
        System.out.println("\n------------------------------------");
        System.out.println("VERTICES ADYACENTES");
        System.out.println("------------------------------------");

        System.out.println("Adyacentes de A: "+ red.adjacentVertices("A"));

        System.out.println("Adyacentes de D: "+ red.adjacentVertices("D"));

        // Verificar conectividad
        System.out.println("\n------------------------------------");
        System.out.println("GRAFO CONEXO");
        System.out.println("------------------------------------");

        System.out.println("Es conexo: " + red.isConexo());

        // Ruta mas corta
        System.out.println("\n------------------------------------");
        System.out.println("RUTA MAS CORTA");
        System.out.println("------------------------------------");

        System.out.println("Ruta de A a E: "+ red.shortPath("A", "E"));

        // Eliminar arista
        System.out.println("\n\n------------------------------------");
        System.out.println("ELIMINAR ARISTA A - C");
        System.out.println("------------------------------------");

        red.removeEdge("A", "C");

        System.out.println(red);

        // Eliminar vertice
        System.out.println("------------------------------------");
        System.out.println("ELIMINAR VERTICE E");
        System.out.println("------------------------------------");

        red.removeVertex("E");

        System.out.println(red);
    }
}