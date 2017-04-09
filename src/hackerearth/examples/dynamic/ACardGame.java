package hackerearth.examples.dynamic;

import java.util.Scanner;

public class ACardGame {
	private static int arr[];
	private static long power[] = new long[100000 + 1];

	public static void main(String[] args) {
		power[0] = 1;
		for (int i = 1; i < power.length; i++) {
			power[i] = (2 * power[i - 1]) % 1000000007;
		}
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			arr = new int[n+1];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}
			long sum = sum(arr[0], arr[0], 1);
			System.out.println(sum);
		}
	}

	private static long sum(int l, int r, int i) {
		if (i == arr.length) {
			return 0L;
		}
		long s = (arr[i] * (l + r))%1000000007L;
		long val = (s * power[arr.length - i - 1]) % 1000000007L;
		return (val + sum(arr[i], r, i + 1) + sum(l, arr[i], i + 1))% 1000000007L;
	}
}
