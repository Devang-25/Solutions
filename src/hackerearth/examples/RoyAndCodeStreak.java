package hackerearth.examples;

import java.util.Scanner;

public class RoyAndCodeStreak {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int attempts = in.nextInt();
			Boolean occurenceTable[] = new Boolean[1000000];
			int f = in.nextInt();
			int isC = in.nextInt();
			occurenceTable[f] = isC == 1;
			int count = isC;
			int max = count;
			for (int a = 1; a < attempts; a++) {
				int q = in.nextInt();
				boolean correct = in.nextInt() == 1;
				if (occurenceTable[q] == null) {
					// encountered first time.
					if (correct) {
						count++;
						occurenceTable[q] = true;
					} else {
						occurenceTable[q] = false;
						if (count > max) {
							max = count;
						}
						count = 0;
					}
				} else if (!occurenceTable[q]) {
					// Occurred previously but was incorrect.
					if (correct) {
						occurenceTable[q] = true;
						count++;
					} else {
						if (count > max) {
							max = count;
						}
						count = 0;
					}
				} else {
					if (!correct) {
						if (count > max) {
							max = count;
						}
						count = 0;
					}
				}
			}
			System.out.println(max > count ? max : count);
		}
	}
}
