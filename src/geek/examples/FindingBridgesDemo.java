package geek.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* In DFS tree an edge (u, v) 
 * (u is parent of v in DFS tree) 
 * is bridge if there does not exit any other alternative to reach u 
 * or an ancestor of u from subtree rooted with v. 
 * The value low[v] indicates earliest visited vertex reachable from subtree rooted with v. 
 * The condition for an edge (u, v) to be a bridge is, “low[v] > disc[u]“.
 * */
public class FindingBridgesDemo {

	// Driver program to test above function
	public static void main(String args[]) {
		/*
		 * // Create graphs given in above diagrams
		 * System.out.println("\nBridges in first graph \n"); Graph g1 = new
		 * Graph(5); g1.addEdge(1, 0); g1.addEdge(0, 2); g1.addEdge(2, 1);
		 * g1.addEdge(0, 3); g1.addEdge(3, 4); g1.bridge();
		 * 
		 * System.out.println("\nBridges in second graph \n"); Graph g2 = new
		 * Graph(4); g2.addEdge(0, 1); g2.addEdge(1, 2); g2.addEdge(2, 3);
		 * g2.bridge();
		 * 
		 * System.out.println("\nBridges in third graph \n"); Graph g3 = new
		 * Graph(7); g3.addEdge(0, 1); g3.addEdge(1, 2); g3.addEdge(2, 0);
		 * g3.addEdge(1, 3); g3.addEdge(1, 4); g3.addEdge(1, 6); g3.addEdge(3,
		 * 5); g3.addEdge(4, 5); g3.bridge();
		 */

		Scanner in = new Scanner(System.in);
		int islands = in.nextInt();
		int roads = in.nextInt();
		Graaph g = new Graaph(islands + 1);
		for (int i = 0; i < roads; i++) {
			int s = in.nextInt();
			int e = in.nextInt();
			g.addEdge(s, e);
		}
		int bombs=in.nextInt();
		for(int b=1;b<=bombs;b++){
			
		}

	}
}

class Graaph {
	int V; // No. of vertices
	List<List<Integer>> adjacency; // A dynamic array of adjacency lists
	boolean visited[] = null;
	int disc[] = null;
	int low[] = null;
	int parent[] = null;

	public Graaph(int V) {
		this.V = V;
		adjacency = new ArrayList<List<Integer>>();
		for (int i = 0; i < V; i++) {
			adjacency.add(new LinkedList<Integer>());
		}
	}

	void addEdge(int v, int w) {
		adjacency.get(v).add(w);
		adjacency.get(w).add(v);// Note: the graph is undirected
	}

	static int time = 0;

	// A recursive function that finds and prints bridges using DFS
	// traversal
	// u --> The vertex to be visited next
	// visited[] --> keeps tract of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	private void bridgeUtil(int u, boolean visited[], int disc[], int low[],
			int parent[]) {
		// A static variable is used for simplicity, we can avoid use of
		// static
		// variable by passing a pointer.

		// Mark the current node as visited
		visited[u] = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++time;

		// Go through all vertices aadjacent to this
		Iterator<Integer> i = adjacency.get(u).iterator();
		while (i.hasNext()) {
			int v = i.next(); // v is current adjacent of u

			// If v is not visited yet, then recur for it
			if (!visited[v]) {
				parent[v] = u;

				bridgeUtil(v, visited, disc, low, parent);

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);
				// If the lowest vertex reachable from subtree under v is
				// below u in DFS tree, then u-v is a bridge
				if (low[v] > disc[u])
					System.out.println(u + "\t" + v);
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
		}
	}

	private void displayArray() {
		System.out.println("idx\t");
		for (int i = 1; i < parent.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.print("dsc\t");
		for (int i = 1; i < disc.length; i++) {
			System.out.print(disc[i] + "\t");
		}
		System.out.println();
		System.out.print("par\t");
		for (int i = 1; i < parent.length; i++) {
			System.out.print(parent[i] + "\t");
		}
		System.out.println();
		System.out.print("low\t");
		for (int i = 1; i < low.length; i++) {
			System.out.print(low[i] + "\t");
		}
		System.out.println();
	}

	// DFS based function to find all bridges. It uses recursive function
	// bridgeUtil()
	void bridge() {
		// Mark all the vertices as not visited
		visited = new boolean[V];
		disc = new int[V];
		low = new int[V];
		parent = new int[V];

		// Initialize parent and visited arrays
		for (int i = 1; i < V; i++) {
			parent[i] = -1;
			visited[i] = false;
		}

		// Call the recursive helper function to find Bridges
		// in DFS tree rooted with vertex 'i'
		for (int i = 1; i < V; i++)
			if (visited[i] == false)
				bridgeUtil(i, visited, disc, low, parent);
	}
}