package test2;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			String text = in.next();
			int costA = in.nextInt();
			int costB = in.nextInt();
			int minCost = getMinCost(text, costA, costB);
			if (minCost == -1) {
				System.out.println(-1);
			} else {
				System.out.println(minCost);
			}
		}
	}

	private static int getMinCost(String text, int costA, int costB) {
		char c[] = text.toCharArray();
		int s = 0;
		int e = c.length - 1;
		int cost = 0;
		while (s < e) {
			int thisCost=0;
			//System.out.println(c[s]+","+c[e]);
			if ((c[s] == '/' && c[e] == 'a') || (c[s] == 'a' && c[e] == '/')) {
				thisCost= costA;
			} else if ((c[s] == '/' && c[e] == 'b')
					|| (c[s] == 'b' && c[e] == '/')) {
				thisCost= costB;
			} else if (c[s] == '/' && c[e] == '/') {
				thisCost= 2*Math.min(costA, costB);
			} else if (c[s] != c[e]) {
				return -1;
			}
			//System.out.println(c[s]+","+c[e]+"="+thisCost);
			cost+=thisCost;
			s++;
			e--;
		}
		return cost;
	}
}
