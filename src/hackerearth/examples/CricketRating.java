package hackerearth.examples;

import java.util.Scanner;

public class CricketRating {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int no = in.nextInt();

		// int [] input={-1,-4,4,-2,0,1,4,-5};
		int input[] = new int[no];
		for (int i = 0; i < input.length; i++) {
			input[i] = in.nextInt();
		}
		int sum = sum(input);
		System.out.println(sum);
	}

	static int sum(int input[]) {
		int maxSum = 0, sumIncludingI = 0;
		int i;
		for (i = 0; i < input.length; i++) {
			sumIncludingI = sumIncludingI + input[i];
			if (sumIncludingI < 0)
				sumIncludingI = 0;
			if (maxSum < sumIncludingI)
				maxSum = sumIncludingI;
		}
		return maxSum;
	}
}
