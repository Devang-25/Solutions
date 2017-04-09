package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;

public class GandhiTreeMarch {
	static int index = 0;

	public static void main(String[] args) {
		// String
		// s="a(b(d(j(t(..)k(..)).)e(f(.g(h(.i(..)).)).))c(m(.n(o(.r(s(..).))p(..)))l(.q(..))))";
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			index = 0;
			int colNo = in.nextInt();
			char[] tree = in.next().toCharArray();
			String[] negativeMap = new String[10000];
			String[] positiveMap = new String[10000];
			int count[] = new int[26];
			fillMap(tree, 0, negativeMap, positiveMap, count);
			String group = "";
			if (colNo < 0) {
				colNo = colNo * -1;
				group = negativeMap[colNo];
			} else {
				group = positiveMap[colNo];
			}
			// System.out.println(group);
			display(group);
		}
	}

	private static void display(String group) {
		if (group == null) {
			System.out.println("Common Gandhijee!");
		} else {
			char[] chars = group.toCharArray();
			Arrays.sort(chars);
			System.out.println(new String(chars));
		}
	}

	private static void fillMap(char[] tree, int col, String[] nMap,
			String[] pMap, int count[]) {
		if (tree[index] == '.') {
			index++;
			return;
		}
		int charPos = tree[index] - 97;
		count[charPos]++;
		// System.out.println(tree[index] + " :" + charPos+" ; col "+col);
		if (col >= 0) {
			if (pMap[col] == null) {
				pMap[col] = "";
			}
			pMap[col] = pMap[col] + tree[index];
		} else {
			int absCol = col * -1;
			if (nMap[absCol] == null) {
				nMap[absCol] = "";
			}
			nMap[absCol] = nMap[absCol] + tree[index];
		}
		index += 2;
		fillMap(tree, col - 1, nMap, pMap, count);
		fillMap(tree, col + 1, nMap, pMap, count);
		index++;
	}
}
