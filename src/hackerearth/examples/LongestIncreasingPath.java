package hackerearth.examples;

import java.util.Scanner;

public class LongestIncreasingPath {
	private static int maxLength = 0;
	private static int array[][] = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			maxLength = 0;
			int N = in.nextInt();
			int M = in.nextInt();
			array = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					array[i][j] = in.nextInt();
				}
			}
			solve(0, 0, 1);
			System.out.println(maxLength);
		}
	}

	private static void solve(int i, int j, int len) {
		if (i == array.length - 1 && j == array[0].length - 1) {
			if (len > maxLength) {
				maxLength = len;
			}
			return;
		}
		boolean deadEnd=true;
		if (i + 1 != array.length && array[i + 1][j] > array[i][j]) {
			deadEnd=false;
			solve(i + 1, j, len + 1);
		}
		if (j + 1 != array[0].length && array[i][j + 1] > array[i][j]) {
			deadEnd=false;
			solve(i, j + 1, len + 1);
			return;
		}
		if(deadEnd){
			if (len > maxLength) {
				maxLength = len;
			}
		}
	}
}
