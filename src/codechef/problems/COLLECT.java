package codechef.problems;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class COLLECT {
	private static int LIMIT = 500000;
	private static int tree[] = new int[LIMIT];

	public static void main(String rags[]) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream s = new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(s);
		int N = in.nextInt();
		int bushes[] = new int[N];
		for (int i = 0; i < bushes.length; i++) {
			bushes[i] = in.nextInt();
		}
		preprocess(bushes, 1, 0, N-1);
		int Q = in.nextInt();
		for (int i = 0; i < Q; i++) {
			String code = in.next();
			int start = in.nextInt()-1;
			int end = in.nextInt()-1;
			if (code.equals("change")) {
				// System.out.println("Update::::::::::::::::::::::");
				update(1, 0, N - 1, start, end);
			} else {
				// System.out.println();
				// System.out.println("Query::::::::::::::::::::::::");
				System.out.println(query(1, 0, N - 1, start, end));
			}
		}
		System.out.flush();
	}

	private static int preprocess(int bushes[], int nodeId, int from, int to) {
		if (from == to) {
			tree[nodeId] = bushes[from];
			return tree[nodeId];
		}
		if (from + 1 == to) {
			tree[nodeId] = bushes[from] + bushes[to];
			return tree[nodeId];

		}
		tree[nodeId] = preprocess(bushes, nodeId * 2, from, (from + to) / 2);
		tree[nodeId] += preprocess(bushes, nodeId * 2 + 1, ((from + to) / 2) + 1, to);
		return tree[nodeId];
	}

	static void update(int node, int s, int e, int qStart, int qEnd) {
		// System.out.println("update(" + node + ",s=" + s + ", e=" + e
		// + ", qStart=" + qStart + ", qEnd=" + qEnd + ")");
		if (s > e || s > qEnd || e < qStart) {
			// System.out.println("return");
			return;
		}

		if (s >= qStart && e <= qEnd) {
			// update this node.
			tree[node]=0;

		}
		update(node * 2, s, (s + e) / 2, qStart, qEnd);
		update(1 + node * 2, 1 + (s + e) / 2, e, qStart, qEnd);
		tree[node]=tree[node*2]+tree[node*2+1];
		return;
	}

	static int query(int node, int s, int e, int qStart, int qEnd) {

		if (s > e || s > qEnd || e < qStart)
			return 0;

		if (s >= qStart && e <= qEnd) {
			return tree[node];
		}
		
		return query(node * 2, s, (s + e) / 2, qStart, qEnd)
				+ query(1 + node * 2, 1 + (s + e) / 2, e, qStart, qEnd);

	}
}
