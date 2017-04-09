package geek.examples;

import java.util.LinkedList;
import java.util.Queue;

public class FordFulkersonAlgorithm {
	private static int V = 0;

	public static void main(String args[]) {
		// Let us create a graph shown in the above example
		int graph[][] = { { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
				{ 0, 4, 0, 0, 14, 0 }, { 0, 0, 9, 0, 0, 20 },
				{ 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };

		fordFulkerson(graph, 0, 5);

	}

	static boolean breadthFirstSearch(int rGraph[][], int s, int t,
			int parent[]) {
		// Create a visited array and mark all vertices as not visited
		boolean visited[] = new boolean[rGraph.length];

		// Create a queue, enqueue source vertex and mark source vertex
		// as visited
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		parent[s] = -1;

		// Standard BFS Loop
		while (!q.isEmpty()) {
			int u = q.element();
			q.remove();

			for (int v = 0; v < V; v++) {
				if (visited[v] == false && rGraph[u][v] > 0) {
					q.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}

		// If we reached sink in BFS starting from source, then return
		// true, else false
		return (visited[t] == true);
	}

	// Returns tne maximum flow from s to t in the given graph
	static int fordFulkerson(int graph[][], int s, int t) {
		// Create a residual graph and fill the residual graph with
		// given capacities in the original graph as residual capacities
		// in residual graph
		int rGraph[][] = new int[V][V]; // Residual graph where rGraph[i][j]
										// indicates
		// residual capacity of edge from i to j (if there
		// is an edge. If rGraph[i][j] is 0, then there is not)
		for (int u = 0; u < V; u++)
			for (int v = 0; v < V; v++)
				rGraph[u][v] = graph[u][v];
		int parent[] = new int[V]; // This array is filled by BFS and to store
									// path
		int max_flow = 0; // There is no flow initially
		// Augment the flow while there is path from source to sink
		while (breadthFirstSearch(rGraph, s, t, parent)) {
			// Find minimum residual capacity of the edhes along the
			// path filled by BFS. Or we can say find the maximum flow
			// through the path found.
			int path_flow = Integer.MAX_VALUE;
			for (int v = t; v != s; v = parent[v]) {
				int u = parent[v];
				path_flow = Math.min(path_flow, rGraph[u][v]);
			}

			// update residual capacities of the edges and reverse edges
			// along the path
			for (int v = t; v != s; v = parent[v]) {
				int u = parent[v];
				rGraph[u][v] -= path_flow;
				rGraph[v][u] += path_flow;
			}

			// Add path flow to overall flow
			max_flow += path_flow;
		}

		// Return the overall flow
		return max_flow;
	}

}