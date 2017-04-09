package hackerearth.examples;

import java.util.Scanner;

public class LalaSchumacherAndAsphalt {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int boosts = in.nextInt();
			int coordinates[][] = new int[boosts][2];
			for (int b = 1; b <= boosts; b++) {
				coordinates[b - 1][0] = in.nextInt();
			}
			for (int b = 1; b <= boosts; b++) {
				coordinates[b - 1][1] = in.nextInt();
			}
			int fx = in.nextInt();
			int fy = in.nextInt();
			int time = in.nextInt();
			int nTime = in.nextInt();
			long min = Long.MAX_VALUE;
			int minI=-1;
			for (int i = 0; i < coordinates.length; i++) {
				long tm = time
						* (Math.abs(coordinates[i][0]) + Math
								.abs(coordinates[i][1]))
						+ nTime
						* (Math.abs(fx - coordinates[i][0]) + Math.abs(fy
								- coordinates[i][1]));
				System.out.println(tm);
				if (tm < min) {
					min = tm;
					minI=i;
				}
			}
			System.out.println(min);
			System.out.println(minI);
		}
	}
}
