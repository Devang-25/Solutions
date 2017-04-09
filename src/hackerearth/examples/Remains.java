package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Remains {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int testCases = in.nextInt();
		for (int t = 0; t < testCases; t++) {
			long i = in.nextLong();
			long j = in.nextLong();
			long N = in.nextLong();
			long n = 2;
			long sum = i + j;
			while (n < N) {
				if (i > j) {
					long z = i - j;
					i = j;
					j = z;
				} else {
					long z = j - i;
					i = j;
					j = z;
				}
				if (j == 0) {
					long remaining = N - n;
					long left = remaining % 3;
					sum += 2 * i * (remaining / 3);
					if (left == 2)
						sum += i;
					break;
				}
				sum += j;
				n++;

			}
			System.out.println(sum);
		}
	}
}
