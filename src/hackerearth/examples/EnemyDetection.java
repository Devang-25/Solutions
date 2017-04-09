package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EnemyDetection {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			if (inside(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(),
					in.nextInt(), in.nextInt())) {
				System.out.println("INSIDE");
			} else {
				System.out.println("OUTSIDE");
			}
		}
	}

	static float area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (float) (Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0));
	}

	static boolean inside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
		float A = area(x1, y1, x2, y2, x3, y3);
		float A1 = area(x, y, x2, y2, x3, y3);

		float A2 = area(x1, y1, x, y, x3, y3);
		float A3 = area(x1, y1, x2, y2, x, y);
		return (A == A1 + A2 + A3);
	}
}
