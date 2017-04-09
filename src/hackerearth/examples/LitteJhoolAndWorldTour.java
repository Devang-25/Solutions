package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class LitteJhoolAndWorldTour {
	private static Range[] ranges = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int N = in.nextInt();
			int M = in.nextInt();
			ranges = new Range[M];
			for (int i = 0; i < M; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				ranges[i] = new Range(x, y, N);
			}
			TreeSet<Integer> set = new TreeSet<Integer>();
			if (pickIterative(0, set)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean pick(int range, TreeSet<Integer> set) {

		if (range == ranges.length) {
			return true;
		}
		int i = ranges[range].x;
		int max = (ranges[range].x > ranges[range].y) ? ranges[range].N - 1
				: ranges[range].y;
		while (i <= max) {
			if (!set.contains(i)) {
				set.add(i);
				if (!pick(range + 1, set)) {
					set.remove(i);
				} else {
					return true;
				}
			}
			i++;
			if (ranges[range].y != ranges[range].N - 1 && i == ranges[range].N) {
				i = 0;
				max = ranges[range].y;
			}
		}
		return false;
	}

	private static boolean pickIterative(int range, TreeSet<Integer> set) {
		int at = 0;
		TreeSet<Integer> occupied = new TreeSet<Integer>();
		List<Integer> lastAdded = new ArrayList<Integer>();
		int last = -1;
		while (at != ranges.length && at != -1) {
			Range r = ranges[at];
			if (((r.x <= r.y && r.i <= r.y) || (r.x > r.y && r.i < r.max))) {
				if (!occupied.contains(r.i)) {
					occupied.add(r.i);
					lastAdded.add(r.i);
					at++;
				}
				r.i++;
				if (r.x > r.y && r.i == r.max && r.max == r.N) {
					r.i = 0;
					r.max = r.y + 1;
				}
			} else {
				if (!lastAdded.isEmpty()) {
					int l = lastAdded.remove(lastAdded.size() - 1);
					if (l == last) {
						break;
					}
					last = l;
					occupied.remove(l);
				}
				r.i = r.x;
				if (r.x > r.y) {
					r.max = r.N;
				}
				at--;
			}
		}
		if (at == ranges.length) {
			return true;
		}
		return false;

	}

	static class Range {
		final int x;
		final int y;
		int N;
		int i = 0;
		int max;

		Range(int x, int y, int N) {
			this.x = x;
			this.y = y;
			this.N = N;
			i = x;
			max = (x < y) ? y + 1 : N;
		}

		public String toString() {
			return "[" + this.x + "," + this.y + "]";
		}

	}
}
