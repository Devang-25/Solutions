package hackerearth.examples;
//based on assumption that the given linkedlist is the only example.
public class LinkedListABrearrange {

	static class Node {
		String val;
		Node next;
	}

	public static void main(String args[]) {
		String vals[] = { "a1", "a2", "a3", "a4", "a5","a6","a7","b1", "b2", "b3", "b4","b5","b6"};
		Node start = new Node();
		Node temp = start;
		for (int i = 0; i < vals.length; i++) {
			Node n = new Node();
			n.val = vals[i];
			temp.next = n;
			temp = temp.next;
		}
		display(start);
		System.out.println();
		rearrangeAB(start);
	}

	public static void rearrangeAB(Node start) {
		Node temp = start.next;
		Node bStart = null;
		Node prev=null;
		while (temp != null) {
			if (temp.val.startsWith("b")) {
				bStart = temp;
				break;
			}
			prev=temp;
			temp = temp.next;
		}
		prev.next=null;
		System.out.println();
		if (temp != null) {
			Node one = start.next;
			Node two = bStart;
			while (one != null) {
				Node y=one.next;
				one.next = two;
				one = y;
				Node t = two;
				two = one;
				one = t;
			}
		}
		display(start);
	}

	public static void display(Node start) {
		Node t = start.next;
		while (t != null) {
			System.out.print(t.val + "\t");
			t = t.next;
		}
	}

}
