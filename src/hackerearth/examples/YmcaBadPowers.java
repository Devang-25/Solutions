package hackerearth.examples;

import java.util.Scanner;

public class YmcaBadPowers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			long p = in.nextLong();
			long a[] = new long[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextLong();
			}
			int i = 0;
			int j = 0;
			long sum = a[i];
			boolean can = false;
			while (j < a.length) {
				//System.out.println(sum);
				if (sum == p) {
					can = true;
					break;
				}
				if (sum < p) {
					j++;
					sum += a[j];
				} else {
					sum -= a[i];
					if (i == j) {
						if (j + 1 != a.length) {
							j++;
							sum += a[j];
						} else {
							break;
						}

					}
					i++;

				}
			}
			if (can) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}
	}
}
