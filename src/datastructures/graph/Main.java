package datastructures.graph;



public class Main {

    public static void main(String[] args) {
        GenericLinkedGraph graph = new GenericLinkedGraph(false);
        for (int i = 0; i <= 7; i++) {
            graph.insert(i);
        }
        graph.insert(new Edge(0, 1, 32));
        graph.insert(new Edge(0, 5, 60));
        graph.insert(new Edge(7,0, 31));
        graph.insert(new Edge(0,6, 51));
        graph.insert(new Edge(0, 2, 29));
        graph.insert(new Edge(7,1, 21));
        graph.insert(new Edge(7, 6, 25));
        graph.insert(new Edge(7, 4, 46));
        graph.insert(new Edge(5, 3, 18));
        graph.insert(new Edge(5, 4, 40));
        graph.insert(new Edge(4,3, 34));
        graph.insert(new Edge(6, 4, 52));
        System.out.println(graph);
        GraphIterable gr = GraphAlgorithms.getMSTKrushkal(graph);
        System.out.println(gr);

    }
}
