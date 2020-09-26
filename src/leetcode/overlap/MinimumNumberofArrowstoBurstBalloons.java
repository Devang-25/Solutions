package leetcode.overlap;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {

    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> {
            if (a[1] < b[1]) {
                return -1;
            }
            return 1;
        });

        int cur = points[0][1];
        int arrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= cur) {
                // overlap
                cur = Math.min(cur, points[i][1]);
            } else {
                arrows++;
                cur = points[i][1];
            }
        }
        return arrows;

    }
}
