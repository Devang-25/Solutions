package hackerearth.examples;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class RajatAndClasses {

	private static int maxEdges = Integer.MIN_VALUE;
	private static int maxEdgeId = 0;
	private static SortedSet<Integer> set = new TreeSet<Integer>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int verticeCount = in.nextInt();
		int edges = in.nextInt();
		Vertex[] vertices = new Vertex[verticeCount + 1];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex();
			vertices[i].id = i;
		}
		for (int i = 1; i <= edges; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			vertices[a].edges.add(vertices[b]);
			vertices[b].edges.add(vertices[a]);
		}
		// we have our graph ready.
		// finding the connected components.
		for (int i = 1; i < vertices.length; i++) {
			Vertex thisV = vertices[i];
			if (!thisV.isVisited) {
				dfs(thisV);
				System.out.println(maxEdgeId + " with " + maxEdges);
				set.add(maxEdgeId);
				maxEdgeId = 0;
				maxEdges = Integer.MIN_VALUE;
			}
		}
		System.out.println(set.size());
		for (Integer i : set) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void dfs(Vertex v) {
		if (!v.isVisited) {
			System.out.println("at@ :" + v.id + " e:" + v.edges.size());
			v.isVisited = true;
			if (v.edges.size() > maxEdges) {
				maxEdges = v.edges.size();
				maxEdgeId = v.id;
			}
			if (v.edges.size() == maxEdges) {
				if (v.id < maxEdgeId) {
					maxEdgeId = v.id;
				}
			}
			for (Vertex thisV : v.edges) {
				if (!thisV.isVisited) {
					dfs(thisV);
				}
			}
		}
	}

	static class Vertex {
		boolean isVisited = false;
		int id = 0;
		List<Vertex> edges = new LinkedList<Vertex>();
	}
}
