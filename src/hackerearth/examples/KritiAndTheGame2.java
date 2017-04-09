package hackerearth.examples;

import java.util.Scanner;

public class KritiAndTheGame2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int kSize = in.nextInt();
		int sSize = in.nextInt();
		int kSet[] = new int[kSize];
		int sSet[] = new int[sSize];
		for (int i = 0; i < kSize; i++) {
			kSet[i] = in.nextInt();
		}

		for (int i = 0; i < sSize; i++) {
			sSet[i] = in.nextInt();
		}
		int queries = in.nextInt();
		for (int i = 1; i <= queries; i++) {
			int n = in.nextInt();
			char start = in.next().charAt(0);
			boolean iWin = false;
			if (start == 'S') {
				iWin = doIWin(sSet, kSet, n);
			} else {
				System.out.println("K starts");
				iWin = doIWin(kSet, sSet, n);
			}
			if (start == 'K') {
				iWin = !iWin;
			}
			if (iWin) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean doIWin(int[] first, int[] second, int n) {
		boolean firstWinTable[] = new boolean[n + 1];
		boolean secondWinTable[] = new boolean[n + 1];
		for (int i = 0; i < first.length; i++) {
			if (first[i] <= n) {
				firstWinTable[first[i]] = true;
			}
		}
		for (int i = 0; i < second.length; i++) {
			if (second[i] <= n) {
				secondWinTable[second[i]] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			if (!firstWinTable[i]) {
				for (int j = 0; j < first.length; j++) {
					if (i - first[j] >= 0 && !secondWinTable[i - first[j]]) {
						firstWinTable[i] = true;
						break;
					}
				}
				if (!firstWinTable[i]) {
					secondWinTable[i] = true;
				}
			}
		}
		return firstWinTable[n];
	}
}
