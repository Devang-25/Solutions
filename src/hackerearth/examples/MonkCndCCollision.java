package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MonkCndCCollision {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int testCases = in.nextInt();
		for (int t = 0; t < testCases; t++) {
			int N = in.nextInt();
			boolean hash[] = new boolean[10];
			int collision = 0;
			for (int i = 1; i <= N; i++) {
				int rem = in.nextInt() % 10;
				if (hash[rem]) {
					collision++;
				} else {
					hash[rem] = true;
				}
			}
			System.out.println(collision);
		}
	}
}
