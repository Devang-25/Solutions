package hackerrank;

import java.util.Scanner;

public class ArrayDivider {
	static int s[] = new int[100010];
	static long dp[][] = new long[505][303];

	public static void main(String rags[]) {
		{
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int k = in.nextInt();
			for (int i = 0; i < n; i++) {
				int v = in.nextInt();
				s[i + 1] = s[i] + v;
			}
			long ans = s[n] * s[n];
			for (int i = 0; i <= n; i++) {
				for (int j = 0; j <= k; j++) {
					dp[i][j] = Long.MAX_VALUE/2;
				}
			}
			//dp [i][j] means min X using i numbers and j dividers.
			dp[0][0] = 0;
			System.out.println("for i=1-"+n);
			for (int i = 1; i <= n; i++) {
				System.out.println("for j=1-"+k);
				for (int j = 1; j <= k; j++) {
					System.out.println("for t="+(i-1)+"-"+0);
					for (int t = i - 1; t >= 0; t--) {
						System.out.println("dp["+i+"]["+j+"]=min(dp["+i+"]["+j+"]="+dp[i][j]+",dp["+t+"]["+(j-1)+"]="+dp[t][j-1]+"+(st["+i+"]-st["+t+"])^2="+(s[i] - s[t]) * (s[i] - s[t])+")");
						dp[i][j] = Math.min(dp[i][j], dp[t][j - 1]
								+ (s[i] - s[t]) * (s[i] - s[t]));
						System.out.println(dp[i][j]);
					}
				}
			}
			System.out.println(dp[n][k] * k - ans);
		}
	}
}
