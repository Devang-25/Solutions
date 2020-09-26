package leetcode;

import java.util.*;

public class QueensThatCanAttacktheKing {

    public static void main(String[] args) {
        final List<List<Integer>> lists = new QueensThatCanAttacktheKing().queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0});
        System.out.println(lists);
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> results = new ArrayList<>();
        Set<Queen> queenSet = new HashSet<>();
        for (int[] q : queens) {
            queenSet.add(new Queen(q[0], q[1]));
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                final Queen q = getQueenInDirection(king[0], king[1], queenSet, i, j);
                if (q != null) {
                    results.add(Arrays.asList(q.i, q.j));
                }
            }
        }
        return results;
    }

    private Queen getQueenInDirection(int ki, int kj, Set<Queen> queens, int di, int dj) {
        int pi = ki + di;
        int pj = kj + dj;
        while (pi >= 0 && pi < 8 && pj >= 0 && pj < 8) {
            final Queen q = new Queen(pi, pj);
            if (queens.contains(q)) {
                return q;
            }
            pi += di;
            pj += dj;
            System.out.println("Explore" + pi + ", " + pj);
        }
        return null;
    }

    class Queen {
        int i;
        int j;

        public Queen(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Queen queen = (Queen) o;
            return i == queen.i &&
                    j == queen.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
