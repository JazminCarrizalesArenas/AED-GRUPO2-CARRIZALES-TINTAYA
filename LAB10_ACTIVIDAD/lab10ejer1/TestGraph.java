
import java.util.ArrayList;
import java.util.Stack;

public class TestGraph {

    public static void main(String[] args) {

        GraphLink<String> ciudad =
                new GraphLink<>();

        ciudad.insertVertex("A");
        ciudad.insertVertex("B");
        ciudad.insertVertex("C");
        ciudad.insertVertex("D");
        ciudad.insertVertex("E");

        ciudad.insertEdgeWeight("A", "B", 4);
        ciudad.insertEdgeWeight("A", "C", 2);
        ciudad.insertEdgeWeight("B", "D", 5);
        ciudad.insertEdgeWeight("C", "D", 1);
        ciudad.insertEdgeWeight("D", "E", 3);

        System.out.println(
                "================================"
        );
        System.out.println(
                "      GRAFO PONDERADO"
        );
        System.out.println(
                "================================"
        );

        System.out.println(ciudad);

        System.out.println(
                "El grafo es conexo: "
                + ciudad.isConexo()
        );

        ArrayList<String> ruta =
                ciudad.shortPath(
                        "A",
                        "E"
                );

        System.out.println(
                "\nRuta mas corta:"
        );

        System.out.println(ruta);

        Stack<String> pila =
                ciudad.dijkstra(
                        "A",
                        "E"
                );

        System.out.println(
                "\nRuta en Stack:"
        );

        while (!pila.isEmpty()) {

            System.out.print(
                    pila.pop()
            );

            if (!pila.isEmpty()) {
                System.out.print(
                        " -> "
                );
            }
        }
    }
}