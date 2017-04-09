package codechef.problems;

import java.util.Arrays;
import java.util.Scanner;

public class CHEFHOME {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int restaurants = in.nextInt();

			if (restaurants % 2 == 1) {
				for (int i = 0; i < restaurants; i++) {
					in.nextInt();
					in.nextInt();
				}
				System.out.println(1);
			} else {
				int x[] = new int[restaurants];
				int y[] = new int[restaurants];
				for (int i = 0; i < restaurants; i++) {
					x[i] = in.nextInt();
					y[i] = in.nextInt();
				}
				Arrays.sort(x);
				Arrays.sort(y);
				int lowerX = x[(restaurants - 1) / 2];
				int upperX = x[((restaurants - 1) / 2) + 1];
				int lowerY = y[(restaurants - 1) / 2];
				int upperY = y[((restaurants - 1) / 2) + 1];
				System.out.println(((long) (upperX - lowerX + 1))
						* (upperY - lowerY+1));

			}

		}
	}
}
