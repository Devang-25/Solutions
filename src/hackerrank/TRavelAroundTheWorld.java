package hackerrank;

import java.util.Scanner;

public class TRavelAroundTheWorld {

	private static final int N = 110000;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a[] = new int[2 * N];
		int[] b = new int[2 * N];
		long need[] = new long[N];
		int n = in.nextInt();
		long vol = in.nextLong();
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
			a[i + n] = a[i];
		}
		for (int i = 0; i < n; ++i) {
			b[i] = in.nextInt();
			b[i + n] = b[i];
		}
		int s = 0;
		long tank = 0;
		for (int i = 0; i < 2 * n; ++i) {
			tank += a[i];
			tank = Math.min(tank, vol);
			tank -= b[i];
			if (tank < 0) {
				tank = 0;
				s = i + 1;
			}
		}
		int ans;
		if (s >= n) {
			ans = 0;
		} else {
			ans = 1;
			need[s + n] = 0;
			for (int i = 1; i < n; ++i) {
				int id = s + n - i;
				need[id] = Math.max((long) 0,
						need[id + 1] + b[id] - Math.min((long) a[id], vol));
				if (need[id] == 0)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
