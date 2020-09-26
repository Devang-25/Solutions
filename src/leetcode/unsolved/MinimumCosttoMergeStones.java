package leetcode.unsolved;

public class MinimumCosttoMergeStones {

    public static void main(String[] args) {
        final int answer = new MinimumCosttoMergeStones().mergeStones(new int[]{3, 5, 1, 2, 6}, 3);
        System.out.println(answer);
    }

    public int mergeStones(int[] stones, int K) {
        int[] total = new int[stones.length];
        total[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            total[i] = total[i - 1] + stones[i];
        }

        int dp[][] = new int[stones.length][stones.length];
        for (int i = 0; i < stones.length; i++) {
            for (int j = 0; j < stones.length; j++) {
                dp[i][j] = -1;
            }
        }
        return process(stones, K, 0, stones.length - 1, dp, total);
    }

    private int process(int[] stones, int K, int s, int e, int dp[][], int[] total) {
        System.out.println(s + "->" + e);
        if (e < s) {
            return 0;
        }
        if (s == e) {
            dp[s][e] = total[e];
            return total[e];
        }
        if (dp[s][e] != -1) {
            return dp[s][e];
        }
        if (e - s + 1 == K) {
            if (s - 1 < 0) {
                dp[s][e] = total[e];
                return total[e];
            }
            dp[s][e] = total[e] - total[s - 1];
            return dp[s][e];
        }
        int min = Integer.MAX_VALUE;
        for (int k = s; k <= e - K + 1; k++) {
            System.out.println("K" + k);
            final int collapsed = total[k + K - 1] - (k == 0 ? 0 : total[k - 1]);
            System.out.println("C" + collapsed);
            final int left = process(stones, K, s, k - 1, dp, total);
            final int right = process(stones, K, k + K, e, dp, total);
            System.out.println("L" + left);
            System.out.println("R" + right);
            int merged = merge(left, collapsed, right, K);
            min = Math.min(min, (left + collapsed + right));
        }
        dp[s][e] = min;
        System.out.println(s + "<-" + e);
        return min;
    }

    private int merge(int left, int collapsed, int right, int k) {
        return 0;
    }
}
