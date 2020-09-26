package leetcode.graph;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        final int cheapestPrice = new CheapestFlightsWithinKStops().findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);
        System.out.println(cheapestPrice);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        final PriorityQueue<Dist> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.cost <= o2.cost) {
                return -1;
            }
            return 1;
        });

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            graph.putIfAbsent(flights[i][0], new ArrayList<>());
            graph.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
        }
        graph.get(src).forEach(s -> priorityQueue.add(new Dist(s.cost, 0, s.dest)));
        while (!priorityQueue.isEmpty()) {
            final Dist dist = priorityQueue.remove();
            final int v = dist.dest;
            if (v == dst) {
                return dist.cost;
            }
            if (dist.hops < K) {
                for (Edge edge : graph.getOrDefault(v, new ArrayList<>())) {
                    priorityQueue.add(new Dist(edge.cost + dist.cost, dist.hops + 1, edge.dest));
                }
            }
        }
        return -1;
    }

    class Edge {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    class Dist {
        int cost;
        int hops;
        int dest;

        public Dist(int cost, int hops, int dest) {
            this.cost = cost;
            this.hops = hops;
            this.dest = dest;
        }
    }

}
