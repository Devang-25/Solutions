package hackerrank;

import java.util.Scanner;

import static java.lang.Math.*;

public class TwoRobots {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[m];
            int b[] = new int[m];
            for (int q = 0; q < n; q++) {
                a[q] = in.nextInt();
                b[q] = in.nextInt();
            }
            int dp[][] = new int[n + 1][m + 1];
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int j = 1; j <= m; j++) {
                dp[1][j] = abs(b[0] - a[0]);
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][b[i - 2]] = min(dp[i][b[i - 2]], dp[i - 1][j] + abs(j - a[i - 1]) + abs(a[i - 1] - b[i - 1]));
                    dp[i][j] = min(dp[i][j], dp[i - 1][j] + abs(b[i - 2] - a[i - 1]) + abs(a[i - 1] - b[i - 1]));
                }
            }
            int sol = Integer.MAX_VALUE;
            for (int k = 1; k <= m; k++) {
                sol = min(sol, dp[n][k]);
            }
            System.out.println(sol);
        }
    }
}
