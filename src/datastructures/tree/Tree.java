package datastructures.tree;

public class Tree {
	class Node {
		Node left;
		Node right;
		int val;

		Node(int val) {
			this.val = val;
		}

	}

	int tab = 0;

	public static void main(String[] args) {
		new Tree().testTransform();
	}

	public void testTransform() {
		Node n11 = new Node(11);
		Node n35 = new Node(35);
		Node n40 = new Node(40);
		Node n15 = new Node(15);
		Node n29 = new Node(29);
		Node n7 = new Node(7);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		n11.left = n2;
		n11.right = n29;
		n2.left = n1;
		n2.right = n7;
		n29.left = n15;
		n29.right = n40;
		n40.left = n35;
		inOrder(n11);
		transform(n11, 0);
		inOrder(n11);

	}

	public void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.val);
		inOrder(node.right);
	}

	public int transform(Node node, int sum) {
		if(node==null){
			return 0;
		}
		print(++tab);
		System.out.println("transform({"+node.val+"},"+sum+")");
		int val = node.val;
		int sumR = transform(node.right, sum);
		node.val = sum + sumR;
		int sumL = transform(node.left, node.val+val);
		print(--tab);
		return sumL + sumR + val;
	}

	private void print(int tab) {
		for (int i = 0; i <= tab; i++) {
			System.out.print("->");
		}
	}
}
