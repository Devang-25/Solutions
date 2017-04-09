package hackerearth.examples;

import java.util.Scanner;

public class SymetrixPoint {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int px = in.nextInt();
			int py = in.nextInt();
			int qx = in.nextInt();
			int qy = in.nextInt();
			int x=2*qx-px;
			int y=2*qy-py;
			System.out.println(x+" "+y);
		}
	}
}
