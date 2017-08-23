package geek.examples.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DetectCycle {
    //in undirected graph.
    static class Graph {
        int V; // No. of vertices
        List<List<Integer>> adjacency; // A dynamic array of adjacency lists

        public Graph(int V) {
            this.V = V;
            adjacency = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjacency.add(new LinkedList<>());
            }
        }

        void addEdge(int v, int w) {
            adjacency.get(v).add(w);
            adjacency.get(w).add(v);// Note: the graph is undirected
        }

        boolean isCyclicUtil(int v, boolean visited[], int parent) {
            // Mark the current node as visited
            visited[v] = true;

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> neighbours = adjacency.get(v).iterator();
            while (neighbours.hasNext()) {
                int adjacent = neighbours.next();
                // If an adjacent is not visited, then recur for that adjacent
                if (!visited[adjacent]) {
                    if (isCyclicUtil(adjacent, visited, v))
                        return true;
                }

                // If an adjacent is visited and not parent of current vertex,
                // then there is a cycle.
                else if (adjacent != parent)
                    return true;
            }
            return false;
        }

        // Returns true if the graph contains a cycle, else false.
        boolean isCyclic() {
            // Mark all the vertices as not visited and not part of recursion
            // stack
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            // Call the recursive helper function to detect cycle in different
            // DFS trees
            for (int u = 0; u < V; u++)
                if (!visited[u] && isCyclicUtil(u, visited, -1))
                    return true;

            return false;
        }
    }


    // Driver program to test above functions
    public static void main(String ars[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println(g1.isCyclic() ? "Graph contains cycle\n"
                : "Graph doesn't contain cycle\n");

        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println(g2.isCyclic() ? "Graph contains cycle\n"
                : "Graph doesn't contain cycle\n");

    }
}
