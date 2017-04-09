package hackerearth.examples.Strings;

import java.util.Scanner;

public class XorInTree {
	static Node[] nodes = null;
	static boolean found=false;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int c = in.nextInt();
			nodes = new Node[c];
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = new Node(i + 1, in.nextInt());
			}
			for (int i = 1; i < c; i++) {
				int a = in.nextInt()-1;
				int b = in.nextInt()-1;
				if (nodes[a].left == null) {
					nodes[a].left = nodes[b];
				} else {
					nodes[a].right = nodes[b];
				}
			}
			int queries = in.nextInt();
			for (int q = 1; q <= queries; q++) {
				found=false;
				int qCode = in.nextInt();
				if (qCode == 1) {
					// assignment
					int u = in.nextInt()-1;
					int v = in.nextInt()-1;
					nodes[v].val = nodes[u].val;
				} else {
					int u = in.nextInt();
					int v = in.nextInt();
					int sum = sumPath(u, v);
					System.out.println(sum);
				}
			}
		}
	}

	private static int sumPath(int u, int v) {
		return sumPath(nodes[0], u, v);
	}

	private static int sumPath(Node node, int u, int v) {
		if (node == null) {
			return 0;
		}
		if (node.id == u || node.id == v) {
			return node.val;
		}
		int left = sumPath(node.left, u, v);
		if(found){
			return left;
		}
		int right = sumPath(node.right, u, v);
		if(found){
			return right;
		}
		if(left!=0 && right!=0){
			found=true;
			return left+right+node.val;
		}
		if(left!=0){
			return left+node.val;
		}
		if(right!=0){
			return right+node.val;
		}
		return 0;
	}

	static class Node {
		public Node(int i, int val) {
			this.id = i;
			this.val = val;
		}

		int id;
		Node left;
		Node right;
		int val;
	}
}
