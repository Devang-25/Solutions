package codechef.problems;

import java.util.Scanner;

public class MBOARDFaster {
	static int rowts[][] = new int[2][500001];
	static int[][] colts = new int[2][500001];
	static int[][] treer = new int[2][500001];
	static int[][] treec = new int[2][500001];
	static int maxval;

	static int readr(int x, int idx) {
		int sum = 0;
		while (idx > 0) {
			sum = sum + treer[x][idx];
			idx = idx - (idx & (-idx));
		}
		return sum;
	}

	static void updater(int x, int tim, int val) {
		while (tim > 0 && tim <= maxval) {
			treer[x][tim] += val;
			//going down the tree.
			tim += (tim & (-tim));
		}
	}

	static int readc(int x, int idx) {
		int sum = 0;
		while (idx > 0) {
			sum = sum + treec[x][idx];
			//going up the tree.
			idx = idx - (idx & (-idx));
		}
		return sum;
	}

	static void updatec(int x, int tim, int val) {
		while (tim > 0 && tim <= maxval) {
			treec[x][tim] += val;
			//going down the tree.
			tim += (tim & (-tim));
		}
	}

	public static void main(String rags[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		maxval = q;
		int count=0;
		for (int tim = 1; tim <= q; tim++) {
			String s = in.next();
			if (s.equals("RowSet")) {
				int r = in.nextInt();
				int x = in.nextInt();
				if (rowts[0][r] != 0 || rowts[1][r] != 0) {
					if (rowts[0][r] > rowts[1][r])
						updater(0, rowts[0][r], -1);
					else
						updater(1, rowts[1][r], -1);
				}
				rowts[x][r] = tim;
				//the element e as referred in the discussion is time stamp.
				updater(x, tim, 1);
			} else if (s.equals("ColSet")) {
				int c = in.nextInt();
				int x = in.nextInt();
				if (colts[0][c] != 0 || colts[1][c] != 0) {
					if (colts[0][c] > colts[1][c])
						updatec(0, colts[0][c], -1);
					else
						updatec(1, colts[1][c], -1);
				}
				colts[x][c] = tim;
				updatec(x, tim, 1);
			} else if (s.equals("RowQuery")) {
				int r = in.nextInt();
				if (rowts[0][r] >= rowts[1][r]) {
					count = readc(1, tim) - readc(1, rowts[0][r]);
					System.out.println((n - count));
				} else {
					count = readc(0, tim) - readc(0, rowts[1][r]);
					System.out.println(count);
				}
			} else {
				int c = in.nextInt();
				if (colts[0][c] >= colts[1][c]) {
					count = readr(1, tim) - readr(1, colts[0][c]);
					System.out.println((n - count));
				} else {
					count = readr(0, tim) - readr(0, colts[1][c]);
					System.out.println(count);
				}
			}
		}
	}

}