package hackerearth.examples;

import java.util.Scanner;

public class AldrinJustice {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int bt1 = 0;
			int bt2 = 0;
			int a = in.nextInt();
			int b = in.nextInt();
			if (a <= b) {
				bt1 = a;
				bt2 = b;
			} else {
				bt1 = b;
				bt2 = a;
			}

			int mt1 = 0;
			int mt2 = 0;
			a = in.nextInt();
			b = in.nextInt();
			if (a <= b) {
				mt1 = a;
				mt2 = b;
			} else {
				mt1 = b;
				mt2 = a;
			}

			if (mt2 < bt1) {
				System.out.println("Line");
			} else if (mt2 == bt1) {
				if (mt1 == mt2) {
					System.out.println("Nothing");
				} else {
					System.out.println("Point");
				}
			} else if (mt2 <= bt2) {
				if (bt1 == bt2 && mt2 == bt2) {
					System.out.println("Point");
				} else {
					System.out.println("Nothing");
				}
			} else if (mt1 == bt2) {
				System.out.println("Point");
			} else {
				System.out.println("Line");
			}
		}
	}
}
