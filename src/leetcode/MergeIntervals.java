package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MergeIntervals {
    public static void main(String[] args) {
        final int[][] merge = new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int i[] : merge) {
            System.out.println(i[0] + "-" + i[1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[][]{};
        }
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        Stack<Interval> stack = new Stack<>();
        stack.push(new Interval(intervals[0][0], intervals[0][1]));
        ArrayList<int[]> newIntervals = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= stack.peek().end) {
                // means there is an overlap of interval
                stack.peek().end = Math.max(stack.peek().end, intervals[i][1]);
            } else {
                newIntervals.add(new int[]{stack.peek().start, stack.peek().end});
                stack.pop();
                stack.push(new Interval(intervals[i][0], intervals[i][1]));
            }
        }

        if (!stack.isEmpty()) {
            newIntervals.add(new int[]{stack.peek().start, stack.peek().end});
            stack.pop();
        }
        return newIntervals.toArray(new int[][]{});
    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


}
