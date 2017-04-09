package geek.examples;

import java.util.LinkedList;

public class RootNodeChainingDemo {
	public static void main(String[] args) {
		Node root = new Node(14);
		Node rl = new Node(6);
		Node rr = new Node(18);
		Node rlr = new Node(11);
		Node rll = new Node(3);
		Node rrl = new Node(15);
		Node rrlr = new Node(17);
		root.left = rl;
		root.right = rr;
		rl.left = rll;
		rl.right = rlr;
		rr.left = rrl;
		rrl.right = rrlr;
		updateNextPointers(root);
		display(rl);
		display(rll);
		
	}

	private static void display(Node node) {
		System.out.println();
		if(node==null){
			return ;
		}
		while(node!=null){
			System.out.print(node.value+"\t");
			node=node.nextInLevel;
		}
		
	}

	private static void updateNextPointers(Node root) {
		System.out.println("Updating");
		LinkedList<Node> levelQueue = new LinkedList<Node>();
		levelQueue.add(root);
		levelQueue.add(null);
		boolean isPrevNodeInQNull = false;
		while (!levelQueue.isEmpty()) {
			Node thisNode = levelQueue.removeFirst();
			if (thisNode == null) {
				if (isPrevNodeInQNull) {
					break;
				} else {
					isPrevNodeInQNull = true;
					levelQueue.add(null);
				}
			} else {
				thisNode.nextInLevel = levelQueue.element();
				if (thisNode.left != null) {
					levelQueue.add(thisNode.left);
				}
				if (thisNode.right != null) {
					levelQueue.add(thisNode.right);
				}
				isPrevNodeInQNull=false;
			}

		}
	}

	static class Node {
		int value;
		Node left;
		Node right;
		Node nextInLevel;

		Node(int val) {
			this.value = val;
		}
	}
}
