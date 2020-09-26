package leetcode;

import java.util.*;

public class CombinationSum {
    List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        final List<List<Integer>> lists = new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinations(candidates, -1, target, new Stack<>());
        return results;
    }

    private void combinations(int[] candidates, int c, int target, Stack<Integer> soFar) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(soFar));
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] >= c) {
                soFar.push(candidates[i]);
                combinations(candidates, candidates[i], target - candidates[i], soFar);
                soFar.pop();
            }
        }
    }

}
