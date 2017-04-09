package hackerearth.examples;

import java.util.Scanner;

public class LittleDeepuAndHisGrilFriend {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int M = in.nextInt();
			int N = in.nextInt();
			boolean winnerTable[] = new boolean[M + 1];
			int elements[] = new int[N];
			for (int e = 0; e < elements.length; e++) {
				elements[e] = in.nextInt();
				winnerTable[elements[e]] = true;
			}
			for (int i = 1; i < winnerTable.length; i++) {
				// if there is any path, s.t the other can loose, then my move/
				// optimal approach will be to take this path.
				if (!winnerTable[i]) {
					for (int j = 0; j < elements.length; j++) {
						if (i - elements[j] >= 0
								&& !winnerTable[i - elements[j]]) {
							// there is a path, where i can loose..
							// if i move s.t i force her on this point, she will
							// loose.
							winnerTable[i] = true;
							break;
						}
					}
				}
			}
			if (winnerTable[winnerTable.length - 1]) {
				System.out.println("Little Deepu");
			} else {
				System.out.println("Kate");
			}
		}
	}
}
