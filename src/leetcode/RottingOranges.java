package leetcode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        final int result = new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}});
        System.out.println(result);
    }

    public int orangesRotting(int[][] grid) {
        Bad minBoundary = new Bad(-1, -1);
        LinkedList<Bad> bads = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    bads.addLast(new Bad(i, j));
                }
            }
        }
        bads.addLast(minBoundary);
        int mins = -1;
        boolean endOfMin = false;
        while (!bads.isEmpty()) {
            final Bad this_ = bads.removeFirst();
            System.out.println(this_);
            if (this_ == minBoundary) {
                if (!endOfMin) {
                    mins++;
                    System.out.println(mins);
                    bads.addLast(minBoundary);
                    endOfMin = true;
                }
            } else {
                endOfMin = false;
                int x = this_.x;
                int y = this_.y;
                process(grid, x + 1, y, bads);
                process(grid, x - 1, y, bads);
                process(grid, x, y - 1, bads);
                process(grid, x, y + 1, bads);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    mins = -1;
                    break;
                }
            }
        }
        return mins;
    }


    private void process(int grid[][], int neighbourX, int neighbourY, LinkedList<Bad> bads) {
        if (neighbourX >= 0 && neighbourX < grid.length && neighbourY >= 0 && neighbourY < grid[0].length) {
            // bounds check
            if (grid[neighbourX][neighbourY] == 1) {
                grid[neighbourX][neighbourY] = 2;
                bads.addLast(new Bad(neighbourX, neighbourY));
            }
        }
    }

    class Bad {
        int x, y;

        public Bad(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Bad{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
