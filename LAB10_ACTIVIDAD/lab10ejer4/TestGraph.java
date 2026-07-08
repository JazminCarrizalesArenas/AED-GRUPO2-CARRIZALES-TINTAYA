public class TestGraph {

    public static void main(String[] args) {

        GraphLink<String> g1 =new GraphLink<>();

        g1.insertVertex("A");
        g1.insertVertex("B");
        g1.insertVertex("C");
        g1.insertVertex("D");

        g1.insertEdgeDirected("A","B");
        g1.insertEdgeDirected("A","C");
        g1.insertEdgeDirected("B","D");

        System.out.println(
        "======= GRAFO =======");

        System.out.println(g1);

        System.out.println("Es conexo: "+ g1.isConexo());

        System.out.println( "Es plano: "+ g1.isPlano());

        System.out.println("Es autocomplementario: "+ g1.isAutoComplementario());

        GraphLink<String> g2 =     new GraphLink<>();

        g2.insertVertex("X");
        g2.insertVertex("Y");
        g2.insertVertex("Z");
        g2.insertVertex("W");

        g2.insertEdgeDirected("X","Y");
        g2.insertEdgeDirected("X","Z");
        g2.insertEdgeDirected("Y","W");

        System.out.println( "Es isomorfo con g2: "+ g1.isIsomorfo(g2));
    }
}