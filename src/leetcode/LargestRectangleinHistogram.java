package leetcode;

import java.util.Arrays;

public class LargestRectangleinHistogram {

    public static void main(String[] args) {
        final int[] heights = {2, 1, 2};
        final int x = new LargestRectangleinHistogram().largestRectangleArea(heights);
        System.out.println("Largest :" + 0 + "-" + (heights.length - 1) + " -> Max:" + x);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights, int s, int e) {
        System.out.println("process :" + s + "-" + e);
        if (s == e) {
            System.out.println("Largest :" + s + "-" + e + " -> Max:" + heights[s]);
            return heights[s];
        }
        if (s + 1 == e) {
            final int max = Math.max(heights[s], Math.max(heights[e], Math.min(heights[s], heights[e]) * 2));
            System.out.println("Largest :" + s + "-" + e + " -> Max:" + max);
            return max;
        }
        int minIndex = min(heights, s, e);
        if (minIndex == e) {
            return Math.max(heights[minIndex] * (e - s + 1), largestRectangleArea(heights, s, minIndex - 1));
        }
        if (minIndex == s) {
            return Math.max(heights[minIndex] * (e - s + 1), largestRectangleArea(heights, minIndex + 1, e));
        }
        return Math.max(heights[minIndex] * (e - s + 1), Math.max(largestRectangleArea(heights, s, minIndex - 1), largestRectangleArea(heights, minIndex + 1, e)));
    }

    private int min(int[] heights, int s, int e) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = s; i <= e; i++) {
            if (heights[i] < min) {
                min = heights[i];
                index = i;
            }
        }
        return index;
    }
}
