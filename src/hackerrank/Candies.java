package hackerrank;

import java.util.Scanner;

public class Candies {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int ratings[] = new int[N];
		for (int i = 0; i < ratings.length; i++) {
			ratings[i] = in.nextInt();
		}
		int candies[] = new int[ratings.length];
		for (int i = 0; i < candies.length; i++) {
			candies[i] = 1;
		}
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candies[i]=candies[i-1]+1;
			}
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			}
		}
		int candeez = 0;
		for (int i = 0; i < candies.length; i++) {
			candeez += candies[i];
		}
		System.out.println(candeez);
	}
}
