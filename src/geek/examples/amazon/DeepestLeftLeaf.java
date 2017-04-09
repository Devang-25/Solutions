/**
 * 
 */
package geek.examples.amazon;

/**
 * @author makkg
 *
 */
public class DeepestLeftLeaf {
	public static void main(String[] args) {

		Node four = new Node(null, null, 4);

		Node nine = new Node(null, null, 9);
		Node seven = new Node(nine, null, 7);
		Node ten = new Node(null, null, 10);
		Node eight = new Node(null, ten, 8);
		Node six = new Node(null, eight, 7);
		Node five = new Node(null, seven, 5);
		Node three = new Node(five, six, 3);
		Node two = new Node(four, null, 2);
		Node root = new Node(two, three, 1);

		DeepestLeftLeaf algo = new DeepestLeftLeaf();
		algo.processDeepestLeftNode(root, 0);
		System.out.println(algo.val);
	}

	private int maxLevel = -1;
	private int val = -1;

	/**
	 * @param root
	 * @return
	 */
	private boolean processDeepestLeftNode(Node root, int level) {
		if (root.left == null && root.right == null) {
			return true;
		}
		if (root.left != null) {
			if (processDeepestLeftNode(root.left, level + 1)) {
				if (level + 1 > maxLevel) {
					maxLevel = level + 1;
					val = root.left.val;
				}
			}
		}
		if (root.right != null) {
			processDeepestLeftNode(root.right, level + 1);
			return false;
		}
		return false;
	}

	static class Node {
		Node left;
		Node right;
		int val;

		/**
		 * @param left
		 * @param right
		 * @param val
		 */
		public Node(Node left, Node right, int val) {
			super();
			this.left = left;
			this.right = right;
			this.val = val;
		}

	}
}
