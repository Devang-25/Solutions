package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {
        final boolean exists = new WordSearch().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE");
        System.out.println(exists);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Set<Pos> visited = new HashSet<>();
                    if (exist(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int pos, Set<Pos> visited) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length) {
            return false;
        }
        if (j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(pos)) {
            return false;
        }
        final Pos p = new Pos(i, j);
        if (visited.contains(p)) {
            return false;
        }
        visited.add(p);
        System.out.println(p);
        final boolean result = exist(board, i - 1, j, word, pos + 1, visited)
                || exist(board, i + 1, j, word, pos + 1, visited)
                || exist(board, i, j - 1, word, pos + 1, visited)
                || exist(board, i, j + 1, word, pos + 1, visited);
        visited.remove(p);
        return result;
    }

    class Pos {
        int i, j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pos pos = (Pos) o;
            return i == pos.i &&
                    j == pos.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
