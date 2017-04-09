package geek.examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
	class Node {
		int val;
		Node left;
		Node right;
	}

	private Node root = new Node();

	public void insert(int val) {
		if (this.root.left == null) {
			this.root.left = new Node();
			this.root.left.val = val;
			return;
		}
		Node temp = root.left;
		Node parent = root;
		while (temp != null) {
			if (temp.val < val) {
				parent = temp;
				temp = temp.right;
			} else if (temp.val > val) {
				parent = temp;
				temp = temp.left;
			} else {
				return;
			}
		}
		Node child = new Node();
		child.val = val;
		if (val > parent.val) {
			parent.right = child;
		} else {
			parent.left = child;
		}
		return;
	}

	private Node[] search(int val) {
		if (this.root.left == null) {
			return null;
		}
		Node temp = root.left;
		Node parent = root;
		while (temp != null) {
			if (temp.val < val) {
				parent = temp;
				temp = temp.right;
			} else if (temp.val > val) {
				parent = temp;
				temp = temp.left;
			} else {
				System.out.println("found match");
				return new Node[] { parent, temp };
			}
		}
		return null;
	}

	public void delete(int val) {
		Node parentChildPair[] = search(val);
		if (parentChildPair == null) {
			return;
		}
		Node child = parentChildPair[1];
		Node parent = parentChildPair[0];
		if (child.left == null && child.right == null) {
			if (child == parent.left) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (child.left == null && child.right != null) {
			if (child == parent.left) {
				parent.left = child.right;
			} else {
				parent.right = child.right;
			}
		} else if (child.left != null && child.right == null) {
			if (child == parent.left) {
				parent.left = child.left;
			} else {
				parent.right = child.left;
			}
		} else {
			Node parentSuccessorPair[] = getSuccessor(child.right, child);
			Node successor = parentSuccessorPair[1];
			int temp = successor.val;
			successor.val = child.val;
			child.val = temp;
			child = successor;
			Node par = parentSuccessorPair[0];
			if (child == par.left) {
				par.left = null;
			} else {
				par.right = null;
			}
		}

	}

	private Node[] getSuccessor(Node right, Node parent) {
		Node child = right;
		Node par = parent;
		while (child.left != null) {
			child = child.left;
		}
		return new Node[] { par, child };
	}

	public void preOrder() {
		preOrder(this.root.left);
	}

	public void inOrder() {
		inOrder(root.left);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.val + "\t");
		inOrder(node.right);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.val + "\t");
		preOrder(node.left);
		preOrder(node.right);
	}

	private void preOrderStack() {
		Stack<Node> stack = new Stack<>();
		stack.push(this.root.left);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			while (current != null) {
				System.out.print(current.val + "\t");
				if (current.right != null) {
					stack.push(current.right);
				}
				current = current.left;
			}
		}
	}

	private void inOrderStack() {
		Stack<Node> stack = new Stack<>();
		Node cur = this.root.left;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		while (!stack.isEmpty()) {
			cur = stack.pop();
			System.out.print(cur.val + "\t");
			if (cur.right != null) {
				cur = cur.right;
				while (cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
			}

		}
	}

	public void postOrder() {
		postOrder(this.root.left);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.val + "\t");
	}

	// O(n)
	public void displayLeftView() {
		Node cur = this.root.left;
		Queue<Node> queue = new LinkedList<>();
		queue.add(cur);
		final Node NULL = new Node();
		queue.add(NULL);
		System.out.print(cur.val + "\t");
		boolean nullEncountered = false;
		while (!queue.isEmpty()) {
			cur = queue.remove();
			if (cur == NULL) {
				if (nullEncountered) {
					break;
				}
				nullEncountered = true;
				queue.add(NULL);
				continue;
			}
			if (nullEncountered) {
				nullEncountered = false;
				System.out.print(cur.val + "\t");
			}
			if (cur.left != null) {
				// System.out.println("added " + cur.left.val);
				queue.add(cur.left);
			}
			if (cur.right != null) {
				// System.out.println("added " + cur.right.val);
				queue.add(cur.right);
			}

		}
	}


	class LeafInfo {
		int level;
		Node leaf;
	}

	// O(n)
	private LeafInfo deepestLeaf(Node node, int level) {
		System.out.println("N(" + node.val + "," + level + ")");
		if (node.left == null && node.right == null) {
			LeafInfo temp = new LeafInfo();
			temp.leaf = node;
			temp.level = level;
			return temp;
		}
		LeafInfo left = null;
		if (node.left != null) {
			left = deepestLeaf(node.left, level + 1);
		}
		LeafInfo right = null;
		if (node.right != null) {
			right = deepestLeaf(node.right, level + 1);
		}
		if (left == null && right != null) {
			return right;
		} else if (right == null && left != null) {
			return left;
		} else {
			if (right.level > left.level) {
				return right;
			}
			return left;
		}

	}

	public int getDeepestLeaf() {
		LeafInfo temp = this.deepestLeaf(this.root.left, 0);
		return temp.leaf.val;
	}

	private  Node ancestor(Node node, int v1, int v2) {
		if (node == null) {
			return null;
		}
		if (node.val == v1 || node.val == v2) {
			return node;
		}

		Node left = ancestor(node.left, v1, v2);
		Node right = ancestor(node.right, v1, v2);
		if (left != null && right != null) {
			return node;
		}
		if (left != null) {
			return left;
		}
		return right;
	}
	
	public void printAncestor(int v1, int v2){
		Node ancestor=this.ancestor(this.root.left, v1, v2);
		System.out.println(ancestor.val);
	}

	public static void main(String args[]) {
		Tree t = new Tree();
		int arr[] = { 19, 7, 16, 32, 14, 2, 9, 12, 18, 21,
				45, 1,87, 34, 30 };
		for (int a : arr) {
			t.insert(a);
		}

		// t.inOrder();
		// System.out.println();
		// t.preOrder();
		// System.out.println();
		// t.preOrderStack();
		// System.out.println();
		// t.inOrderStack();
		System.out.println();
		t.postOrder();
		System.out.println();
		
		t.displayLeftView();
		System.out.println(t.getDeepestLeaf());
		System.out.println();
		t.printAncestor(1,16);
	}

}
