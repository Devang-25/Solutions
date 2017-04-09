package hackerearth.examples;

import java.util.Scanner;

public class ChocolateDestribution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			long N=in.nextLong();
			long M=in.nextLong();
			long S=in.nextLong();
			long no=S+M%N-1;
			System.out.println(no%N);
		}
	}
}
