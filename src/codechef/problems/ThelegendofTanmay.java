package codechef.problems;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class ThelegendofTanmay {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int testCases = in.nextInt();
		System.out.println("Solutions: ");
		for (int t = 1; t <= testCases; t++) {
			long N = in.nextLong();
			long prod = 1L;
			int min = Integer.MAX_VALUE;
			long included = 0;
			for (int i = 0; i < N; i++) {
				int v = in.nextInt();
				if (v == 0) {
					if (min > v) {
						min = v;
					}

				} else if (v < 0) {
					if (min < 0) {
						if (v > min) {
							min = v;
						}
					} else if (v < min) {
						min = v;
					}
				} else {
					if (v < min) {
						min = v;
					}
				}
				prod *= v;
				included++;
			}
			if ((included == 1 && prod < 0) || included == 0) {
				prod = 0;
			}
			if (prod < 0 && min < 0) {
				System.out.println((prod / min) + " " + min);
			} else if (prod > 0) {
				System.out.println(prod + " " + (min == 0 ? 0 : (prod / min)));
			} else {
				System.out.println(prod + " " + min);
			}
		}
	}
}
