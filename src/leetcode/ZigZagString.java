package leetcode;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ZigZagString {

    public static void main(String[] args) {
        System.out.println(new ZigZagString().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int R) {
        int length = s.length();
        int index = 0;
        TreeSet<Pair> zigZagOrder = new TreeSet<>();
        int cj = 0;
        boolean exit = false;
        while (true) {
            for (int i = 0; i < R; i++) {
                if (index == length) {
                    exit = true;
                    break;
                }
                final char c = s.charAt(index);
                zigZagOrder.add(new Pair(c, i, cj));
                index++;
            }
            if (!exit) {
                int j = cj + 1;
                for (int i = R - 2; i > 0; i--) {
                    if (index == length) {
                        exit = true;
                        break;
                    }
                    final char c = s.charAt(index);
                    zigZagOrder.add(new Pair(c, i, j));
                    j++;
                    index++;
                }
                cj = j;
            }
            if (exit) {
                break;
            }
        }
        final List<String> collect = zigZagOrder.stream().map(x -> x.c).collect(Collectors.toList());
        return String.join("", collect);

    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        String c;

        Pair(char c, int x, int y) {
            this.c = c + "";
            this.x = x;
            this.y = y;
            System.out.println(c + "\t" + x + "\t" + y);
        }

        @Override
        public int compareTo(Pair o) {
            if (x < o.x) {
                return -1;
            }
            if (x == o.x) {
                if (y <= o.y) {
                    return -1;
                }
            }
            return 1;
        }
    }
}
