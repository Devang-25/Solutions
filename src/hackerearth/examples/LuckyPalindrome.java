package hackerearth.examples;

import java.util.Scanner;

public class LuckyPalindrome {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		StringBuilder b = new StringBuilder();
		for (int i = 1; i <= testCases; i++) {
			long maxSeq = longestPalindromeSubString(in.nextLong());
			b.append(maxSeq);
			if (i != testCases) {
				b.append("\n");
			}
		}
		System.out.println(b.toString());
	}

	/*
	 * expression: (2^(n+1))(n-1)<=(N-2) solving gives n..=>2*n-1
	 */
	private static long longestPalindromeSubString(long luckyLen) {
		long digits = 1;
		long factor = 2;
		long covered = digits * factor;
		while (covered < luckyLen) {
			factor *= 2;
			digits++;
			covered += digits * factor;
		}
		// went beyond..go back.
		long left = (luckyLen - (covered - digits * factor));
		long maxLen = digits + digits - 1;
		if (left >= maxLen) {
			return maxLen;
		} else {
			return left;
		}
	}
}
