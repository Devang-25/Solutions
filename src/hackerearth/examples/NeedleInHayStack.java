package hackerearth.examples;

import java.util.Scanner;

public class NeedleInHayStack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 0; t < testCases; t++) {
			char[] charPattern = in.next().toCharArray();
			char[] textChars = in.next().toCharArray();
			int map[][] = new int[26][2];
			for (char c : charPattern) {
				map[c - 97][0]++;
				map[c - 97][1]++;
			}
			int i = 0;
			while (i <= textChars.length - charPattern.length) {
				System.out.println(textChars[i]);
				int index = textChars[i] - 97;
				System.out.println(map[index][0]);
				if (map[index][0] != 0) {
					int at = find(textChars, i, charPattern.length - 1, map);
					if (at == 0) {
						System.out.println("YES");
						break;
					}
					i = at;
				} else {
					i++;
				}

			}
			if (i > textChars.length - charPattern.length) {
				System.out.println("NO");
			}
		}
	}

	private static int find(char[] text, int i, int to, int[][] map) {
		System.out.println(i + " to " + (i + to));
		for (int j = i; j <=i + to; j++) {
			int index = text[j] - 97;
			if (map[index][0] == 0) {
				resetMap(map);
				return j + 1;
			}
			if (map[index][1] == 0) {
				resetMap(map);
				return i + 1;
			}
			map[index][1]--;
		}
		return 0;
		/*
		 * boolean consumed=true; for(int m=0;m<map.length;m++){
		 * if(map[m][1]!=0){ consumed=false; } } if(consumed){ return 0; }
		 * return
		 */
	}

	private static void resetMap(int[][] map) {
		for (int m = 0; m < map.length; m++) {
			map[m][1] = map[m][0];
		}
	}
}
