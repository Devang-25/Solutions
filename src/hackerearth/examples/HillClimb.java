/* IMPORTANT: class must not be public. */
package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;

public class HillClimb {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int mountains = in.nextInt();
			int fuel = in.nextInt();
			Integer a[] = new Integer[mountains];
			for (int j = 0; j < a.length; j++) {
				a[j] = in.nextInt();
			}
			System.out.println(Arrays.asList(a));
			boolean charged = false;
			int i = 0;
			int c = 0;
			while (i != a.length - 1) {
				if (!charged) {
					if (a[i + 1] > a[i]) {
						charged = true;
						c += fuel;
					}
				} else {
					if (a[i + 1] < a[i]) {
						charged=false;
					}
				}
				i++;
			}
			System.out.println(c);

		}
	}
}
