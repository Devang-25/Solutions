package leetcode;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7, 3));
    }

    public int uniquePaths(int m, int n) {
        int ways[][] = new int[m][n];
        Arrays.fill(ways[0], 1);
        for (int i = 0; i < m; i++) {
            ways[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }
}
