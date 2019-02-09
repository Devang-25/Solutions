package hackerrank;

import java.util.*;
import java.util.stream.IntStream;

public class CountTriplets {
    private static HashMap<Long, TreeSet<Integer>> map = new HashMap<>();
    static int r = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        r = in.nextInt();

        Set<Long> superset = new TreeSet<>();
        IntStream.range(0, n)
                .forEach(i -> {
                    long v = in.nextLong();
                    map.putIfAbsent(v, new TreeSet<>());
                    TreeSet<Integer> indices = map.get(v);
                    indices.add(i);
                    map.put(v, indices);
                    superset.add(v);
                });

        int j = 0;
        for (long v : superset) {
            process(v, j);
            j++;
        }
        System.out.println(total);
    }

    static TreeSet<Integer> empty = new TreeSet<>();
    private static long total = 0;

    private static void process(long value, int index) {
        TreeSet<Integer> ind1 = map.getOrDefault(value, empty);
        SortedSet<Integer> h1 = ind1.tailSet(index);
        for (int v0 : h1) {
            TreeSet<Integer> ind2 = map.getOrDefault(value * r, empty);
            Set<Integer> h2 = ind2.tailSet(v0);
            for (int v : h2) {
                TreeSet<Integer> ind3 = map.getOrDefault(value * r * r, empty);
                Set<Integer> h3 = ind3.tailSet(v);
                total += h3.size();
            }
        }
    }
}
