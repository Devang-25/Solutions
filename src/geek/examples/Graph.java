package geek.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// A class that represents an undirected graph
public class Graph {
	int V; // No. of vertices
	List<List<Integer>> adjacency; // A dynamic array of adjacency lists

	public Graph(int V) {
		this.V = V;
		adjacency = new ArrayList<List<Integer>>();
		for (int i = 0; i <V; i++) {
			adjacency.add(new LinkedList<Integer>());
		}
	}

	void addEdge(int v, int w) {
		adjacency.get(v).add( w);
		adjacency.get(w).add( v);// Note: the graph is undirected
	}

	// A recursive function that find articulation points using DFS traversal
	// u --> The vertex to be visited next
	// visited[] --> keeps tract of visited vertices
	// disc[] --> Stores discovery times of visited vertices
	// parent[] --> Stores parent vertices in DFS tree
	// ap[] --> Store articulation points
	static int time = 0;

	public void aputil(int u, boolean visited[], int discovery[], int low[],
			int parent[], boolean articulationPoint[]) {

		// A static variable is used for simplicity, we can avoid use of static
		// variable by passing a pointer.

		// Count of children in DFS Tree
		int children = 0;

		// Mark the current node as visited
		visited[u] = true;

		// Initialize discovery time and low value
		discovery[u] = low[u] = ++time;

		// Go through all vertices adjacent to this
		Iterator<Integer> iterator = adjacency.get(u).iterator();
		while (iterator.hasNext()) {
			int v = iterator.next(); // v is current adjacent of u

			// If v is not visited yet, then make it a child of u
			// in DFS tree and recur for it
			if (!visited[v]) {
				children++;
				parent[v] = u;
				aputil(v, visited, discovery, low, parent, articulationPoint);
				
				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				/*low[u] means the backward reachability of u...which ancestor can i reach from this vertex. */
				low[u] = Math.min(low[u], low[v]);//which is the farthest point i can reach from u.. 
				//if after exploring sub tree rooted at v, i can go back furthur, i must update it.

				// u is an articulation point in following cases

				// (1) u is root of DFS tree and has two or more chilren.
				if (parent[u] == -1 && children > 1)
					articulationPoint[u] = true;

				// (2) If u is not root and low value of one of its child is
				// more
				// than discovery value of u.
				if (parent[u] != -1 && low[v] >= discovery[u])
					articulationPoint[u] = true;
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u] = Math.min(low[u], discovery[v]);
			
		}
	}

	// The function to do DFS traversal. It uses recursive function APUtil()
	void printArticulationPoints() {
		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		int discovery[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];
		boolean articulationPoints[] = new boolean[V]; // To store articulation points

		// Initialize parent and visited, and ap(articulation point) arrays
		for (int i = 0; i < V; i++) {
			parent[i] = -1;
			visited[i] = false;
			articulationPoints[i] = false;
		}

		// Call the recursive helper function to find articulation points
		// in DFS tree rooted with vertex 'i'
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				aputil(i, visited, discovery, low, parent, articulationPoints);

		// Now ap[] contains articulation points, print them
		for (int i = 0; i < V; i++)
			if (articulationPoints[i] == true)
				System.out.println(i + " ");
	}

	// Driver program to test above function
	public static void main(String args[]) {
		// Create graphs given in above diagrams
		System.out.println("\nArticulation points in first graph \n");
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.printArticulationPoints();

		System.out.println("\nArticulation points in second graph \n");
		Graph g2 = new Graph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		g2.printArticulationPoints();

		System.out.println("\nArticulation points in third graph \n");
		Graph g3 = new Graph(7);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		g3.addEdge(4, 5);
		g3.printArticulationPoints();

	}
}