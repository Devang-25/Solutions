package leetcode;

import java.util.*;

public class RedundantConnection {

    public static void main(String[] args) {
        final int[] redundantConnection = new RedundantConnection().findRedundantConnection(new int[][]{{1, 3}, {3, 4}, {1, 5}, {3, 5}, {2, 3}});
        System.out.println(redundantConnection[0] + ", " + redundantConnection[1]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][0]).add(new Edge(edges[i][0], edges[i][1], i));
            graph.get(edges[i][1]).add(new Edge(edges[i][1], edges[i][0], i));
        }
        visited.add(edges[0][0]);
        Edge e = process(graph, new Edge(-1, edges[0][0], 0), visited);
        if (e == null) {
            return new int[]{0, 0};
        }
        return new int[]{Math.min(e.s, e.e), Math.max(e.s, e.e)};
    }

    private Edge process(Map<Integer, List<Edge>> graph, Edge v, Set<Integer> visited) {
        final List<Edge> edges = graph.get(v.e);
        for (Edge e : edges) {
            if (visited.contains(e.e)) {
                if (v.s != e.e)
                    return e;
            } else {
                visited.add(e.e);
                final Edge duplicate = process(graph, e, visited);
                visited.remove(e.e);
                if (duplicate != null) {
                    if (duplicate.order < e.order)
                        return e;
                    else {
                        return duplicate;
                    }
                }
            }
        }
        return null;
    }

    class Edge {
        int s;
        int e;
        int order;

        public Edge(int s, int e, int order) {
            this.s = s;
            this.e = e;
            this.order = order;
        }
    }
}
