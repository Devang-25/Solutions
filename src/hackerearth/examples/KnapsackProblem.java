package hackerearth.examples;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

/*The algorithm is correct, but the recursive version is not scalable enough.
 * I failed with the iterative one.
 * */
public class KnapsackProblem {
	private static long[] cost = null;
	static ArrayList<Integer> one;
	static ArrayList<Integer> two;

	public static void main(String[] args) {
		ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		// System.out.println(N);
		one = new ArrayList<>();
		two = new ArrayList<>();
		int m = 0;
		for (int n = 1; n <= N; n++) {
			int w = // (int) (Math.random() * 2 + 1);
			in.nextInt();
			// System.out.println(w);
			int c = // (int) (Math.random() * Integer.MAX_VALUE);
			in.nextInt();
			// System.out.println(c);
			if (w == 1) {
				one.add(c);
			} else {
				two.add(c);
			}
			m += w;
		}
		cost = new long[m + 1];
		Collections.sort(one);
		Collections.reverse(one);
		Collections.sort(two);
		Collections.reverse(two);
		// long a =
		costI(m);
		System.out.println(cost[m]);
		for (int i = 1; i < cost.length - 1; i++) {
			System.out.print(cost[i] + " ");
		}
		System.out.println(cost[cost.length - 1]);

	}

	private static long cost(int m) {
		if (m == 0) {
			return 0;
		}
		if (cost[m] != 0) {
			return cost[m];
		}
		if (one.isEmpty()) {
			int s = m % 2 == 0 ? 2 : 3;
			int a = 0;
			for (int i = s; i <= m; i += 2) {
				cost[i] = cost[i - 2] + two.get(a);
				a++;
			}
			assert two.isEmpty();
			return cost[m];
		} else if (two.isEmpty()) {
			System.out.println(m + "::" + one);
			cost[m] = one.get(0);
			return cost[m];
		}
		// System.out.println(m-1+": one B "+one);
		int last = one.remove(one.size() - 1);
		long costA = last + cost(m - 1);
		one.add(last);
		// System.out.println(m-2+": two B "+two);
		last = two.remove(two.size() - 1);
		long costB = last + cost(m - 2);
		two.add(last);
		long costM = Math.max(costA, costB);
		cost[m] = costM;
		return costM;
	}

	private static void costI(int m) {
		Deque<Integer> stack = new ArrayDeque<>();
		Deque<Integer> stackOne = new ArrayDeque<>();
		stack.push(m);
		int costA = 0;
		while (!stack.isEmpty()) {
			if (cost[m] != 0) {
				m = stack.pop();
				costA=0;
				continue;
			}
			if (two.isEmpty()) {
				cost[1] = one.get(0);
				m = stack.pop();
				costA=0;
				continue;
			}
			if (one.isEmpty()) {
				cost[m]=costA;
				int s = m % 2 == 0 ? 2 : 3;
				int a = 0;
				long costT = cost[m];
				for (int i = s; i <= m; i += 2) {
					cost[i] = cost[i - 2] + two.get(a);
					a++;
				}
				if (costT > cost[m]) {
					cost[m] = costT;
				}
				one.add(stackOne.pop());
				m = stack.pop();
				costA=0;
				continue;
			}

			// System.out.println(m-1+": one B "+one);
			int last = one.remove(one.size() - 1);
			stackOne.push(last);
			stack.push(m - 2);
			costA += last;
			m = m - 1;
		}
	}
}
