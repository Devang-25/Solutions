package geek.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StrongConnectivityInDirectedGraph {
	static class Graph {
		int V; // No. of vertices
		List<List<Integer>> adjacency; // A dynamic array of adjacency lists

		public Graph(int V) {
			this.V = V;
			adjacency = new ArrayList<List<Integer>>();
			for (int i = 0; i < V; i++) {
				adjacency.add(new LinkedList<Integer>());
			}
		}

		void addEdge(int v, int w) {
			adjacency.get(v).add(w);
			//adjacency.get(w).add(v);// Note: the graph is undirected
		}
		
		// A recursive function to print DFS starting from v
		void DFSUtil(int v, boolean visited[])
		{
		    // Mark the current node as visited and print it
		    visited[v] = true;
		 
		    // Recur for all the vertices adjacent to this vertex
		    Iterator<Integer>i=adjacency.get(v).iterator();
		    while (i.hasNext()){
		    	int temp=i.next();
		        if (!visited[temp])
		            DFSUtil(temp, visited);
		    }
		}
		 
		// Function that returns reverse (or transpose) of this graph
		Graph getTranspose()
		{
		    Graph g=new Graph(V);
		    for (int v = 0; v < V; v++)
		    {
		        // Recur for all the vertices adjacent to this vertex
		        Iterator<Integer> i=this.adjacency.get(v).iterator();
		        while(i.hasNext())
		        {int temp=i.next();
		            g.adjacency.get(temp).add(v);
		        }
		    }
		    return g;
		}
		 
		 
		// The main function that returns true if graph is strongly connected
		boolean  isSC()
		{
		    // St1p 1: Mark all the vertices as not visited (For first DFS)
		    boolean  visited[]=new boolean[V];
		    for (int i = 0; i < V; i++)
		        visited[i] = false;
		 
		    // Step 2: Do DFS traversal starting from first vertex.
		    DFSUtil(0, visited);
		 
		     // If DFS traversal doesn’t visit all vertices, then return false.
		    for (int i = 0; i < V; i++)
		        if (visited[i] == false)
		             return false;
		 
		    // Step 3: Create a reversed graph
		    Graph gr = getTranspose();
		 
		    // Step 4: Mark all the vertices as not visited (For second DFS)
		    for(int i = 0; i < V; i++)
		        visited[i] = false;
		 
		    // Step 5: Do DFS for reversed graph starting from first vertex.
		    // Staring Vertex must be same starting point of first DFS
		    gr.DFSUtil(0, visited);
		 
		    // If all vertices are not visited in second DFS, then
		    // return false
		    for (int i = 0; i < V; i++)
		        if (visited[i] == false)
		             return false;
		 
		    return true;
		}
		 
		// Driver program to test above functions
		public static void main(String args[])
		{
		    // Create graphs given in the above diagrams
		    Graph g1=new Graph(5);
		    g1.addEdge(0, 1);
		    g1.addEdge(1, 2);
		    g1.addEdge(2, 3);
		    g1.addEdge(3, 0);
		    g1.addEdge(2, 4);
		    g1.addEdge(4, 2);
		    System.out.println(g1.isSC()?"Yes\n" :"No\n");
		 
		    Graph g2=new Graph(4);
		    g2.addEdge(0, 1);
		    g2.addEdge(1, 2);
		    g2.addEdge(2, 3);
		    System.out.println(g2.isSC()?"Yes\n" :"No\n");
		}
	}
}
