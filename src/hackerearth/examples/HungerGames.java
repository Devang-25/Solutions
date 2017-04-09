package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class HungerGames {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int N = in.nextInt();
		int hungers[] = new int[N];
		for (int i = 0; i < N; i++) {
			int v = in.nextInt();
			hungers[i] = v;
		}
		Arrays.sort(hungers);
		int spread[] = new int[N];
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				spread[i / 2] = hungers[i];
			else
				spread[N - (i / 2) - 1] = hungers[i];
		}
		int max = Math.abs(spread[N - 1] - spread[0]);
		int cur;
		for (int i = 1; i < N; i++) {
			cur = Math.abs(spread[i] - spread[i - 1]);
			if (max < cur)
				max = cur;
		}
		System.out.println(max);
	}
}
