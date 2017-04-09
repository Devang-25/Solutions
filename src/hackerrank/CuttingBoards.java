package hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CuttingBoards {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int m = in.nextInt();
			int n = in.nextInt();

			PriorityQueue<Long> y = new PriorityQueue<Long>(m - 1,
					new Comparator<Long>() {

						@Override
						public int compare(Long o1, Long o2) {
							if (o1 > o2) {
								return -1;
							}
							return 1;
						}

					});
			PriorityQueue<Long> x = new PriorityQueue<Long>(n - 1,
					new Comparator<Long>() {

						@Override
						public int compare(Long o1, Long o2) {
							if (o1 > o2) {
								return -1;
							}
							return 1;
						}

					});

			for (int i = 0; i < m - 1; i++) {
				y.add(in.nextLong());
			}
			for (int i = 0; i < n - 1; i++) {
				x.add(in.nextLong());
			}
			int hSegs = 1;
			int vSegs = 1;
			long cost = 0;
			while (!x.isEmpty() && !y.isEmpty()) {
				if (y.peek() >= x.peek()) {
//					System.out.println(y.peek() + "*" + hSegs + "="
//							+ (y.peek() * hSegs));
					cost += y.peek() * hSegs;
					y.remove();
					vSegs++;
				} else if (y.peek() == x.peek()) {
					if (hSegs <= vSegs) {
//						System.out.println(y.peek() + "*" + hSegs + "="
//								+ (y.peek() * hSegs));
						cost += y.peek() * hSegs;
						vSegs++;
						y.remove();
					} else {
						cost += x.peek() * vSegs;
//						System.out.println(x.peek() + "*" + vSegs + "="
//								+ (x.peek() * vSegs));
						hSegs++;
						x.remove();
					}
				} else {
					cost += x.peek() * vSegs;
//					System.out.println(x.peek() + "*" + vSegs + "="
//							+ (x.peek() * vSegs));
					hSegs++;
					x.remove();
				}
				cost %= (1000000000 + 7);
			}
			if (x.isEmpty()) {
				while (!y.isEmpty()) {
					cost += y.peek() * hSegs;
//					System.out.println(y.peek() + "*" + hSegs + "="
//							+ (y.peek() * hSegs));
					y.remove();
					cost %= (1000000000 + 7);
				}
			} else if (y.isEmpty()) {
				while (!x.isEmpty()) {
					cost += x.peek() * vSegs;
//					System.out.println(x.peek() + "*" + vSegs + "="
//							+ (x.peek() * vSegs));
					x.remove();
					cost %= (1000000000 + 7);
				}
			}
			System.out.println(cost);
		}
	}
}
