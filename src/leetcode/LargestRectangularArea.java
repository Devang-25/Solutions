package leetcode;

import java.util.Stack;

public class LargestRectangularArea {
    public static void main(String[] args) {
        final int[] heights = {6, 2, 5, 4, 5, 1, 6};
        final int x = new LargestRectangularArea().largestRectangleArea(heights);
        System.out.println("Largest :" + 0 + "-" + (heights.length - 1) + " -> Max:" + x);
    }

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        while (i < heights.length) {
            if (!stack.isEmpty()) {
                if (heights[i] >= heights[stack.peek()]) {
                    System.out.println(heights[i] + " Pushed");
                    stack.push(i++);
                } else {
                    final Integer topIndex = stack.pop();
                    final int v = heights[topIndex];
                    System.out.println(v + " Popped");
                    final int height = v * ((stack.isEmpty()) ? i : (i - stack.peek() - 1));
                    if (height > max) {
                        max = height;
                    }
                }
            } else {
                System.out.println(heights[i] + " Pushed");
                stack.push(i++);
            }
        }

        while (!stack.isEmpty()) {
            final Integer topIndex = stack.pop();
            final int height = heights[topIndex] * ((stack.isEmpty()) ? i : (i - stack.peek() - 1));
            if (height > max) {
                max = height;
            }
        }

        return max;
    }
}
