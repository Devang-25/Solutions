package hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import datastructures.lists.Algorithms;

public class BricksGameIncorrect {
	private static int bestScore[];
	private static int sum[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			bestScore = new int[n + 1];
			sum = new int[n];
			for (int i = arr.length - 1; i >= 0; i--) {
				arr[i] = in.nextInt();
			}
			sum[arr.length-1] = arr[arr.length - 1];
			for (int i = arr.length - 2; i >= 0; i--) {
				sum[i] = sum[i + 1] + arr[i];
			}
			int score = score(0, arr);
			System.out.println(score);
		}
	}

	private static int score(int n, int[] arr) {
		System.out.println("score(" + n + ")");
		if (arr.length - n <= 3) {
			System.out.println("RET");
			return 0;
		}
		if (n == arr.length - 1) {
			return arr[n];
		}
		if (bestScore[n] != 0) {
			return bestScore[n];
		}
		int a = -1 * score(n + 1, arr) + arr[n] + sum[n + 1];
		int b = -1 * score(n + 2, arr) + arr[n] + arr[n + 1] + sum[n + 2];
		int c = -1 * score(n + 3, arr) + arr[n + 1] + arr[n] + arr[n + 2]
				+ sum[n + 3];
		int m = Math.max(Math.max(a, b), c);
		System.out.println(m);
		return m;

	}

}
