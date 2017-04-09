package hackerearth.examples;

import java.util.Scanner;

public class ChanduPlayingArea {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		for (int m = 1; m <= testcases; m++) {
			long N = in.nextLong();
			if (N % 2 == 1) {
				N = N - 1;
			}
			long j = (long) Math.ceil(N / 4);
			long i = (N / 2) - j;
			System.out.println(i * j);
		}
	}
}
