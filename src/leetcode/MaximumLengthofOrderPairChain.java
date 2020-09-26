package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumLengthofOrderPairChain {

    public static void main(String[] args) {
        final int longestChain = new MaximumLengthofOrderPairChain().findLongestChain(new int[][]{{3, 4}, {2, 3}, {1, 2}});
        System.out.println(longestChain);
    }

    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] longestSoFar = new int[pairs.length];
        Arrays.fill(longestSoFar, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int k = 0; k < i; k++) {
                if (pairs[i][0] > pairs[k][1]) {
                    longestSoFar[i] = Math.max(longestSoFar[i], longestSoFar[k] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int l : longestSoFar) {
            max = Math.max(l, max);
        }
        return max;
    }

}
