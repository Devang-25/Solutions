package leetcode;

public class MinimumCostForTickets {


    public static void main(String[] args) {
        final int result = new MinimumCostForTickets().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15});
        System.out.println(result);
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        for (int i = 0; i < days[0]; i++) {
            dp[i] = 0;
        }
        for (int i = 0; i < days.length; i++) {
            int min = Integer.MAX_VALUE;
            min = Math.min(min, costs[0] + ((days[i] - 1 >= 0) ? dp[days[i] - 1] : 0));
            min = Math.min(min, costs[1] + ((days[i] - 7 >= 0) ? dp[days[i] - 7] : 0));
            min = Math.min(min, costs[2] + ((days[i] - 30 >= 0) ? dp[days[i] - 30] : 0));
            dp[days[i]] = min;
            System.out.println(days[i] + ":" + min);
            if (i + 1 < days.length) {
                for (int j = days[i] + 1; j < days[i + 1]; j++) {
                    dp[j] = dp[j - 1];
                    System.out.println(j + ":" + dp[j]);
                }
            }
        }
        return dp[days[days.length - 1]];
    }

}
