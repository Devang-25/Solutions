package hackerearth.examples;

import java.util.Scanner;

public class TriangleInEquality {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if(a==0 ||b==0||c==0){
				System.out.println(0);
			}
			if (a + b > c && b + c > a && c + a > b) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
