package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheGridSearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int R = in.nextInt();
			int C = in.nextInt();
			String base[] = new String[R];
			for (int i = 0; i < R; i++) {
				base[i] = in.next();
			}
			int r = in.nextInt();
			int c = in.nextInt();
			String pattern[] = new String[r];
			for (int i = 0; i < r; i++) {
				pattern[i] = in.next();
			}
			int i = 0;
			boolean found = false;
			while (i <= R - r) {
				int j = 0;
				for (int col : index(base[i], pattern[j])) {
					int k = i + 1;
					j++;
					while (j<pattern.length && base[k].substring(col).startsWith(pattern[j])) {
						j++;k++;
					}
					if (j == pattern.length) {
						found = true;
						break;
					}
				}
				if (found) {
					break;
				}
				i++;
			}
			if (found) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static Integer[] index(String base, String pattern) {
		List<Integer> a = new ArrayList<Integer>();
		String temp = base;
		int i = 0;
		while ((i = temp.indexOf(pattern)) != -1) {
			a.add(i);
			temp = temp.substring(i + pattern.length());
		}
		return a.toArray(new Integer[a.size()]);
	}
}
