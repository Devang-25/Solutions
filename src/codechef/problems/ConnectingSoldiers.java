package codechef.problems;

import java.util.Scanner;

public class ConnectingSoldiers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		int minimumMiles[] = new int[35];
		int maximumMiles[] = new int[35];
		minimumMiles[2] = 2;
		// cache all the results.
		for (int i = 3; i <= 31; i++) {
			minimumMiles[i] = i + minimumMiles[i / 2] + minimumMiles[i - i / 2];
			maximumMiles[i] = (i * (i + 1)) / 2 - 1;
		}

		for (int t = 1; t <= testCases; t++) {
			int soldiers = in.nextInt() + 1;
			int miles = in.nextInt();

			if (miles >= minimumMiles[soldiers] && miles <= maximumMiles[soldiers]) {
				// there exist a combination for which we can consume all wire.
				System.out.println(0);
			} else if (miles < minimumMiles[soldiers])
				System.out.println(-1);
			else {
				int remaining = miles - maximumMiles[soldiers];
				// we have remaining wire.
				System.out.println(remaining);
			}
		}
	}

}
