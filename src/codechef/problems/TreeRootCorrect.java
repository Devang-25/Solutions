package codechef.problems;

import java.util.Scanner;

public class TreeRootCorrect {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int id[] = new int[31];
			int childSum[] = new int[60];

			int output = 0;
			int n = in.nextInt();
			for (int i = 0; i < n; i++) {
				id[i] = in.nextInt();
				childSum[i] = in.nextInt();
			}
			for (int i = 0; i < n; i++)
				output -= childSum[i];
			for (int i = 0; i < n; i++)
				output += id[i];
			System.out.println(output);
		}
	}
}
