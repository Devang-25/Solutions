package leetcode;

public class MinimumFallingPathSum {

    public static void main(String[] args) {
        final int result = new MinimumFallingPathSum().minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(result);
    }

    public int minFallingPathSum(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < arr[0].length; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]);
                    }
                }
                dp[i][j] += arr[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr[0].length; i++) {
            min = Math.min(dp[arr.length - 1][i], min);
        }
        return min;
    }

}
