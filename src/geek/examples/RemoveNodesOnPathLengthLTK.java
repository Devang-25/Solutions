package geek.examples;

public class RemoveNodesOnPathLengthLTK {
	public static void main(String[] args) {
		Node root = null;
		Node[] n=new Node[12];
		for(int i=0;i<n.length;i++){
			n[i]=new Node(i);
		}
		n[1].left=n[2];
		n[1].right=n[3];
		n[2].right=n[4];
		n[3].right=n[5];
		n[4].right=n[6];
		n[5].left=n[7];
		n[6].left=n[8];
		n[8].left=n[9];
		n[8].right=n[10];
		n[10].right=n[11];
		int k = 4;
		pruneTree(root, k);
	}

	private static boolean pruneTree(Node root, int k) {
		if (k == 0) {
			return true;
		}
		if (root == null) {
			return false;
		}
		if (root.left != null && !pruneTree(root.left, k - 1)) {
			root.left = null;
		}
		if (root.right != null && !pruneTree(root.right, k - 1)) {
			root.right = null;
		}
		if (root.left == null && root.right == null) {
			return false;
		}
		return true;
	}

	static class Node {
		public Node(int i) {
			this.val=i;
		}
		Node left;
		Node right;
		int val;
	}
}
