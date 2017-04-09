package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class RustAndMurderer {
	private static boolean disc[];
	private static int distance[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int nodes = in.nextInt() + 1;
			disc = new boolean[nodes];
			distance = new int[nodes];
			ArrayList<TreeSet<Integer>> graph = new ArrayList<TreeSet<Integer>>(
					nodes);
			for (int i = 0; i < nodes; i++) {
				graph.add(new TreeSet<Integer>());
			}
			for (int i = 1; i < nodes; i++) {
				for (int j = i + 1; j < nodes; j++) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
			int M = in.nextInt();
			for (int e = 1; e <= M; e++) {
				int a = in.nextInt();
				int b = in.nextInt();
				graph.get(a).remove(b);
				graph.get(b).remove(a);
			}
			int s = in.nextInt();
			//System.out.println(graph);
			// this is the graph of the village roads.
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(s);
			disc[s] = true;
			q.add(-1);
			int i = 0;
			boolean end = false;
			while (!q.isEmpty()) {
				int node = q.remove();
				//System.out.println(node);
				if (node == -1) {
					if (end) {
						break;
					}
					end = true;
					i++;
					q.add(-1);
				} else {
					end = false;
					distance[node] = i;
					for (int n : graph.get(node)) {
						if (!disc[n]) {
							disc[n] = true;
							q.add(n);
						}
					}
				}

			}
			for (int j = 1; j < nodes; j++) {
				if (j != s) {
					System.out.print(distance[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
