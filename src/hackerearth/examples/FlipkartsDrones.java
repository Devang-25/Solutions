package hackerearth.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class FlipkartsDrones {
	private static int clusterId[] = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = (int)(Math.random()*200);//in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n =(int)(Math.random()*200);// in.nextInt();
			int m = (int)(Math.random()*300);//in.nextInt();
			Graph g = new Graph(n);
			clusterId = new int[n];
			for (int i = 1; i <= m; i++) {
				int x = (int)(Math.random()*n);//in.nextInt();
				int y = (int)(Math.random()*n);//in.nextInt();
				g.addEdge(x, y);
			}
			processConnectedComponents(g);
			int queries = 10000;//in.nextInt();
			for (int q = 1; q <= queries; q++) {
				int x = (int)(Math.random()*n);//in.nextInt();
				int y = (int)(Math.random()*n);//in.nextInt();
				if (clusterId[x] == clusterId[y]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void processConnectedComponents(Graph graph) {
		int n = graph.vertices.size();
		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				clusterId[i] = i;
				Stack<Integer> stack = new Stack<Integer>();
				stack.add(i);
				while (!stack.isEmpty()) {
					int u = stack.pop();
					visited[u] = true;
					for (int v = graph.vertices.get(u).size() - 1; v >= 0; v--) {
						int p = graph.vertices.get(u).get(v);
						if (!visited[p]) {
							clusterId[p] = i;
							stack.add(p);
						}
					}
				}
			}
		}
	}

	static class Graph {
		List<List<Integer>> vertices = null;

		Graph(int vertices) {
			this.vertices = new ArrayList<List<Integer>>(vertices);
			for (int i = 0; i < vertices; i++) {
				this.vertices.add(new LinkedList<Integer>());
			}
		}

		public void addEdge(int x, int y) {
			this.vertices.get(x).add(y);
			this.vertices.get(y).add(x);
		}
	}
}
