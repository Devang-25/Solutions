package hackerrank;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LilysHomework {

    // Complete the lilysHomework function below.
    static int lilysHomework(int[] arr) {
        List<Integer> sorted = IntStream.range(0, arr.length)
                .mapToObj(i -> new ValueIndex(arr[i], i))
                .sorted()
                .map(x -> x.index)
                .collect(Collectors.toList());
        //System.out.println(sorted);
        Integer[] sortedArray = sorted.toArray(new Integer[sorted.size()]);
        boolean visited[] = new boolean[sortedArray.length];
        int steps = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (visited[i] || sortedArray[i] == i) {
                continue;
            }
            int s = steps(sortedArray, visited, i);
            //System.out.println(s);
            steps += (s - 1);
        }
        return steps;

    }

    private static int steps(Integer[] arr, boolean[] visited, final int i) {
        int steps = 0;
        int next = i;
        //System.out.println("starting at " + start);
        while (!visited[next]) {
            //System.out.println("-> " + next);
            visited[next] = true;
            next = arr[next];
            steps++;
        }
        return steps;
    }

    static class ValueIndex implements Comparable<ValueIndex> {
        public final int val;
        public final int index;

        public ValueIndex(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(ValueIndex o) {
            if (this.val < o.val) {
                return -1;
            }
            if (this.val == o.val) {
                return 0;
            }
            return 1;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = lilysHomework(arr);
        System.out.println(result);

        scanner.close();
    }
}
