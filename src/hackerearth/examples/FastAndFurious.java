package hackerearth.examples;

import java.util.Scanner;

public class FastAndFurious {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			long n = in.nextLong();
			System.out.println(n / 2);
		}
	}
}
