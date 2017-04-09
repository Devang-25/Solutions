package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SwapNodes {

	private static List<LinkedList<Node>> heightNodes = new ArrayList<LinkedList<Node>>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node root = new Node(1);
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		heightNodes.add(new LinkedList<Node>());
		int h = 0;
		for (int i = 1; i <= n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			Node thisNode = q.removeFirst();
			if (thisNode == null) {
				h++;
				heightNodes.add(new LinkedList<Node>());
				thisNode = q.removeFirst();
				q.addLast(null);
			}
			heightNodes.get(h).add(thisNode);
			if (a != -1) {
				thisNode.left = new Node(a);
				q.addLast(thisNode.left);
			}
			if (b != -1) {
				thisNode.right = new Node(b);
				q.addLast(thisNode.right);
			}

		}
		//System.out.println(heightNodes);
		int kz = in.nextInt();
		for (int i = 1; i <= kz; i++) {
			final int k = in.nextInt();
			int f = 1;
			int d = f * k - 1;
			while (d<heightNodes.size()) {
				for (Node node : heightNodes.get(d)) {
					swap(node);
				}
				f++;
				d = f * k - 1;
			}
			inorder(root);
			System.out.println();
		}
	}

	private static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.val+" ");
		inorder(root.right);
	}

	private static void swap(Node node) {
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	static class Node {
		int val;
		Node left;
		Node right;

		Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return this.val + "";
		}
	}
}
