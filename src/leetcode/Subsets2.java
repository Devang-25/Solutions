package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Subsets2 {

    public static void main(String[] args) {
        final List<List<Integer>> subsets = new Subsets2().subsetsWithDup(new int[]{1, 2, 2, 3});
        System.out.println(subsets);
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        return subsetsWithDup(new ArrayList<>(countMap.keySet()), countMap, new ArrayList<>(), 0);

    }

    private List<List<Integer>> subsetsWithDup(ArrayList<Integer> nums, Map<Integer, Integer> countMap, List<Integer> soFar, int index) {
        if (index == nums.size()) {
            return Collections.singletonList(soFar);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= countMap.get(nums.get(index)); i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                l.add(nums.get(index));
            }
            List<Integer> new_ = new ArrayList<>(soFar);
            new_.addAll(l);
            System.out.println(new_);
            list.addAll(subsetsWithDup(nums, countMap, new_, index + 1));
        }
        return list;
    }
}
