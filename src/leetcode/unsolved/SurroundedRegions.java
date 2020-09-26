package leetcode.unsolved;

public class SurroundedRegions {

    public static void main(String[] args) {
        final char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        new SurroundedRegions().solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    boolean surrounded = isSurrounded(board, i, j, visited);
                    if (surrounded) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

    }

    private boolean isSurrounded(char[][] board, int i, int j, boolean[][] visited) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length) {
            if (board[i][j] == 'X') {
                return true;
            }
            if (visited[i][j]) {
                return true;
            }
            visited[i][j] = true;
            System.out.println("Started " + i + "-" + j);
            boolean isSurrounded = isSurrounded(board, i + 1, j, visited) && isSurrounded(board, i, j + 1, visited);
            if (isSurrounded) {
                if ((i - 1 >= 0 && board[i - 1][j] == 'X')) {
                    isSurrounded = true;
                } else if (j - 1 >= 0 && board[i][j - 1] == 'X') {
                    isSurrounded = true;
                }
            }
            System.out.println("Ended " + i + "-" + j + "\tisSurrounded:" + isSurrounded);
            visited[i][j] = false;
            return isSurrounded;
        }
        return false;
    }

}
