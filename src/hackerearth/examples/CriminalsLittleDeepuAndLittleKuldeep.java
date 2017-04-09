package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;

public class CriminalsLittleDeepuAndLittleKuldeep {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int boxCount = in.nextInt();
			Integer boxes[] = new Integer[boxCount];
			for (int i = 0; i < boxCount; i++) {
				boxes[i] = in.nextInt();
			}
			Arrays.sort(boxes);
			Node sentinel = new Node(-1);
			Node cur = sentinel;
			for (int val : boxes) {
				Node n = new Node(val);
				cur.next = n;
				cur = n;
			}
			//display(sentinel);
			int count = 0;
			while (sentinel.next != null) {
				Node prev = sentinel;
				Node temp = sentinel.next;
				Node jumper = sentinel;
				while (temp != null) {
					if (temp.val == prev.val) {
						jumper.next = temp;
						jumper=temp;
						//System.out.println("Jumper goes to "+ temp.val);
					}
					prev = temp;
					temp = temp.next;
				}
				jumper.next=null;
				//display(sentinel);
				count++;
			}
			System.out.println(count);
		}

	}

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			super();
			this.val = val;
		}
	}

	static void display(Node sentinel) {
		Node cu = sentinel;
		while (cu != null) {
			System.out.print(cu.val + " ");
			cu = cu.next;
		}
		System.out.println();
	}
}
