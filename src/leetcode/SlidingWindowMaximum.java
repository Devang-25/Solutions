package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        final int[] max = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 5);
        for (int i = 0; i < max.length; i++) {
            System.out.print(max[i] + "\t");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return new int[]{};
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        System.out.println(priorityQueue);
        int windows = nums.length - k + 1;
        int[] results = new int[windows];
        for (int i = k; i < nums.length; i++) {
            final Integer max = priorityQueue.peek();
            results[i - k] = max;
            priorityQueue.remove(nums[i - k]);
            priorityQueue.add(nums[i]);
            System.out.println(priorityQueue);
        }
        results[results.length - 1] = priorityQueue.peek();
        return results;
    }

}
