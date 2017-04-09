package hackerearth.examples.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class UnitedWeStand {
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		PrintWriter writer = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		String NM[] = input.readLine().split(" ");
		int noOfIslands = toInt(NM[0]);
		int noOfRoads = toInt(NM[1]);
		Road roads[] = new Road[noOfRoads];
		// we just collect the edges.
		for (int e = 0; e < noOfRoads; e++) {
			String uv[] = input.readLine().split(" ");
			roads[e] = new Road(toInt(uv[0]) - 1, toInt(uv[1]) - 1);
		}

		int k = Integer.parseInt(input.readLine());
		Road bombs[] = new Road[k];
		String bombsC[] = new String[k];
		Graph graph = new Graph(noOfIslands);
		for (int i = 0; i < k; i++) {
			String uv[] = input.readLine().split(" ");
			int u = toInt(uv[0]) - 1;
			int v = toInt(uv[1]) - 1;
			bombs[i] = new Road(u, v);
			bombsC[i] = u + " " + v;
		}

		Arrays.sort(bombsC);
		Cluster set = new Cluster(noOfIslands);
		// we create the graph, but we don't include the bomb edges.
		for (Road e : roads) {
			if (Arrays.binarySearch(bombsC, e.u + " " + e.v) < 0) {
				graph.addEdge(e);
				set.union(e.u, e.v);
			}
		}
		int clusters = getConnectedComponents(graph);
		int out[] = new int[k];
		out[k - 1] = clusters;
		for (int i = k - 1; i > 0; i--) {
			if (!set.isConnected(bombs[i].u, bombs[i].v)) {
				set.union(bombs[i].u, bombs[i].v);
				clusters--;
			}
			out[i - 1] = clusters;
		}
		for (int i = 0; i < k - 1; i++)
			writer.print(out[i] + "\n");
		writer.println(out[k - 1]);
		writer.flush();
	}

	private static int toInt(String string) {
		return Integer.parseInt(string);
	}

	private static int getConnectedComponents(Graph graph) {
		int n = graph.vertices.size();
		boolean visited[] = new boolean[n];
		
		int components = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				Stack<Integer> stack = new Stack<Integer>();
				stack.add(i);
				while (!stack.isEmpty()) {
					int u = stack.pop();
					visited[u] = true;
					for (int v = graph.vertices.get(u).size() - 1; v >= 0; v--) {
						int p = graph.vertices.get(u).get(v);
						if (!visited[p]) {
							stack.add(p);
						}
					}
				}
				components++;
			}
		}
		return components;
	}

	static class Cluster {
		public int[] parent;
		public int[] rank;

		public Cluster(int n) {
			parent = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; ++i) {
				makeSet(i);
			}
		}

		public void makeSet(int x) {
			parent[x] = x;
			rank[x] = 0;
		}

		public int find(int x) {
			if (x != parent[x])
				parent[x] = find(parent[x]);
			return parent[x];
		}

		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}

		public void union(int x, int y) {
			int px = find(x);
			int py = find(y);
			if (rank[px] > rank[py])
				parent[py] = px;
			else
				parent[px] = py;
			if (rank[px] == rank[py])
				rank[py]++;
		}
	}

	static class Graph {
		List<List<Integer>> vertices = null;

		Graph(int vertices) {
			this.vertices = new ArrayList<List<Integer>>(vertices);
			for (int i = 0; i < vertices; i++) {
				this.vertices.add(new ArrayList<Integer>());
			}
		}

		public void addEdge(Road e) {
			this.vertices.get(e.u).add(e.v);
			this.vertices.get(e.v).add(e.u);
		}
	}

	static class Road {
		int u;
		int v;

		Road(int u, int v) {
			if (u < v) {
				this.u = u;
				this.v = v;
			} else {
				this.v = u;
				this.u = v;
			}
		}

	}
}
