package geek.examples;

public class TrianglesInAUndirectedGraph {

	// Utility function for matrix multiplication
	static int[][] multiply(int a[][], int b[][]) {
		int C[][] = new int[a[0].length][b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				C[i][j] = 0;
				for (int k = 0; k < a.length; k++) {
					C[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return C;
	}

	static int getTrace(int graph[][]) {
		int trace = 0;
		for (int i = 0; i < graph.length; i++)
			trace += graph[i][i];
		return trace;
	}

	// Utility function for calculating number of triangles in graph
	static int triangleInGraph(int graph[][]) {
		int[][] aux2 = multiply(graph, graph);

		int[][] aux3 = multiply(graph, aux2);

		int trace = getTrace(aux3);
		return trace / 6;
	}

	// driver program to test above function
	public static void main(String args[]) {
		/* Let us create the example graph discussed above */
		int graph[][] = { { 0, 1, 1, 0 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 0 } };

		System.out.println("Total number of Triangle in Graph :" + triangleInGraph(graph));
	}
}
