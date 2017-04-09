
package hackerearth.examples;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ChandToyStack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			long N = in.nextLong();
			int X = in.nextInt();
			int Y = in.nextInt();
			// System.out.println(N+","+X+","+Y);
			PriorityQueue<Long> pqInput = new PriorityQueue<Long>();
			PriorityQueue<Long> pQOutput = new PriorityQueue<Long>();
			System.out.println(in.nextLine());
			for (int j = 1; j <= N; j++) {
				long initS = in.nextLong();
				long finalS = in.nextLong();
				pQOutput.add(finalS);
				pqInput.add(initS);
			}
			int cost = 0;
			while (!pqInput.isEmpty()) {
				if (pqInput.element() == pQOutput.element()) {
					pqInput.remove();
					pQOutput.remove();
				} else {
					long h1 = pqInput.element();
					long h2 = pQOutput.element();
					if (h1 < h2) {
						cost += ((h2 - h1) * X);
					} else {
						cost += ((h1 - h2) * Y);
					}
					pqInput.remove();
					pQOutput.remove();
				}

			}
			System.out.println(cost);
		}
	}
}
