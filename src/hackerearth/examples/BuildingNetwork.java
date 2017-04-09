package hackerearth.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BuildingNetwork {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int routers = in.nextInt();
			int routerSlots[] = new int[routers];
			for (int r = 0; r < routers; r++) {
				routerSlots[r] = in.nextInt();
			}
			Edge[] edges = new Edge[(routers * (routers - 1)) / 2];
			int e = 0;
			for (int i = 0; i < routers; i++) {
				for (int j = i + 1; j < routers; j++) {
					edges[e] = new Edge(i, j, routerSlots[i] + routerSlots[j]);
					e++;
				}
			}
			Arrays.sort(edges, new EdgeComparator());
			DisjointSet set = new DisjointSet(routers);
			int ed = 0;
			int i = 0;
			long minSum = 0;
			while (ed <routers - 1) {
				Edge nextEdge = edges[i];
				if (!set.isConnected(nextEdge.u, nextEdge.v)) {
					set.union(nextEdge.u, nextEdge.v);
					minSum += nextEdge.w;
					ed++;
				}
				i++;
			}
			System.out.println(minSum);
		}
	}

	static class DisjointSet {
		public int[] parent;
		public int[] rank;

		public DisjointSet(int n) {
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

	static class EdgeComparator implements Comparator<Edge> {

		
		public int compare(Edge edge1, Edge edge2) {
			if (edge1.w < edge2.w) {
				return -1;
			}
			return 1;
		}

	}

	static class Edge {
		int u;

		public Edge(int u, int v, long w) {
			super();
			this.u = u;
			this.v = v;
			this.w = w;
		}

		int v;
		long w;
	}
}
