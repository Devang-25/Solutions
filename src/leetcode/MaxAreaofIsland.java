package leetcode;

public class MaxAreaofIsland {
    public static void main(String[] args) {
        final int islands = new MaxAreaofIsland().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}});
        System.out.println(islands);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int islandMaxArea = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    final int area = explore(grid, visited, i, j);
                    if (islandMaxArea < area) {
                        islandMaxArea = area;
                    }
                }
            }
        }
        if (islandMaxArea == Integer.MIN_VALUE) {
            return 0;
        }
        return islandMaxArea;
    }

    private int explore(int[][] grid, boolean[][] visited, int i, int j) {
        if (grid[i][j] == 1) {
            if (visited[i][j]) {
                return 0;
            }
            visited[i][j] = true;
            int area = 1;
            if (i - 1 >= 0) {
                area += explore(grid, visited, i - 1, j);
            }
            if (i + 1 < grid.length) {
                area += explore(grid, visited, i + 1, j);
            }
            if (j - 1 >= 0) {
                area += explore(grid, visited, i, j - 1);
            }

            if (j + 1 < grid[0].length) {
                area += explore(grid, visited, i, j + 1);
            }
            return area;
        }
        return 0;
    }


}
