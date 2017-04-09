package hackerearth.examples;

import java.util.Scanner;
//to be continued..
public class AndrewAndWengaluruCity {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int N = in.nextInt();
			int h[] = new int[N];
			for (int i = 0; i < h.length; i++) {
				h[i] = in.nextInt();
			}
			java.util.Stack<Integer> s = new java.util.Stack<Integer>();
			int i = 0;
			int prev = Integer.MAX_VALUE;
			int level = 0;
			long water = 0;
			while (i < h.length) {
				if (h[i] <= prev) {
					level = 0;
					s.push(i);
				} else {
					while (!s.isEmpty()
							&& h[i] >= s.peek()) {
						int top = s.peek();
						water += (i - top - 1) * (h[top] - level);
						level = h[top];
						s.pop();
					}
					if (!s.isEmpty()) {
						water += (i - s.peek() - 1)
								* (h[i] - level);
						level = h[s.peek()];
					}
				}
				prev = h[i];
				i++;
			}
			System.out.println(water);
		}
	}
}
