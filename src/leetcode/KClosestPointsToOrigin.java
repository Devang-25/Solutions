package leetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {


    public static void main(String[] args) {
        final int[][] x = new KClosestPointsToOrigin().kClosest(new int[][]{{1, 3}, {-2, 2}, {3, 3}}, 1);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i][0]+","+x[i][1] + "\t");
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> pointPriorityQueue = new PriorityQueue<>(new Point(-1, -1));
        int at = 0;
        for (int[] point : points) {
            pointPriorityQueue.add(new Point(point[0], point[1]));
            if (at >= K) {
                pointPriorityQueue.remove();
            }
            at++;
        }
        int[][] result = new int[K][2];
        final Iterator<Point> iterator = pointPriorityQueue.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            final Point next = iterator.next();
            result[i][0] = next.x;
            result[i][1] = next.y;
            i++;
        }
        return result;
    }


    class Point implements Comparator<Point> {
        int x, y;
        double dist;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            dist = Math.sqrt(x * x + y * y);
        }

        @Override
        public int compare(Point o1, Point o2) {
            if (o1.dist <= o2.dist) {
                return 1;
            }
            return -1;
        }
    }
}
