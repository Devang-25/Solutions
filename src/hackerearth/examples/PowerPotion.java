package hackerearth.examples;

import java.util.Scanner;

public class PowerPotion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int a[] = new int[in.nextInt()];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
			if (a.length == 1) {
				System.out.println(1);
			} else {
				permute(a, 0, 0);
				System.out.println(count);
				count = 0;
			}
		}
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int count = 0;

	static void permute(int[] a, int i, int power) {
		if (i == a.length) {
			// solutions is ready here..since we reached last..
			// draco's turn will come here...he can pick any ingredient and
			// cancel its power.
			for (int m = 0; m < a.length; m++) {
				if (power % a[m] == 0) {
					return;
				}
			}
			count++;
		} else {
			for (int j = i; j < a.length; j++) {
				swap(a, i, j);
				boolean fail = false;
				if (i != 0) {
					for (int m = i; m < a.length; m++) {
						if (power % a[m] == 0) {
							swap(a, i, j);
							fail = true;
						}
					}
				}
				if (!fail) {
					permute(a, i + 1, i == 0 ? a[i] : a[i] + a[i - 1]);
					swap(a, i, j);// backtrack
				}
			}
		}
	}
}
