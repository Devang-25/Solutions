package leetcode.unsolved;

import java.util.*;
import java.util.function.BiPredicate;

public class GridIllumination {

    public static void main(String[] args) {
        final int[] ints = new GridIllumination().gridIllumination(5, new int[][]{{0, 0}, {4, 4}}, new int[][]{{1, 1}, {1, 1}});
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        HashMap<Lamp, Integer> lampCount = new HashMap<>();
        for (int l[] : lamps) {
            final Lamp lamp = new Lamp(l[0], l[1]);
            lampCount.putIfAbsent(lamp, 0);
            lampCount.put(lamp, lampCount.get(lamp) + 1);
        }
        int[] result = new int[queries.length];
        int r = 0;
        for (int q[] : queries) {
            final int x = q[0];
            final int y = q[1];
            final boolean b = lampCount.keySet().stream().anyMatch(l -> l.illuminates(x, y));
            System.out.println(b);
            result[r] = (b ? 1 : 0);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (x + i >= 0 && x + i < N && y + j >= 0 && y + j < N) {
                        final Lamp l = new Lamp(x + i, y + j);
                        if (lampCount.containsKey(l)) {
                            lampCount.put(l, lampCount.get(l) - 1);
                            if (lampCount.get(l) == 0) {
                                lampCount.remove(l);
                            }
                        }
                    }
                }
            }
            final Lamp l = new Lamp(x, y);
            if (lampCount.containsKey(l)) {
                lampCount.put(l, lampCount.get(l) - 1);
                if (lampCount.get(l) == 0) {
                    lampCount.remove(l);
                }
            }
            r++;

        }
        return result;

    }

    class Lamp {
        int i;
        int j;
        BiPredicate<Integer, Integer> line1;
        BiPredicate<Integer, Integer> line2;
        BiPredicate<Integer, Integer> line3;
        BiPredicate<Integer, Integer> line4;

        public Lamp(int i, int j) {
            this.i = i;
            this.j = j;
            line1 = (x, y) -> x + y == i;
            line2 = (x, y) -> y - x == i;
            line3 = (x, y) -> x == i;
            line4 = (x, y) -> y == j;
        }

        boolean illuminates(int a, int b) {
            return line1.test(a, b) || line2.test(a, b) || line3.test(a, b) || line4.test(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Lamp lamp = (Lamp) o;
            return i == lamp.i &&
                    j == lamp.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
