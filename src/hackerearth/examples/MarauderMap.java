package hackerearth.examples;

import java.util.Scanner;

public class MarauderMap {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int locations = in.nextInt();
			int maxX = Integer.MIN_VALUE;
			int maxY = Integer.MIN_VALUE;
			int minX = Integer.MAX_VALUE;
			int minY = Integer.MAX_VALUE;
			int X[]=new int[locations];
			int Y[]=new int[locations];
			for (int i = 0; i <locations; i++) {
				Integer x = in.nextInt();
				Integer y = in.nextInt();
				X[i]=x;
				Y[i]=y;
				if (x < minX) {
					minX = x;
				} else if (x > maxX) {
					maxX = x;
				}
				if (y < minY) {
					minY = y;
				} else if (y > maxY) {
					maxY = y;
				}
			}
			long x = Math.abs(maxX - minX);
			long y = Math.abs(maxY - minY);
			long area = x * y;
			if (area == 0) {
				if (x == 0) {
					System.out.println(y);
				} else {
					System.out.println(x);
				}
			} else {
				System.out.println(area);
			}
			//maxX=Collections.min(Arrays.asList(X));
		}
	}
	
	
}
