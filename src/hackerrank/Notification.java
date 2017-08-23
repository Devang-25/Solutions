package hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Notification {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int notif = 0;
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            arr[i] = v;
            if (i >= d) {
                //we need to remove.
                if (arr[i - d] < minPQ.peek()) {
                    minPQ.remove(arr[i - d]);
                } else {
                    maxPQ.remove(arr[i - d]);
                }
                rebalance(minPQ, maxPQ);
            }
            if (minPQ.isEmpty() ||v < minPQ.peek()) {
                minPQ.add(v);
            } else {
                maxPQ.add(v);
            }
            rebalance(minPQ, maxPQ);
            if (i >= d) {
                System.out.println(minPQ);
                System.out.println(maxPQ);
                float median;
                if (minPQ.size() == maxPQ.size()) {
                    median = (minPQ.peek() + maxPQ.peek()) / 2;
                } else {
                    median = minPQ.peek();
                }
                System.out.println(median);
                if (v >= 2 * median) {
                    notif++;
                }
            }

        }
        System.out.println(notif);

    }

    private static void rebalance(PriorityQueue<Integer> minPQ, PriorityQueue<Integer> maxPQ) {
        if (minPQ.size() - maxPQ.size() > 1) {
            maxPQ.add(minPQ.poll());
        } else if (maxPQ.size() - minPQ.size() > 1) {
            minPQ.add(maxPQ.poll());
        }
    }
}
