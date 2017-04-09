package hackerearth.examples;

import java.util.Scanner;

public class WeAreOnFire {
	private static int count[][];
	private static Nation[][] nations;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int queries = in.nextInt();
		nations = new Nation[n][m];
		count = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int nation = in.nextInt();
				if (nation == 1) {
					nations[i][j] = new Nation();
					Nation nat = nations[i][j];
					nat.headI = i;
					nat.headJ = j;
				}
			}
		}
		int total = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (nations[i][j] != null && !nations[i][j].discovered) {
					count[i][j] = process(i, j, i, j);
					total += count[i][j];
				}
			}
		}
		// System.out.println("total is :"+total);
		for (int q = 1; q <= queries; q++) {
			int i = in.nextInt() - 1;
			int j = in.nextInt() - 1;
			if (nations[i][j] != null) {
				// this is a nation.
				int h = nations[i][j].headI;
				int k = nations[i][j].headJ;
				// System.out.println(h+":"+k);
				total -= count[h][k];
				count[h][k] = 0;
			}
			System.out.println(total);
		}

	}

	private static int process(int i, int j, int h, int k) {
		// System.out.println("process("+i+","+j+","+h+","+k+")");
		if (i < nations.length && j < nations[0].length && i >= 0 && j >= 0) {
			if (nations[i][j] == null || nations[i][j].discovered) {
				return 0;
			}
			nations[i][j].discovered = true;
			nations[i][j].headI = h;
			nations[i][j].headJ = k;
			int ret = 1 + process(i + 1, j, h, k) + process(i, j + 1, h, k)
					+ process(i - 1, j, h, k) + process(i, j - 1, h, k);
			// System.out.println(ret);
			return ret;
		}
		return 0;

	}

	static class Nation {
		int headI, headJ;
		boolean discovered = false;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.headI + "," + this.headJ;
		}

	}
}
