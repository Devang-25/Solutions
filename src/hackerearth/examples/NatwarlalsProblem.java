package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NatwarlalsProblem {
	private static int count = 0;
	private static String sequence;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			List<Integer[]> firstCharPos = new ArrayList<Integer[]>();
			char matrix[][] = new char[n][n];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[i][j] = in.next().toCharArray()[0];
				}
			}
			sequence = in.next();
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					if (matrix[i][j] == sequence.charAt(0)) {
						firstCharPos.add(new Integer[] { i, j });
					}
				}
			}
			count = 0;
			for (Integer pos[] : firstCharPos) {
				//System.out.println("------------------------------");
				//System.out.println(pos[0]+","+pos[1]);
				count(matrix, pos[0], pos[1], 0);
			}
			System.out.println(count);
		}
	}

	private static void count(char[][] matrix, Integer i, Integer j, int seqI) {
		if (i == -1 || i == matrix.length || j == -1 || j == matrix.length) {
			return;
		}
		if (sequence.charAt(seqI) == matrix[i][j]) {
			//System.out.print("("+i+";"+j+")");
			if(seqI+1 == sequence.length()){
				count++;
				//System.out.println("HIT");
				return;
			}
			count(matrix, i - 1, j + 1, seqI + 1);
			count(matrix, i + 1, j + 1, seqI + 1);
			count(matrix, i + 1, j - 1, seqI + 1);
			count(matrix, i - 1, j - 1, seqI + 1);
		}
	}
}
