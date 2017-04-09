package codechef.problems;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Multiple3 {
	private static int LIMIT = 262144;
	private static int zeros[] = new int[LIMIT];
	private static int one[] = new int[LIMIT];
	private static int two[] = new int[LIMIT];

	public static void main(String rags[]) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		//PrintStream s = new PrintStream(new BufferedOutputStream(System.out));
		//System.setOut(s);
		int N = in.nextInt();
		int Q = in.nextInt();
		init(1, 0, N - 1);
		for (int i = 0; i < Q; i++) {
			int code = in.nextInt();
			int start = in.nextInt();
			int end = in.nextInt();
			if (code == 0) {
				//System.out.println("Update::::::::::::::::::::::");
				update(1, 0, N - 1, start, end);
				//System.out.println(query(1, 0, N - 1, 0, N-1));
			} else {
				//System.out.println();
				//System.out.println("Query::::::::::::::::::::::::");
				System.out.println(query(1, 0, N - 1, start, end));
			}
		}
		System.out.flush();
	}

	static int[] update(int node, int s, int e, int qStart, int qEnd) {
		//System.out.println("update(" + node + ",s=" + s + ", e=" + e
		//		+ ", qStart=" + qStart + ", qEnd=" + qEnd + ")");
		if (s > e || s > qEnd || e < qStart) {
			// System.out.println("return");
			return new int[] { 0, 0, 0 };
		}

		if (s ==e) {
			//System.out.println("->(" + node + ",s=" + s + ", e=" + e
			//		+ ", qStart=" + qStart + ", qEnd=" + qEnd + ")");
			//System.out.println("Before {"+zeros[node]+","+one[node]+","+two[node]+"}");
			int _0 = zeros[node];
			int _1 = one[node];
			int _2 = two[node];
			zeros[node] = two[node];
			two[node] = one[node];
			one[node] = _0;
			//System.out.println("->(" + node + ",s=" + s + ", e=" + e
			//		+ ", qStart=" + qStart + ", qEnd=" + qEnd + ")");
			//System.out.println("After{"+zeros[node]+","+one[node]+","+two[node]+"}");
			// return new-old;
			int a=zeros[node] - _0;
			int b= one[node] - _1;
			int c=two[node] - _2;
			//System.out.println(a+":"+b+":"+c);
			return new int[] {a ,b, c };
		}

		int[] updatesA = update(node * 2, s, (s + e) / 2, qStart, qEnd);
		int updatesB[] = update(1 + node * 2, 1 + (s + e) / 2, e, qStart, qEnd);
		/*System.out.println("->(" + node + ",s=" + s + ", e=" + e
				+ ", qStart=" + qStart + ", qEnd=" + qEnd + ")");
		System.out.println("Before {"+zeros[node]+","+one[node]+","+two[node]+"}");*/
		int _0 = zeros[node];
		int _1 = one[node];
		int _2 = two[node];
		zeros[node] = _0 + updatesA[0] + updatesB[0];
		one[node] = _1 + updatesA[1] + updatesB[1];
		two[node] = _2 + updatesA[2] + updatesB[2];
		/*System.out.println("->(" + node + ",s=" + s + ", e=" + e
				+ ", qStart=" + qStart + ", qEnd=" + qEnd + ")");
		System.out.println("After {"+zeros[node]+","+one[node]+","+two[node]+"}");*/
		int a=zeros[node] - _0;
		int b= one[node] - _1;
		int c=two[node] - _2;
		//System.out.println(a+":"+b+":"+c);
		return new int[] {a ,b, c };
	}

	static void init(int node, int s, int e) {
		//System.err.println("init(" + node + "," + s + "," + e);
		if (s == e) {
			zeros[node] = 1;
			return;
		} else {
			zeros[node] = e - s + 1;
		}

		init(node * 2, s, (s + e) / 2);
		init(1 + node * 2, 1 + (s + e) / 2, e);
	}

	static int query(int node, int s, int e, int qStart, int qEnd) {
		/*System.out.println("query(" + node + ",s=" + s + ", e=" + e
				+ ", qStart=" + qStart + ", qEnd=" + qEnd + "):"+zeros[node]);*/
		if (s > e || s > qEnd || e < qStart)
			{//System.out.println("<-");
			return 0;
			}
		if (s >= qStart && e <= qEnd) {
			return zeros[node];
		}
		return query(node * 2, s, (s + e) / 2, qStart, qEnd)
				+ query(1 + node * 2, 1 + (s + e) / 2, e, qStart, qEnd);

	}

}