package hackerearth.examples;

import java.util.Scanner;

public class HighSchoolmathematics {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		for(int i=1;i<=testCases;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int x = a - 1;
			int y = b - 1;
			int sol = 0;
			if (x != 0 && y != 0) {
				sol++;
			}
			x = a + 1;
			y = b + 1;
			if (x != 0 && y != 0) {
				sol++;
			}
			System.out.println(sol);
		}
		

	}
}
