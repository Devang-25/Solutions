package hackerearth.examples;

import java.util.Scanner;

public class FindTheArrangement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int a = in.nextInt();
		int finalT[] = new int[p + 1];
		int small = Integer.MAX_VALUE;
		int x = 0;
		for (int i = 1; i <= p; i++) {
			finalT[i] = in.nextInt();
			if (small > finalT[i]) {
				small = finalT[i];
				x = i;
			}
		}
		int n = 0;
		if (x > a) {
			n = small;
		} else {
			n = small-1;
		}
		//System.out.println(n);
		int tBalls = n *p +p + a - x;
		System.out.println(tBalls);
		for (int i = 1; i < finalT.length; i++) {
			if (i == x) {
				System.out.print(tBalls + " ");
			} else if (i <= a) {
				if (i < x) {
					System.out.print((finalT[i] - n - 1) + " ");
				} else if (i > x) {
					System.out.print((finalT[i] - n - 2) + " ");
				}
			} else {
				if (i < x) {
					System.out.print((finalT[i] - n) + " ");
				} else if (i > x) {
					System.out.print((finalT[i] - n - 1) + " ");
				}
			}
		}
	}
}
