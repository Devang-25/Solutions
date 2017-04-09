package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class TheArtOfSecurity {
	static int count = 0, entrance1Pow, entrance2Pow;

	private static void arrangement(Integer creaturePower[], int cI) {
		if (cI == creaturePower.length) {
			count++;
			return;
		}

		if (entrance1Pow + creaturePower[cI] <= entrance2Pow) {
			entrance1Pow += creaturePower[cI];
			arrangement(creaturePower, cI + 1);
			entrance1Pow -= creaturePower[cI];
		}
		entrance2Pow += creaturePower[cI];
		arrangement(creaturePower, cI + 1);
		entrance2Pow -= creaturePower[cI];
	}

	private static int sum = 0;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int N = in.nextInt();
		Integer creaturePower[] = new Integer[N];

		for (int i = 0; i < N; i++) {
			creaturePower[i] = in.nextInt();
			sum += creaturePower[i];
		}
		Arrays.sort(creaturePower);
		permute(creaturePower, 0, creaturePower.length - 1);
		System.out.println(count + " " + sum);
		if (count > sum) {
			System.out.println("We will win!");
		} else {
			System.out.println("Got no way out!");
		}
	}

	static private void swap(Integer a[], int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	static void permute(Integer a[], int l, int r) {
		int i;
		if (l == r) {
			// for this particular permutation.
			//System.out.println(Arrays.asList(a));
			arrangement(a, 0);
		}

		else {
			for (i = l; i <= r; i++) {
				swap(a, l, i);
				permute(a, l + 1, r);
				swap(a, l, i);
			}
		}
	}

}
