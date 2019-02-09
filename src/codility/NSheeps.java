package codility;

import java.util.*;
import java.util.stream.IntStream;

public class NSheeps {

    public static void main(String[] args) {
        int solution = new NSheeps().solution(new int[]{10, 20, 100}, new int[]{10, 20, 100});
        System.out.println(solution);
    }

    public int solution(int[] X, int[] Y) {
        Map<Integer, List<Integer>> x = new HashMap<>();
        Map<Integer, List<Integer>> y = new HashMap<>();
        for (int i = 0; i < X.length; i++) {
            x.putIfAbsent(X[i], new ArrayList<>());
            List<Integer> xList = x.get(X[i]);
            xList.add(Y[i]);
            x.put(X[i], xList);

            y.putIfAbsent(Y[i], new ArrayList<>());
            List<Integer> yList = y.get(Y[i]);
            yList.add(X[i]);
            y.put(Y[i], yList);
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> a : x.entrySet()) {
            List<Integer> list = a.getValue();
            Collections.sort(list);
            min = Math.min(min, IntStream.range(1, list.size()).map(i -> list.get(i) - list.get(i - 1)).min().orElse(min));
        }

        for (Map.Entry<Integer, List<Integer>> a : y.entrySet()) {
            List<Integer> list = a.getValue();
            Collections.sort(list);
            min = Math.min(min, IntStream.range(1, list.size()).map(i -> list.get(i) - list.get(i - 1)).min().orElse(min));
        }
        return min/2;


    }
}
