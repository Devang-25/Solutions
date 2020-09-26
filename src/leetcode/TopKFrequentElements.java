package leetcode;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        final int[] x = new TopKFrequentElements().topKFrequent(new int[]{2, 2, 2, 3, 3, 4, 4, 4, 4}, 2);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + "\t");
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>(new Freq(-1, -1));
        int at = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new Freq(e.getKey(), e.getValue()));
            if (at >= k) {
                pq.poll();
            }
            at++;
        }
        return pq.stream().mapToInt(x -> x.v).toArray();
    }

    class Freq implements Comparator<Freq> {
        int v;
        int f;

        public Freq(int v, int f) {
            this.v = v;
            this.f = f;
        }

        @Override
        public int compare(Freq o1, Freq o2) {
            if (o1.f > o2.f) {
                return 1;
            }
            return -1;
        }
    }
}
