package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Flowers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int flowers[] = new int[N];
		for (int i = 0; i < flowers.length; i++) {
			flowers[i] = in.nextInt();
		}
		Arrays.sort(flowers);
		int cost = 0;
		int f = 1;
		int g = 0;
		for (int i = flowers.length - 1; i >= 0; i--) {
			cost += f * flowers[i];
			g++;
			if (g == K) {
				g = 0;
				f++;
			}
		}
		System.out.println(cost);
	}
}
