package hackerearth.examples;

import java.util.Scanner;

public class ExamTime {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int rank = in.nextInt();
			System.out.println(eulerTotem(rank));
		}
	}

	private static int eulerTotem(int rank) {
		int count = rank;
		for (int factor = 2; factor * factor <= rank; factor++) {
			if (rank % factor == 0) {
				// we are sure factor is prime.
				count -= count / factor;
			}
			// here we consume all multiples of 'factor'
			while (rank % factor == 0) {
				rank /= factor;
			}
			// we reduce the rank to a number that can not be divisible by any
			// multiple of 'factor'
		}
		if (rank > 1) {
			count -= count / rank;
		}
		return count;
	}
}
