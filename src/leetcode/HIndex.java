package leetcode;

import java.util.Arrays;

public class HIndex {


    public static void main(String[] args) {
        final int i = new HIndex().hIndex(new int[]{1});
        System.out.println(i);
    }

    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int max = Integer.MIN_VALUE;
        for (int i = citations.length - 1; i >= 0; i--) {
            int h = citations.length - 1 - i + 1;
            if (citations[i] >= h && (i == 0 || citations[i - 1] <= h)) {
                if (h > max) {
                    max = h;
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
