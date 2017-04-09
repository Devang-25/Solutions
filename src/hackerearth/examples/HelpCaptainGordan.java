package hackerearth.examples;
/*flawed...n complex*/
public class HelpCaptainGordan {
	public static void main(String[] args) {

	}

	static class ModicicationTree {
		class Node {
			Node left;

			public Node(int start, int end, int val) {
				super();
				this.start = start;
				this.end = end;
				this.val = val;
			}

			Node right;
			int start;
			int end;
			int val;
		}

		void add(Node node, int start, int end, int val) {
			if (end < node.start) {
				add(node.left, start, end, val);
			} else if (start > node.end) {
				add(node.right, start, end, val);
			} else if (!handleWrapping(node, start, end, val)) {
				if (!handleContainment(node, start, end, val)) {
					handlePartialOverlap(node, start, end, val);
				}
			}  
		}

		boolean handleWrapping(Node node, int start, int end, int val) {
			boolean wrap = false;
			if (node.start >= start && node.end <= end) {
				wrap = true;
				node.val += val;
				if (node.start > start && node.end == end) {
					add(node.left, start, node.start - 1, val);
				} else if (node.start == start && node.end < end) {
					add(node.right, node.end + 1, end, val);
				} else if (node.start > start && node.end < end) {
					add(node.left, start, node.start - 1, val);
					add(node.right, node.end + 1, end, val);
				}
			}
			return wrap;
		}

		boolean handleContainment(Node node, int start, int end, int val) {
			if (node.start < start && node.end > end) {
				// this node is to be split
				Node leftNode = new Node(node.start, start - 1, node.val);
				Node rightNode = new Node(end + 1, node.end, node.val);
				node.start = start;
				node.end = end;
				node.val += val;
				leftNode.left = node.left;
				rightNode.right = node.right;
				node.left = leftNode;
				node.right = rightNode;
				return true;
			}
			if (node.start < start && node.end == end) {
				// this node is to be split
				Node rightNode = new Node(end + 1, node.end, node.val);
				node.start = start;
				node.val += val;
				rightNode.right = node.right;
				node.right = rightNode;
				return true;
			}
			if (node.start == start && node.end > end) {
				// this node is to be split
				Node leftNode = new Node(node.start, start - 1, node.val+val);
				node.end = end;
				leftNode.left = node.left;
				node.left = leftNode;
				return true;
			}
			return false;
		}

		boolean handlePartialOverlap(Node node, int start, int end, int val) {
			if (start < node.start && end < node.end) {
				// this node is to be split
				Node leftNode = new Node(node.start, start - 1, node.val);
				node.end = end;
				node.val += val;
				leftNode.left = node.left;
				node.left = leftNode;
				add(leftNode.left, start, node.start - 1, val);
				return true;
			}
			if (start > node.start && end > node.end) {
				// this node is to be split
				Node rightNode = new Node(end + 1, node.end, node.val);
				node.start = start;
				node.val += val;
				rightNode.right = node.right;
				node.right = rightNode;
				add(rightNode.right, node.end + 1, end, val);
				return true;
			}
			return false;
		}

	}

}
