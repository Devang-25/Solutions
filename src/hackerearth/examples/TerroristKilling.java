package hackerearth.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TerroristKilling {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int terroristCount = in.nextInt();
		Point[] terrorists = new Point[terroristCount];
		for (int i = 0; i < terroristCount; i++) {
			Point terrorist = new Point();
			terrorist.x = in.nextInt();
			terrorist.y = in.nextInt();
			terrorists[i] = terrorist;
		}
		List<Point> points = convexHull(terrorists);
		Collections.sort(points, new PointSorter());
		for(Point p:points){
			System.out.println(p.x+" "+p.y);
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
			return p1.y - p2.y;
		}

	}

	static List<Point> convexHull(Point points[]) {
		if (points.length < 3)
			return Arrays.asList(points);

		ArrayList<Point> convexPoints = new ArrayList<Point>(points.length);

		int l = 0;
		for (int i = 1; i < points.length; i++)
			if (points[i].x < points[l].x)
				l = i;

		// Start from leftmost point, keep moving counterclockwise
		// until reach the start point again
		int p = l, q;
		do {
			// Search for a point 'q' such that orientation(p, i, q) is
			// counterclockwise for all points 'i'
			q = (p + 1) % points.length;
			for (int i = 0; i < points.length; i++)
				if (orientation(points[p], points[i], points[q]) == 2)
					q = i;

			convexPoints.add(points[q]);
			p = q;
		} while (p != l);
		return convexPoints;
	}
}

class Point {
	int x;
	int y;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x + ";" + y;
	}
}