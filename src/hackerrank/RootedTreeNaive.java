package hackerrank;

import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RootedTreeNaive {
	private static Node[] nodes;

	public static void main(String[] args) {
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		PrintStream o = new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(o);
		int n = in.nextInt();
		int e = in.nextInt();
		int r = in.nextInt();
		nodes = new Node[n + 1];
		for (int i = 1; i <= n; i++) {
			nodes[i] = new Node(i);
		}
		for (int i = 1; i <= n - 1; i++) {
			//
			int a = in.nextInt();
			int b = in.nextInt();
			nodes[b].parent = nodes[a];
			nodes[b].height = nodes[a].height + 1;
			nodes[a].children.add(nodes[b]);
		}
		
		for (int op = 1; op <= e; op++) {
			//System.out.println("Operation : "+op);
			char code = in.next().toCharArray()[0];
			if (code == 'U') {
				int T = in.nextInt();
				int V = in.nextInt();
				int K = in.nextInt();
				Node node = nodes[T];
				int d = 0;
				update(node, V, K);
			} else {
				int aId = in.nextInt();
				int bId = in.nextInt();
				Node a = nodes[aId];
				Node b = nodes[bId];
				NodeSum sum = null;
				long s = 0;
				if (a.height < b.height) {
					sum = sumTill(b, a.height);
					s = sum.sum + getAncestralSum(a, sum.node);
				} else {
					sum = sumTill(a, b.height);
					s = sum.sum + getAncestralSum(sum.node, b);
				}
				System.out.println(s);

			}
		}
		System.out.flush();

	}

	static long getAncestralSum(Node a, Node b) {
		long s = 0;
		while (a.parent != b.parent) {
			s += (a.val + b.val);
			s %= (1000000000 + 7);
		}
		s += (a.val);
		s %= (1000000000 + 7);
		return s;
	}

	static class NodeSum {
		Node node;
		long sum;

		NodeSum(Node n, long sum) {
			this.node = n;
			this.sum = sum;
		}
	}

	private static NodeSum sumTill(Node a, final int height) {
		Node temp = a;
		long sum = 0;
		while (temp.height != height) {
			sum += temp.val;
			temp = temp.parent;
			sum %= (1000000000 + 7);
		}
		return new NodeSum(temp, sum);

	}

	private static void update(Node node, int v, int k) {
		int d=0;
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		q.add(null);
		boolean NULL=false;
		while(!q.isEmpty()){
			Node c=q.remove();
			if(c==null){
				if(NULL){
					break;
				}else{
					NULL=true;
					d++;
					q.add(null);
				}
			}else{
				NULL=false;
				c.val+=(v + k * d);
				q.addAll(c.children);
			}
		}
	}

	static class Node {
		Node parent;
		int val;
		int height;
		int id;

		Node(int id) {
			this.id = id;
		}

		ArrayList<Node> children = new ArrayList<Node>();

		@Override
		public String toString() {

			return this.id + "{" + height + "}:" + this.children;
		}
	}
}
