package hackerearth.examples;

import java.util.Scanner;

public class HaaaaveYouMetTed {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int nos = in.nextInt();
			long min = Long.MAX_VALUE;
			for (int i = 1; i <= nos; i++) {
				int hammingCode = NumberOfSetBits(in.nextInt());
				if (hammingCode < min) {
					min = hammingCode;
				}
			}
			System.out.println(min);
		}
	}

	static int NumberOfSetBits(int i) {
		i = i - ((i >> 1) & 0x55555555);
		i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
		return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
	}
}
