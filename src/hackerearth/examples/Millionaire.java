package hackerearth.examples;

import java.util.Scanner;

public class Millionaire {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		for (int i = 0; i < testCases; i++) {
			double  n=in.nextInt();
			System.out.format("%f%n",(n-1)/n);
		}
	}
}
