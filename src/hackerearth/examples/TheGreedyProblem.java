package hackerearth.examples;

import java.util.Scanner;

public class TheGreedyProblem {
	private static Long cache[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int cell[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					cell[i][j] = in.nextInt();
				}
			}
			cache = new Long[n][m];
			long max = Long.MIN_VALUE;
			for (int i = 0; i < m; i++) {
				max = Math.max(max, max(cell, 0, i));
			}
			System.out.println(max);
		}
	}

	private static long max(int[][] cell, int i, int j) {
		if(i==cell.length|| j==-1 || j==cell[0].length){
			return 0;
		}
		if(cache[i][j]!=null){
			return cache[i][j];
		}
		long max=max(cell, i+1, j);
		max=Math.max(max, max(cell, i+1, j-1));
		max=Math.max(max, max(cell, i+1, j+1));
		cache[i][j]=new Long(max+cell[i][j]);
		return max+cell[i][j];
		
	}
}
