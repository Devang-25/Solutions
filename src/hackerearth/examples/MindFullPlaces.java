package hackerearth.examples;

import java.util.Scanner;

public class MindFullPlaces {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int rows=in.nextInt();
		int columns=in.nextInt();
		long matrix[][]=new long[rows][columns];
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				matrix[i][j]=in.nextLong();
			}
		}
		int queries=in.nextInt();
		for(int q=1;q<=queries;q++){
			long val=in.nextLong();
			search(matrix,val);
		}
	}

	static int search(long mat[][], long val) {
		int i = 0, j = mat[0].length-1;
		while (i < mat.length && j >= 0) {
			if (mat[i][j] == val) {
				System.out.println(i + " " + j);
				return 1;
			}
			if (mat[i][j] > val) {
				j--;
			} else {
				i++;
			}
		}

		System.out.println("-1 -1");
		return 0;
	}
}