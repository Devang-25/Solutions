package hackerearth.examples;

import java.util.Scanner;

public class TriwizardTournament {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		StringBuilder b = new StringBuilder();
		for (int t = 1; t <= testCases; t++) {
			int chests = in.nextInt();
			int health[] = new int[chests];
			for (int i = 0; i < chests; i++) {
				health[i] = in.nextInt();
			}
			b.append(maxSubArraySum(health));
			if (t != testCases) {
				b.append("\n");
			}
		}
		System.out.println(b.toString());
	}

	private static int maxSubArraySum(int health[]) {
		int maxSoFar = 0, maxTillHere = 0;
		int i;
		for (i = 0; i < health.length; i++) {
			maxTillHere = maxTillHere + health[i];
			if (maxTillHere < 0)
				maxTillHere = 0;
			if (maxSoFar < maxTillHere)
				maxSoFar = maxTillHere;
		}
		return maxSoFar;
	}
}
