package hackerearth.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MakePath {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfBases = in.nextInt();
		System.out.println(noOfBases);
		Base bases[] = new Base[noOfBases];
		for (int i = 0; i < noOfBases; i++) {
			Base b = new Base();
			b.id = i;
			b.x = in.nextInt();
			b.y = in.nextInt();
			bases[i] = b;
		}
		Arrays.sort(bases, new XComparator());
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (int i = 0; i < bases.length - 1; i++) {
			edges.add(new Edge(bases[i], bases[i + 1]));
		}

		Arrays.sort(bases, new YComparator());

		for (int i = 0; i < bases.length - 1; i++) {
			edges.add(new Edge(bases[i], bases[i + 1]));
		}

		Collections.sort(edges,new EdgeComparator() );
		int parentTable[] = new int[bases.length];
		for (int i = 0; i < parentTable.length; i++) {
			parentTable[i] = -1;
		}
		int totalCost = 0;
		for (Edge e : edges) {
			int a = belongsTo(parentTable, e.s.id);
			int b = belongsTo(parentTable, e.e.id);
			if (a != b) {
				totalCost += e.cost;
				parentTable[a] = b;
			}
		}
		System.out.println(totalCost);
	}

	static int belongsTo(int parentTable[], int x) {
		if (parentTable[x] == -1) {
			return x;
		}
		return belongsTo(parentTable, parentTable[x]);
	}

	static class EdgeComparator implements Comparator<Edge> {

		public int compare(Edge e1, Edge e2) {
			if (e1.cost < e2.cost) {
				return -1;
			}
			return 1;
		}
	}

	static class Base {
		int id;
		int x;
		int y;

	}

	static class XComparator implements Comparator<Base> {
		
		public int compare(Base b1, Base b2) {
			if (b1.x < b2.x) {
				return -1;
			}
			return 1;
		}
	}

	static class YComparator implements Comparator<Base> {
		
		public int compare(Base b1, Base b2) {
			if (b1.y < b2.y) {
				return -1;
			}
			return 1;
		}
	}

	static class Edge {
		Base s;
		Base e;
		int cost;

		Edge(Base s, Base e) {
			this.s = s;
			this.e = e;
			this.cost = Math.min(Math.abs(s.x - e.x), Math.abs(s.y - e.y));
		}
	}
}
