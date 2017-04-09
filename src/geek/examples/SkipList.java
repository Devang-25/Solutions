package geek.examples;

import java.util.Random;

public class SkipList {
	private Node head = null;
	private Node tail = null;
	private final Random random;
	private int height;

	public SkipList() {
		head = new Node(Integer.MIN_VALUE);
		tail = new Node(Integer.MAX_VALUE);
		random = new Random();
		// fix here...
	}

	private Node search(int key) {
		return search(this.head, key);
	}

	private Node search(Node current, int key) {
		while (current.val != Integer.MAX_VALUE && key <= current.right.key) {
			current = current.right;
		}
		if (current.down != null) {
			return search(current.down, key);
		}
		return current;
	}

	public void put(int key, int val) {

		Node keyNode = search(key);
		if (keyNode.key == key) {
			keyNode.val = val;
		}
		Node newNode = append(keyNode, key, val);
		Node up = keyNode;
		int h = 1;
		while (random.nextDouble() < 0.5) {
			up = getUp(up);
			Node newNodeUp = append(up, key, val);
			newNode.up = newNodeUp;
			newNodeUp.down = newNode;
			newNode = newNodeUp;
			h++;
		}
		if (h == height) {
			Node head = new Node(Integer.MIN_VALUE);
			Node tail = new Node(Integer.MAX_VALUE);
			head.down = this.head;
			this.head.up = head;
			// to be continued here...
		}
	}

	private Node getUp(Node keyNode) {
		while (keyNode.up == null) {
			keyNode = keyNode.left;
		}
		return keyNode.up;
	}

	private Node append(Node keyNode, int key, int val) {
		Node temp = new Node(key);
		temp.val = val;
		temp.right = keyNode.right;
		temp.left = keyNode;
		keyNode.right.left = temp;
		keyNode.right = temp;
		return temp;

	}
}

class Node {
	int key;
	int val;
	Node up;
	Node down;
	Node right;
	Node left;

	public Node(int key) {
		this.key = key;
	}
}