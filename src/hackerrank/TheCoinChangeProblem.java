/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * @author makkg
 *
 */
public class TheCoinChangeProblem {
	private static int cache[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int arr[] = new int[M];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		cache = new int[M][N + 1];
		ways(arr, M, N);
		System.out.println(cache[M - 1][N]);
	}

	static int ways(int coins[], int m, int n) {
		if (n == 0)
			return 1;

		if (n < 0)
			return 0;

		if (m <= 0 && n >= 1)
			return 0;
		if (cache[m - 1][n] != 0) {
			return cache[m - 1][n];
		}
		cache[m - 1][n] = ways(coins, m - 1, n)
				+ ways(coins, m, n - coins[m - 1]);
		return cache[m - 1][n];
	}

	static int ways2(int s[], int m, int n) {
		// ways for n amount and including m coins.
		int cache[][] = new int[n + 1][m];
		for (int i = 0; i < m; i++) {
			cache[0][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				int including = (i - s[j] >= 0) ? cache[i - s[j]][j] : 0;
				int excluding = (j - 1 >= 0) ? cache[i][j - 1] : 0;
				// ways for i amount including j coins.
				cache[i][j] = including + excluding;
			}
		}
		return cache[n][m - 1];
	}
}
