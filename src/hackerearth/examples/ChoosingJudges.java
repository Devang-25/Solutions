package hackerearth.examples;

import java.util.Scanner;

public class ChoosingJudges {
	private static int pointsCache[] = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int judgesScores[] = new int[in.nextInt()];
			pointsCache = new int[judgesScores.length];
			for (int j = 0; j < judgesScores.length; j++) {
				judgesScores[j] = in.nextInt();
			}
			if (judgesScores.length == 1) {
				System.out.println("Case "+t+": "+judgesScores[0]);
			} else if (judgesScores.length == 2) {
				System.out.println("Case "+t+": "+Math.max(judgesScores[0], judgesScores[1]));
			} else {
				System.out.println("Case "+t+": "+points(judgesScores, 0));
			}

		}
	}

	private static int points(int[] judgesScores, int i) {
		if (i >= judgesScores.length) {
			return 0;
		}
		if (pointsCache[i] != 0) {
			return pointsCache[i];
		}
		return Math.max(judgesScores[i] + points(judgesScores, i + 2),
				points(judgesScores, i + 1));
	}
}
