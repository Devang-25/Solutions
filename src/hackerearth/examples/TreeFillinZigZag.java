package hackerearth.examples;

import java.util.LinkedList;

public class TreeFillinZigZag {
	class Tree {
		class Node {
			int val;
			Node left, right;

			Node(int val) {
				this.val = val;
			}
		}

		private Node root;
		private Node current;
		private LinkedList<Node> insertionQ = new LinkedList<>();
		private LinkedList<Node> reversalStack = new LinkedList<>();
		private boolean leftToRight = false;
		private boolean partial = false;
		public Tree() {

		}

		public void add(int val) {
			if (this.root == null) {
				this.root = new Node(val);
				this.insertionQ.add(this.root);
				this.insertionQ.add(null);
				return;
			}
			if (current == null) {
				current = this.insertionQ.removeFirst();
				if (current == null) {
					while (!reversalStack.isEmpty()) {
						this.insertionQ.add(reversalStack.pop());
					}
					this.insertionQ.add(null);
					leftToRight = !leftToRight;
					current = this.insertionQ.removeFirst();
				}
			}
			if (leftToRight) {
				if (!partial) {
					current.left = new Node(val);
					reversalStack.push(current.left);
					partial = true;
				} else {
					current.right = new Node(val);
					reversalStack.push(current.right);
					current = null;
					partial = false;
				}
			} else {
				if (!partial) {
					current.right = new Node(val);
					reversalStack.push(current.right);
					partial = true;
				} else {
					current.left = new Node(val);
					reversalStack.push(current.left);
					current = null;
					partial = false;
				}
			}

		}
	}
}
