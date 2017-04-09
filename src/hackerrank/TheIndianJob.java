package hackerrank;

import java.util.Scanner;

public class TheIndianJob {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int g = in.nextInt();
			int a[] = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
				sum += a[i];
			}
			if (sum == 0) {
				System.out.println("YES");
			} else {
				boolean possible = isPossible(a, g, a.length) && sum >= g
						&& (sum - g) <= g;
				System.out.println(possible ? "YES" : "NO");
			}
		}
	}

	private static boolean isPossible(int[] a, int g, int n) {
		return isSubsetSum(a, n, g);
	}

	static boolean isSubsetSum(int set[], int n, int sum) {
		boolean subset[][] = new boolean[sum + 1][n + 1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		// If sum is not 0 and set is empty, then answer is false
		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in botton up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j - 1]
							|| subset[i - set[j - 1]][j - 1];
			}
		}
		return subset[sum][n];
	}
}
