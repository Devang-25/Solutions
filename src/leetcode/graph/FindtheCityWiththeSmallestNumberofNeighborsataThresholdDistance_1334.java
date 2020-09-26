package leetcode.graph;

import java.util.*;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance_1334 {

    public static void main(String[] args) {
        final int theCity = new FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance_1334().findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2);
        System.out.println(theCity);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
            graph.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }
        PriorityQueue<NeighbourCount> neighbourCounts = new PriorityQueue<>((o1, o2) -> {
            if (o1.neighbours < o2.neighbours) {
                return -1;
            }
            if (o1.neighbours == o2.neighbours) {
                if (o1.i >=o2.i) {
                    return -1;
                }
            }
            return 1;
        });
        for (int i = 0; i < n; i++) {
            System.out.println("DFS:" + i);
            final HashSet<Integer> visited = new HashSet<>();
            visited.add(i);
            int neighbours = dfs(graph, i, distanceThreshold, visited);
            System.out.println("Count:" + neighbours);
            neighbourCounts.add(new NeighbourCount(i, neighbours));
        }
        //System.out.println(neighbourCounts);
        return neighbourCounts.poll().i;

    }

    private int dfs(HashMap<Integer, List<Edge>> graph, int i, int distanceThreshold, HashSet<Integer> visited) {
        return 1+ graph.getOrDefault(i, new ArrayList<>()).stream().filter(x1 -> x1.dist <= distanceThreshold).filter(x1 -> !visited.contains(x1.w)).mapToInt(x -> {
            visited.add(x.w);
            return dfs(graph, x.w, distanceThreshold - x.dist, visited);
        }).sum();
    }

    class NeighbourCount {
        int i;
        int neighbours;

        public NeighbourCount(int i, int neighbours) {
            this.i = i;
            this.neighbours = neighbours;
        }

        @Override
        public String toString() {
            return "NeighbourCount{" +
                    "i=" + i +
                    ", neighbours=" + neighbours +
                    "}\n";
        }
    }

    class Edge {
        int w;
        int dist;

        public Edge(int w, int dist) {
            this.w = w;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "w=" + w +
                    ", dist=" + dist +
                    '}';
        }
    }
}
