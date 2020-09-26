package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {


    public static void main(String[] args) {
        final int r = new SubarrayswithKDifferentIntegers().subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 1);
        System.out.println(r);
    }

    public int subarraysWithKDistinctSlow(int[] A, int K) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < A.length; j++) {
                set.add(A[j]);
                if (set.size() == K) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithKDistinct_(A, K)-subarraysWithKDistinct_(A, K-1);
    }
    public int subarraysWithKDistinct_(int[] A, int K) {
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        while (right < A.length) {
            countMap.put(A[right], countMap.getOrDefault(A[right], 0) + 1);
            while (countMap.size() > K) {
                // bring the size to <=K
                countMap.put(A[left], countMap.get(A[left]) - 1);
                if (countMap.get(A[left]) == 0) {
                    countMap.remove(A[left]);
                }
                left++;
            }
            count += (right - left) + 1;
            right++;
        }
        return count;
    }

}
