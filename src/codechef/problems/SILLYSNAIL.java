package codechef.problems;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class SILLYSNAIL {

	private static int table[][] = null;
private static StringBuilder b=null;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			table = new int[100001][2];
			b=new StringBuilder();
			int rel = in.nextInt();
			for (int i = 1; i <= rel; i++) {
				int root = in.nextInt();
				table[root][0] = in.nextInt();
				table[root][1] = in.nextInt();
			}
			print2(table);
			System.out.println(b.toString());
		}
	}

	private static void print(int[][] table, int i) {
		if (i == 0) {
			return;
		}
		System.out.print(i + " ");
		print(table, table[i][0]);
		print(table, table[i][1]);
	}

	private static void print2(int[][] table) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		while (!s.isEmpty()) {
			int i = s.pop();
			while (i != 0) {
				b.append(i + " ");
				if (table[i][1] != 0) {
					s.push(table[i][1]);
				}
				i = table[i][0];
			}
		}
	}
}
