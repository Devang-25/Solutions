package hackerearth.examples;

import java.util.Scanner;

public class JimSelection {
	public static void main(String[] a) {
		Scanner s = new Scanner(System.in);
		int c = s.nextInt();
		for (int t = 1; t <= c; t++) {
			long x = s.nextLong();
			while (((x & 1l) == 0) && x > 1)
				x >>= 1;
			System.out.println(x == 1 ? "Yes" : "No");
		}
	}
}
