package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {


    public static void main(String[] args) {
        final List<List<Integer>> subsets = new Subsets().subsets(new int[]{1, 2, 3, 4});
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        return subsets(0, nums, new ArrayList<>());
    }

    private List<List<Integer>> subsets(int i, int[] nums, List<Integer> soFar) {
        if (i == nums.length) {
            return Collections.singletonList(soFar);
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> with = new ArrayList<>(soFar);
        with.add(nums[i]);
        List<Integer> without = new ArrayList<>(soFar);
        list.addAll(subsets(i + 1, nums, with));
        list.addAll(subsets(i + 1, nums, without));
        return list;
    }

}
