package leetcode.reference;

import java.util.Stack;

public class LongestValidParentheses {


    public static void main(String[] args) {
        final int result = new LongestValidParentheses().longestValidParentheses("");
        System.out.println(result);
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result = Math.max(result, i - stack.peek());
                } else {
                    // for the ), there is no reference.
                    // => we make this bad ) as the start of next reference.
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
