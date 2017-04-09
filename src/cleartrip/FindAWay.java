package cleartrip;

import java.util.Scanner;

public class FindAWay {
	private static boolean table[][];

	public static void main(String[] args) {
		table = new boolean[5][5];
		Scanner in = new Scanner(System.in);
		int paths[][] = new int[5][2];
		for (int i = 0; i < 5; i++) {
			paths[i][0] = in.nextInt();
			int c[] = getCordinates(paths[i][0]);
			table[c[0]][c[1]] = true;
			paths[i][1] = in.nextInt();
			c = getCordinates(paths[i][0]);
			table[c[0]][c[1]] = true;
		}
		process(paths, paths[0][0], paths[0][1], 0);
	}

	private static boolean process(int[][] paths, int i, int j, int pathId) {
		if (j == 5 || !table[i][j + 1]) {
			return false;
		}
		table[i][j]=true;
		//go left.
		if (!process(paths, i, j + 1, pathId)) {
			//go down
			if(!process(paths, i+1, j, pathId)){
				//fails
			}
		}
        //just return false so that intellij doesnt complain.
		return false;
	}

	static int[] getCordinates(int no) {
		int row = no / 5;
		int col = no % 5 - 1;
		return new int[] { row, col };
	}
}
