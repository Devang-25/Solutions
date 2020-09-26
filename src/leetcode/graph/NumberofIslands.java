package leetcode.graph;

public class NumberofIslands {
    public static void main(String[] args) {
        final int islands = new NumberofIslands().numIslands(new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}});
        System.out.println(islands);
    }

    public int numIslands(char[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    explore(grid, visited, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void explore(char[][] grid, boolean[][] visited, int i, int j) {
        if (grid[i][j] == '1') {
            if (visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            if (i - 1 >= 0) {
                explore(grid, visited, i - 1, j);
            }
            if (i + 1 < grid.length) {
                explore(grid, visited, i + 1, j);
            }
            if (j - 1 >= 0) {
                explore(grid, visited, i, j - 1);
            }

            if (j + 1 < grid[0].length) {
                explore(grid, visited, i, j + 1);
            }
        }
    }


}
