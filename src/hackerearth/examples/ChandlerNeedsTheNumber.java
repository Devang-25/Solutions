package hackerearth.examples;

import java.util.Scanner;

public class ChandlerNeedsTheNumber {
	public static void main2(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long lcm = lcm(in.nextInt(), in.nextInt());
		for (int i = 0; i < n - 2; i++) {
			lcm = lcm(in.nextInt(), lcm);
		}
		System.out.println(lcm);

	}

	public static void main(String[] args) {
		int n = 1000000;
		long a = (long) (Math.random() * 100000);
		long b = (long) (Math.random() * 100000);
		long lcm = lcm(a, b);
		for (int i = 0; i < n - 2; i++) {
			long c=(long) (Math.random() * 100000);
			System.out.println(c);
			lcm = lcm(c, lcm);
			System.out.println(lcm);
		}
		System.out.println(lcm);

	}

	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}

	static long gcd(long m, long n) {
		while (m != n) {
			if (m > n)

			{
				m = m - n;
			}

			else {
				n = n - m;
			}
		}

		return m;
	}
}
