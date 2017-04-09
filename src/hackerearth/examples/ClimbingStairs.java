package hackerearth.examples;

import java.util.Scanner;

public class ClimbingStairs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		long N = in.nextLong();
		int days=(int) Math.ceil(((double)(N - B)) / (A - B));
		
		System.out.println(days);

	}
}
