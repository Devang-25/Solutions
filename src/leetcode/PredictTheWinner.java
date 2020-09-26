package leetcode;

import java.util.Arrays;

public class PredictTheWinner {

    public static void main(String[] args) {
        final boolean result = new PredictTheWinner().PredictTheWinner(new int[]{1, 5, 2});
        System.out.println(result);
    }

    public boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, memo) >= 0;
    }

    private int winner(int[] nums, int s, int e, Integer memo[][]) {
        if (s == e) {
            return nums[s];
        }
        if (memo[s][e] != null) {
            return memo[s][e];
        }
        int x = nums[s] - winner(nums, s + 1, e, memo);
        int y = nums[e] - winner(nums, s, e - 1, memo);
        memo[s][e] = Math.max(x, y);
        return memo[s][e];
    }


}
