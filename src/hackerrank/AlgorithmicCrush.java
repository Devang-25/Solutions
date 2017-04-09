package hackerrank;

import java.util.Scanner;
//made some change.
public class AlgorithmicCrush {
	private static long tree[];
	static long[] addedToInterval;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); // Height of
		int maxSizeTree = 2 * (int) Math.pow(2, x) - 1; // Maximum size of segment
		tree = new long[maxSizeTree];
		addedToInterval = new long[maxSizeTree];
		for (int i = 0; i < m; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			//System.out.println("New" + a + "-" + b + " by " + k);
			update(1, 0, n - 1, a, b, k);
			//System.out.println("global max is :" + tree[1]);
		}
		System.out.println(tree[1]);

	}

	static void update(int node, int s, int e, int qStart, int qEnd, int k) {
		System.out.println(node + "([" + s + "-" + e + "],[" + qStart + "-"
				+ qEnd + "])");
		if (s > e || s > qEnd || e < qStart) {
			//System.out.println("0");
			return;
		}

		if (s >= qStart && e <= qEnd) {
			tree[node] += k;
			addedToInterval[node] += k;
			//System.out.println("Set:" + tree[node]);
			return;
		}

		update(node * 2, s, (s + e) / 2, qStart, qEnd, k);
		update(1 + node * 2, 1 + (s + e) / 2, e, qStart, qEnd, k);
		tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1])
				+ addedToInterval[node];
		//System.out.println("Max: " + tree[node]);
	}

}
