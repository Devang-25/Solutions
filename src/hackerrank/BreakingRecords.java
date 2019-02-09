package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BreakingRecords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> list.add(in.nextInt()));
        Record r = new Record(list.get(0), list.get(0), 0, 0);
        for (int x : list) {
            if (x < r.min) {
                r = new Record(x, r.max, r.minBroken + 1, r.maxBroken);
            } else if (x > r.max) {
                r = new Record(r.min, x, r.minBroken, r.maxBroken + 1);
            }
        }
        System.out.println(r.minBroken + " " + r.maxBroken);
    }


    static class Record {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minBroken;
        int maxBroken;

        public Record() {
        }

        public Record(int min, int max, int minBroken, int maxBroken) {
            this.min = min;
            this.max = max;
            this.minBroken = minBroken;
            this.maxBroken = maxBroken;
        }
    }
}
