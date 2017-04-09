package hackerearth.examples;

import java.util.Scanner;

public class Speed {
	public static void main(String args[]) {
		//long speed[] = { 414, 84, 42, 38, 78, 14, 2, 17, 85, 16 };
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			long count = 1;
			int cars = in.nextInt();
			long fSpeed = in.nextLong();
			for (int j = 1; j < cars; j++) {
				long speedC = in.nextLong();
				if (speedC <= fSpeed) {
					count++;
					fSpeed = speedC;
				}
			}
			//System.out.println(fSpeed);
			System.out.println(count);
		}

	}
}
