package geek.examples.subsequence;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        final int lcs = new LongestCommonSubsequence().lcs("AGGTAB".toCharArray(), "GXTXAYB".toCharArray());
        System.out.println(lcs);
    }

    private int lcs(char a[], char b[]) {
        int dp[][] = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int max = Integer.MIN_VALUE;
                if (a[i] == b[j]) {
                    int m = 1 + ((i - 1 > 0 && j - 1 > 0) ? dp[i - 1][j - 1] : 0);
                    max = Math.max(max, m);
                }
                if (i - 1 >= 0) {
                    max = Math.max(dp[i - 1][j], max);
                }
                if (j - 1 >= 0) {
                    max = Math.max(dp[i][j - 1], max);
                }
                dp[i][j] = max;
            }
        }
        return dp[a.length - 1][b.length - 1];
    }
}
