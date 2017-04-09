package codechef.problems;

import java.io.BufferedInputStream;
import java.util.*;

public class SaveTheTrees {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            List<Point> points = new ArrayList<>();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    points.add(new Point(a[i], a[j]));
                }
            }
            Collections.sort(points, new PointSorter());
            //System.out.println(points);
            points = convexHull(points.toArray(new Point[points.size()]));
            //System.out.println(points);
            System.out.println((int) (2 * Math.abs(polygonArea(points, points.size()))));
        }

    }

    static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

        if (val == 0)
            return 0; // colinear
        return (val > 0) ? 1 : 2; // clock or counterclock wise
    }

    static class PointSorter implements Comparator<Point> {

        public int compare(Point p1, Point p2) {
            if (p1.x < p2.x) {
                return -1;
            }
            if (p1.x > p2.x) {
                return 1;
            }
            return (p1.y - p2.y);
        }

    }

    static List<Point> convexHull(Point coordinates[]) {
        if (coordinates.length < 3)
            return Arrays.asList(coordinates);

        ArrayList<Point> convexPoints = new ArrayList<Point>(coordinates.length);

        int l = 0;
        for (int i = 1; i < coordinates.length; i++)
            if (coordinates[i].x < coordinates[l].x) {
                l = i;
            }

        int p = l, q;
        do {
            q = (p + 1) % coordinates.length;
            for (int i = 0; i < coordinates.length; i++)
                if (orientation(coordinates[p], coordinates[i], coordinates[q]) == 2) {
                    q = i;
                }
            convexPoints.add(coordinates[q]);
            p = q;
        } while (p != l);
        return convexPoints;
    }

    static double polygonArea(List<Point> points, int numPoints) {
        double area = 0;         // Accumulates area in the loop
        int j = numPoints - 1;  // The last vertex is the 'previous' one to the first

        for (int i = 0; i < numPoints; i++) {
            area = area + (points.get(j).x + points.get(i).x) * (points.get(j).y - points.get(i).y);
            j = i;  //j is previous vertex to i
        }
        return area / 2;
    }
}

class Point {
    int x;
    int y;

    public Point(int i, int j) {
        this.x = i;
        this.y = j;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

}
