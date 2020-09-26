package leetcode.unsolved;

import java.util.Arrays;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        final String s = "aa";
        final String p = "a*";
        final boolean result = new RegularExpressionMatching().isMatch(s, p);
        System.out.println(result);
    }

    boolean isMatch(String str, String pattern) {
        return isMatch(str, pattern, str.length(), pattern.length());
    }

    private boolean isMatch(String str, String pattern,
                            int n, int m) {
        if (m == 0)
            return (n == 0);

        boolean[][] lookup = new boolean[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++)
            Arrays.fill(lookup[i], false);

        lookup[0][0] = true;

        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    lookup[i][j] = lookup[i][j - 1] ||
                            lookup[i - 1][j];
                }

                else lookup[i][j] = false;
            }
        }

        return lookup[n][m];
    }
}
