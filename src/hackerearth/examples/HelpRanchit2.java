package hackerearth.examples;

import java.util.Scanner;

public class HelpRanchit2 {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		int[] primes = new int[5001];
		primes[0] = 0;
		primes[1] = 0;
		int value = 2;
		int start = 1;
		for (int layer = 2; layer <= 5000; layer++) {
			int c = 0;
			for (int cornor = 1; cornor <= 4; cornor++) {
				start = start + value;
				if (isPrime(start)) {
					c++;
				}
			}
			primes[layer] = primes[layer - 1] + c;
			value = value + 2;
		}

		for (int i = 0; i < testCases; i++) {
			int N = scan.nextInt();
			if (N % 2 == 0) {
				return;
			}
			System.out.format("%f%n", (double) primes[(N + 1) / 2] * 100
					/ (2 * N - 1));
		}
	}

	public  static boolean isPrime(int no) {
		if (no == 2 || no == 3)
			return true;
		for (int i = 3; i < (int) Math.sqrt(no) + 1; i += 2) {
			if (no % i == 0) {
				return false;
			}
		}
		return true;
	}
}
