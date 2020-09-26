package geek.examples;

public class LongestCommonSubarray {


    public static void main(String[] args) {
        final int max = new LongestCommonSubarray().max(new int[]{2, 7, 9, 1, 2, 3, 4}, new int[]{7, 1, 2, 3, 6, 1, 2, 3, 4, 8, 2, 3, 4});
        System.out.println(max);
    }

    public int max(int[] a, int[] b) {
        int dp[][] = new int[a.length][b.length];
        for (int j = 0; j < b.length; j++) {
            for (int i = 0; i < a.length; i++) {
                dp[i][j] = (a[i] == b[j]) ? 1 + ((i - 1 >= 0 && j - 1 >= 0) ? dp[i - 1][j - 1] : 0) : 0;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < b.length; j++) {
            for (int i = 0; i < a.length; i++) {
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;

    }
}
