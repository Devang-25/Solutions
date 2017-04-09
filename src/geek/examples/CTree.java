package geek.examples;

class CTree {
	class Node {
		int val;
		Node left;
		Node right;
	}

	private int size = 100;
	private Node root;
	private Node smallest;
	private Node parentOfSmallest = null;
	int count = 0;

	CTree() {
		root = new Node();
		root.val = Integer.MAX_VALUE;
		smallest = this.root;
		System.out.println(smallest);
	}

	public void insert(int val) {
		if (this.smallest.val == val) {
			System.out.println("Duplicate");
			return;
		}
		if (this.smallest.val > val) {
			if (count != this.size) {
				System.out.println("space there.." + this.smallest.val);
				Node temp = new Node();
				temp.val = val;
				this.smallest.left = temp;
				this.parentOfSmallest = this.smallest;
				this.smallest = smallest.left;
				count++;
			} else {
				System.out.println("Ignored.");
			}
			return;
		} else {
			// let there be normal insertion.
			boolean wasInserted = insertVal(val);
			if (wasInserted) {
				// the smallest will have to go.
				if (count == this.size) {
					System.out.println("deleting smallest" + smallest.val);
					System.out.println(this.parentOfSmallest.val);
					if (this.smallest.right == null) {
						Node temp = this.root;
						while (temp.left != this.parentOfSmallest) {
							temp = temp.left;
						}
						System.out.println(temp.val);
						this.smallest = this.parentOfSmallest;
						this.parentOfSmallest = temp;
					} else {
						System.out.println("fixing");
						this.parentOfSmallest.left = smallest.right;
						// it will not simply be the left but the leftmost of
						// the left.
						smallest = this.parentOfSmallest.left;
						while (smallest.left != null) {
							this.parentOfSmallest = smallest;
							smallest = smallest.left;
						}
						// smallest=this.parentOfSmallest.left;
					}

				} else {
					count++;
				}
			} else {
				System.out.println("Duplicate:match");
			}

		}
	}

	private boolean insertVal(int val) {
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
				// it was a match.
				return false;
			}
		}
		Node child = new Node();
		child.val = val;
		if (val > parent.val) {
			parent.right = child;
		} else {
			parent.left = child;
		}
		return true;
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
	
	

	public static void main(String args[]) {
		int arr[] = { 10, 12, 34, 2, 89, 67, 56, 90, 78, 39, 10, 59, 23, 76,
				12, 77, 44, 11 };
		long t=System.currentTimeMillis();
		CTree tree = new CTree();
		int times=1000000;
		for (int i = 0; i < times; i++) {
			int no=(int)(Math.random()*100000000);
			System.out.println("Inserting " +no );
			tree.insert(no);
		}
		tree.inOrder();
		System.out.println();
		System.out.println(System.currentTimeMillis()-t+" ms.");
	}
}
