package hackerearth.examples;

import java.util.Scanner;

public class BobJourney {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int cities = in.nextInt();
			boolean remembered[] = new boolean[26];
			boolean can = true;
			for (int i = 1; i <= cities; i++) {
				int index = in.next().charAt(0) - 'a';
				if (remembered[index]) {
					can = false;
				}
				remembered[index] = true;
			}
			if (can) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
