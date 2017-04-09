/**
 * 
 */
package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author makkg
 *
 */
public class SquareSubsequencesDifficult implements Runnable{
	final static int MOD = 1000000007;

    int count(String a, String b) {
        int n = a.length();
        int m = b.length();
        int dp[][] = new int[n + 1][m + 1];
        int sum[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            sum[i][m] = 1;
        }
        for (int j = 0; j <= m; ++ j) {
            sum[n][j] = 1;
        }
        for (int i = n - 1; i >= 0; -- i) {
            for (int j = m - 1; j >= 0; -- j) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = sum[i + 1][j + 1];
                } 
                sum[i][j] = (sum[i + 1][j] + sum[i][j + 1]
                    - sum[i + 1][j + 1] + dp[i][j]) % MOD;
            }
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result += dp[i][0];
            result %= MOD;
        }
        return result;
    }

    int count(String s) {
        int n = s.length();
        int result = 0;
        for (int k = 1; k < n; ++ k) {
            result += count(s.substring(0, k), s.substring(k, n));
            result %= MOD;
        }
        return (result + MOD) % MOD;
    }
    
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            int testCount = Integer.parseInt(reader.readLine());
            while (testCount > 0) {
                testCount --;
                System.out.println(count(reader.readLine()));
            }
        } catch (Exception e) {
        }
    }

    public static void main(String args[]) {
        new Thread(new SquareSubsequencesDifficult()).run();
    }
	
}
