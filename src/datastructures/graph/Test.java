/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.disjointsets.DisjointSet;
import datastructures.priorityqueue.Pair;

/**
 *
 * @author gopimac
 */
public class Test {

    public static void disjointSetDemo() {
        GenericLinkedGraph graph = new GenericLinkedGraph(true);
        for (int i = 1; i <= 10; i++) {
            graph.insert(i);
        }
        graph.insert(new Edge(1, 2));
        graph.insert(new Edge(1, 3));
        graph.insert(new Edge(2, 3));
        graph.insert(new Edge(2, 4));
        graph.insert(new Edge(5, 6));
        graph.insert(new Edge(5, 7));
        graph.insert(new Edge(8, 9));
        System.out.println(graph);
        for (DisjointSet set : GraphAlgorithms.findConnectedComponents(graph)) {
            System.out.println("SET: " + set);
        }
    }

    public static void topologicalSortDemo() {
        GenericLinkedGraph graph = new GenericLinkedGraph(true);
        int v[] = {7, 2, 3, 11, 5, 8, 9, 10};
        for (int i = 0; i < v.length; i++) {
            graph.insert(v[i]);
        }
        Edge e[] = {new Edge(7, 8), new Edge(7, 11), new Edge(11, 2), new Edge(11, 9), new Edge(11, 10), new Edge(8, 9), new Edge(3, 8), new Edge(3, 10), new Edge(5, 11)};
        for (Edge d : e) {
            graph.insert(d);
        }

        int sortedList[] = GraphAlgorithms.topologicalSort(graph);
        for (int i : sortedList) {
            System.out.print("" + i + "\t");
        }

    }

    public static void graphCreationDemo() {
        GenericLinkedGraph g = new GenericLinkedGraph(true);
        for (int i = 0; i < 10; i++) {
            g.insert(i);
        }
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                try {
                    int v = (int) (Math.random() * 10);
                    int w = (int) (Math.random() * 10);
                    System.out.println("Trying to add edge: " + v + " to " + w);
                    g.insert(new Edge(v, w));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println(g);
    }

    public static void simplePathTest() {
        GenericLinkedGraph g = new GenericLinkedGraph(true);
        for (int i = 1; i <= 6; i++) {
            g.insert(i);
        }
        g.insert(new Edge(1, 2));
        g.insert(new Edge(1, 3));
        g.insert(new Edge(2, 3));
        g.insert(new Edge(1, 4));
        g.insert(new Edge(5, 6));
        g.insert(new Edge(5, 4));
        g.insert(new Edge(3, 4));
        g.insert(new Edge(6, 1));
        g.insert(new Edge(5, 3));
        System.out.println(g);
        List<? extends List<Integer>> pathList = GraphAlgorithms.simplePath(g, 1, 4);
        for (List<Integer> path : pathList) {
            System.out.println(path);
        }
    }

    public static void connectedComponentsTestDemo() {
        GenericLinkedGraph graph = new GenericLinkedGraph(true);
        for (int i = 0; i <= 12; i++) {
            graph.insert(i);
        }
        graph.insert(new Edge(0, 5));
        graph.insert(new Edge(0, 1));
        graph.insert(new Edge(0, 2));
        graph.insert(new Edge(0, 6));
        graph.insert(new Edge(6, 4));
        graph.insert(new Edge(4, 3));
        graph.insert(new Edge(4, 5));
        graph.insert(new Edge(7, 8));
        graph.insert(new Edge(9, 10));
        graph.insert(new Edge(9, 11));
        graph.insert(new Edge(9, 12));
        graph.insert(new Edge(11, 12));
        Set<Map.Entry<Integer, Integer>> set = GraphAlgorithms.connectedComponents(graph);
        for (Map.Entry<Integer, Integer> e : set) {
            System.out.println(e);
        }
    }

    public static void biPartiteComponentsTest() {
        GenericLinkedGraph graph = new GenericLinkedGraph(true);
        for (int i = 0; i <= 7; i++) {
            graph.insert(i);
        }
        graph.insert(new Edge(0, 2));
        graph.insert(new Edge(7, 2));
        graph.insert(new Edge(0, 5));
        graph.insert(new Edge(2, 6));
        graph.insert(new Edge(6, 4));
        graph.insert(new Edge(7, 5));
        graph.insert(new Edge(7, 1));
        graph.insert(new Edge(4, 7));
        graph.insert(new Edge(4, 3));
        graph.insert(new Edge(3, 5));
        Pair p = GraphAlgorithms.getBiParttiteComponents(graph);
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
    }

    public static void bridgesDemo() {
        GenericLinkedGraph graph = new GenericLinkedGraph(false);
        for (int v = 0; v <= 14; v++) {
            graph.insert(v);
        }
        graph.insert(new Edge(0, 6));
        graph.insert(new Edge(8, 13));
        graph.insert(new Edge(13, 14));
        graph.insert(new Edge(14, 8));
        graph.insert(new Edge(0, 1));
        graph.insert(new Edge(0, 5));
        graph.insert(new Edge(7, 6));
        graph.insert(new Edge(6, 2));
        graph.insert(new Edge(1, 2));
        graph.insert(new Edge(7, 8));
        graph.insert(new Edge(8, 10));
        graph.insert(new Edge(7, 10));
        graph.insert(new Edge(5, 4));
        graph.insert(new Edge(5, 3));
        graph.insert(new Edge(3, 4));
        graph.insert(new Edge(4, 9));
        graph.insert(new Edge(4, 11));
        graph.insert(new Edge(9, 11));
        graph.insert(new Edge(11, 12));
        System.out.println(graph);
        List<Edge> list = GraphAlgorithms.getBridges(graph);
        System.out.println(list);
    }

    public static void primTest() {
        GenericLinkedGraph graph = new GenericLinkedGraph(false);
        for (int i = 0; i <= 7; i++) {
            graph.insert(i);
        }
        graph.insert(new Edge(0, 1, 50));
        graph.insert(new Edge(0, 5, 90));
        graph.insert(new Edge(0, 7, 20));
        graph.insert(new Edge(6, 0, 60));
        graph.insert(new Edge(0, 2, 10));
        graph.insert(new Edge(1, 7, 30));
        graph.insert(new Edge(7, 6, 40));
        graph.insert(new Edge(7, 4, 45));
        graph.insert(new Edge(5, 3, 75));
        graph.insert(new Edge(5, 4, 80));
        graph.insert(new Edge(3, 4, 70));
        graph.insert(new Edge(6, 4, 110));
        System.out.println(graph);
        GraphIterable gr = GraphAlgorithms.getMSTPrim(graph);
        System.out.println(gr);
    }
}
