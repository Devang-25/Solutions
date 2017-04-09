package hackerrank;

import java.util.Scanner;

public class SherlockAndMiniMax {
	private static int answer = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int arr[] = new int[109];
		for (int i = 0; i < n; i++) {
			int v = in.nextInt();
			arr[i] = v;
		}
		System.out.println(min + ";" + max);
		int A = in.nextInt();
		int B = in.nextInt();
		limits(A, A, B, arr);
		limits(B, A, B, arr);

		for (int i = 0; i < n; ++i)
			for (int j = i + 1; j < n; ++j) {
				limits((arr[i] + arr[j]) / 2, A, B, arr);
			}

		System.out.println(answer);
	}

	static int check(int x, int arr[]) {
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; ++i)
			ret = Math.min(ret, Math.abs(x - arr[i]));
		return ret;
	}

	static void limits(int x, int A, int B, int arr[]) {
		if (x < A || x > B)
			return;
		if (check(x, arr) > check(answer, arr))
			answer = x;
	}
}
