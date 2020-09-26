package leetcode;

import java.util.Stack;

public class TeemoAttacking {

    public static void main(String[] args) {
        final int poisonedDuration = new TeemoAttacking().findPoisonedDuration(new int[]{1, 4}, 2);
        System.out.println(poisonedDuration);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        Stack<Interval> stack = new Stack<>();
        // Assuming timeSeries is sorted
        if (timeSeries.length == 0) {
            return 0;
        }

        stack.push(new Interval(timeSeries[0], timeSeries[0] + duration - 1));
        int poisonedTime = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] <= stack.peek().end) {
                stack.peek().end = Math.max(timeSeries[i] + duration - 1, stack.peek().end);
            } else {
                final Interval interval = stack.pop();
                poisonedTime += (interval.end - interval.start) + 1;
                stack.push(new Interval(timeSeries[i], timeSeries[i] + duration - 1));
            }
        }
        if (!stack.isEmpty()) {
            final Interval interval = stack.pop();
            poisonedTime += (interval.end - interval.start) + 1;
        }
        return poisonedTime;
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
