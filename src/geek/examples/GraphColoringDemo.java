package geek.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
//not so clear...
public class GraphColoringDemo {
	static class Graph {
		int V; // No. of vertices
		List<List<Integer>> adj; // A dynamic array of adjacency lists

		public Graph(int V) {
			this.V = V;
			adj = new ArrayList<List<Integer>>();
			for (int i = 0; i < V; i++) {
				adj.add(new LinkedList<Integer>());
			}
		}

		void addEdge(int v, int w) {
			adj.get(v).add(w);
			adj.get(w).add(v);// Note: the graph is undirected
		}

		// Assigns colors (starting from 0) to all vertices and prints
		// the assignment of colors
		void greedyColoring() {
			int result[] = new int[V];

			// Assign the first color to first vertex
			result[0] = 0;

			// Initialize remaining V-1 vertices as unassigned
			for (int u = 1; u < V; u++)
				result[u] = -1; // no color is assigned to u

			// A temporary array to store the available colors. True
			// value of available[cr] would mean that the color cr is
			// assigned to one of its adjacent vertices
			boolean available[] = new boolean[V];
			for (int cr = 0; cr < V; cr++)
				available[cr] = false;

			// Assign colors to remaining V-1 vertices
			for (int u = 1; u < V; u++) {
				// Process all adjacent vertices and flag their colors
				// as unavailable
				Iterator<Integer> i = adj.get(u).iterator();
				while (i.hasNext()) {
					int t = i.next();
					if (result[t] != -1) {
						available[result[t]] = true;
					}
				}

				// Find the first available color
				int cr;
				for (cr = 0; cr < V; cr++)
					if (available[cr] == false)
						break;

				result[u] = cr; // Assign the found color

				// Reset the values back to false for the next iteration
				i = adj.get(u).iterator();
				while (i.hasNext()) {
					int t = i.next();
					if (result[t] != -1) {
						available[result[t]] = true;
					}
				}
			}

			// print the result
			for (int u = 0; u < V; u++)
				System.out.println("Vertex " + u + " --->  Color " + result[u]);
		}

	}

	// Driver program to test above function
	public static void main(String args[]) {
		Graph g1 = new Graph(5);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		System.out.println("Coloring of Graph 1 \n");
		g1.greedyColoring();

		Graph g2 = new Graph(5);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 2);
		g2.addEdge(1, 4);
		g2.addEdge(2, 4);
		g2.addEdge(4, 3);
		System.out.println("Coloring of Graph 2 \n");
		g2.greedyColoring();

	}
}
