package codechef.problems;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FlippingCoins {
	private static int LIMIT = 500000;
	private static int tree[] = new int[LIMIT];
	private static int flip[] = new int[LIMIT];

	public static void main(String rags[]) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream s=new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(s);
		int N = in.nextInt();
		int Q = in.nextInt();
		for (int i = 0; i < Q; i++) {
			int code = in.nextInt();
			int start = in.nextInt();
			int end = in.nextInt();
			if (code == 0) {
				//System.out.println("Update::::::::::::::::::::::");
				update(1, 0, N - 1, start, end);
			} else {
				//System.out.println();
				//System.out.println("Query::::::::::::::::::::::::");
				System.out.println(query(1, 0, N - 1, start, end, 1));
			}
		}
		System.out.flush();
	}

	static void update(int node, int s, int e, int qStart, int qEnd) {
		//System.out.println("update(" + node + ",s=" + s + ", e=" + e
		//		+ ", qStart=" + qStart + ", qEnd=" + qEnd + ")");
		if (s > e || s > qEnd || e < qStart) {
			//System.out.println("return");
			return;
		}

		if (s >= qStart && e <= qEnd) {
			//System.out.println("Block 1 ");
			flip[node] = e - s + 1 - flip[node];
			tree[node] = 1 - tree[node];
			return;
		}

		update(node * 2, s, (s + e) / 2, qStart, qEnd);
		update(1 + node * 2, 1 + (s + e) / 2, e, qStart, qEnd);

		flip[node] = flip[node * 2] + flip[1 + node * 2];
		if (tree[node] == 1)
			flip[node] = e - s + 1 - flip[node];
		return;
	}

	static int query(int node, int s, int e, int qStart, int qEnd, int flips) {
		//System.out.println("query(" + node + ",s=" + s + ", e=" + e
			//	+ ", qStart=" + qStart + ", qEnd=" + qEnd + ", flips=" + flips
				//+ ")");
		if (s > e || s > qEnd || e < qStart)
			return 0;

		if (s >= qStart && e <= qEnd) {
			if (flips == 1)
				return flip[node];
			return e - s + 1 - flip[node];//toggle.
		}
		//System.out.println("-flips=" + flips + ", tree[" + node + "]="
			//	+ tree[node]);
		return query(node * 2, s, (s + e) / 2, qStart, qEnd,
				(flips + tree[node]) % 2)
				+ query(1 + node * 2, 1 + (s + e) / 2, e, qStart, qEnd,
						(flips + tree[node]) % 2);

	}

}
//i took help from other submissions regarding flips.