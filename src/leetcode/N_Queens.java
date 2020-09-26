package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class N_Queens {


    public static void main(String[] args) {
        final List<List<String>> lists = new N_Queens().solveNQueens(4);
        System.out.println(lists);
    }

    List<List<Cell>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        Stack<Cell> stack = new Stack<>();
        solve(0, n, stack);
        return results.stream().map(l -> l.stream().map(x -> x.row(n)).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private void solve(int c, int n, Stack<Cell> stack) {
        if (c == n) {
            results.add(new ArrayList<>(stack));
        }
        System.out.println("At " + c);
        for (int j = 0; j < n; j++) {
            if (safe(c, j, n, stack)) {
                System.out.println("Safe:" + c + "," + j);
                final Cell item = new Cell(c, j);
                stack.push(item);
                solve(c + 1, n, stack);
                stack.pop();
            }
        }
    }

    private boolean safe(int i, int j, int n, Stack<Cell> stack) {
        final boolean sameColumn = stack.stream().anyMatch(s -> s.y == j);
        if (sameColumn) {
            return false;
        }
        int p = i - 1;
        int q = j - 1;

        while (p >= 0 && q >= 0) {
            if (stack.contains(new Cell(p, q))) {
                return false;
            }
            p--;
            q--;
        }
        while (p >= 0 && q < n) {
            if (stack.contains(new Cell(p, q))) {
                return false;
            }
            p--;
            q++;
        }
        return true;
    }

    class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        String row(int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= y - 1; i++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int i = y + 1; i <= n - 1; i++) {
                sb.append('.');
            }
            return sb.toString();
        }
    }

}
