package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class TargetSum {


    public static void main(String[] args) {
        final int targetSumWays = new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] memory = new int[nums.length][2001];
        for (int i = 0; i < memory.length; i++) {
            Arrays.fill(memory[i], Integer.MAX_VALUE);
        }
        return process(nums, 0, memory, 0, S);
    }

    private int process(int[] nums, int i, int[][] memory, int cSum, int tSum) {
        if (i == nums.length) {
            return (cSum == tSum) ? 1 : 0;
        }
        if (memory[i][cSum + 1000] != Integer.MAX_VALUE) {
            return memory[i][cSum + 1000];
        }
        memory[i][cSum + 1000] = process(nums, i + 1, memory, cSum + nums[i], tSum) + process(nums, i + 1, memory, cSum - nums[i], tSum);
        return memory[i][cSum + 1000];
    }
}
