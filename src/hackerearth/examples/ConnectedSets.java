package hackerearth.examples;

import java.util.LinkedList;
import java.util.Scanner;

public class ConnectedSets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int N = in.nextInt();
			LinkedList<Node> nodes = new LinkedList<Node>();
			Node nodeArray[][] = new Node[N][N];
			for (int m = 0; m < N; m++) {
				for (int n = 0; n < N; n++) {
					int val = in.nextInt();
					if (val == 1) {
						Node nd = new Node();
						nd.x = m;
						nd.y = n;
						nodeArray[m][n] = nd;
						nodes.add(nodeArray[m][n]);
					}
				}
			}
			int count = connectedComponents(nodeArray, nodes, N);
			System.out.println(count);
		}

	}

	private static int connectedComponents(Node[][] node,
			LinkedList<Node> nodes, int size) {
		int count = 0;
		for (Node n : nodes) {
			if (!n.isVisited) {
				count++;
				process(node, n.x, n.y);
			}
		}
		return count;
	}

	private static void process(Node[][] array, int x, int y) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (x + i >= 0 && x + i < array.length && y + j >= 0
						&& y + j < array.length && array[x +i][y + j] != null && !array[x+i][y+j].isVisited) {
					array[x + i][y + j].isVisited=true;
					process(array, x+i, y+j);
				}
			}
		}
	}
}

class Node {
	boolean isVisited = false;
	int x;
	int y;
}
