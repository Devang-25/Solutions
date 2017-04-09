package hackerrank;

import java.util.Scanner;

public class PlayWithWords {

	private static int[][] cache;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] s = in.next().toCharArray();
		cache = new int[s.length+1][s.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length-1; i++) {
			int prod = getLPSProd(s, 0, i) * getLPSProd(s, i + 1, s.length - 1);
			if (prod > max) {
				max = prod;
			}
		}
		System.out.println(max);
	}

	private static int getLPSProd(char[] s, int i, int j) {
		String str=new String(s, i, j-i+1);
		System.out.println("["+str+"]");
		if (i == j) {
			return 1;
		}
		if (i + 1 == j) {
			if (s[i] == s[j]) {
				return 2;
			}
			return 1;
		}
		if (cache[i][j] > 0) {
			//System.out.println("Cached");
			return cache[i][j];
		}
		if (s[i] == s[j]) {
			return 2+getLPSProd(s, i + 1, j - 1);
		}
		int a = getLPSProd(s, i + 1, j);
		int b = getLPSProd(s, i, j - 1);
		int m = Math.max(a, b);
		System.out.println(m);
		cache[i][j] = m;
		return m;
	}
}
