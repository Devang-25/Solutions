package hackerearth.examples;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class FareyNumbers {
	public int gcd(int divisor, int dividend) {
		int remainder = dividend % divisor;
		if (remainder == 0) {
			return divisor;
		}
		return gcd(remainder, divisor);
	}

	public int getGCD(int a, int b) {
		if (a == b) {
			return a;
		}
		if (a > b) {
			return gcd(b, a);
		}
		return gcd(a, b);
	}

	/* phi() gives us the coprimes of n. */
	public int phi(int n) {
		int coPrimes = 1;
		for (int i = 2; i < n; i++) {
			if (gcd(i, n) == 1) {
				coPrimes++;
			}
		}
		return coPrimes;
	}

	public List<Integer> getCoPrimes(int n) {
		List<Integer> coPrimes = new LinkedList<>();
		coPrimes.add(1);
		for (int i = 2; i < n; i++) {
			if (gcd(i, n) == 1) {
				coPrimes.add(i);
			}
		}
		return coPrimes;
	}

	class Fraction {
		public final double val;
		public final String rep;

		Fraction(int num, int deno) {
			val = ((double) num) / deno;
			rep = num + "/" + deno;
		}

		@Override
		public String toString() {
			return this.rep;
		}
	}

	public void generateFareySeries(int n) {
		TreeSet<Fraction> series = new TreeSet<>(new Comparator<Fraction>() {

			@Override
			public int compare(Fraction f1, Fraction f2) {
				return (f1.val - f2.val) < 0 ? -1 : 1;
			}

		});
		series.add(new Fraction(0, 1));
		series.add(new Fraction(1, 1));
		for (int i = 2; i <= n; i++) {
			List<Integer> coPrimes = getCoPrimes(i);
			//System.out.println(coPrimes);
			for (Integer p : coPrimes) {
				series.add(new Fraction(p, i));
			}
		}
		System.out.println(series);
	}

	public static void main(String args[]) {
		int a = 100;
		int b = 30;
		// System.out.println(new FareyNumbers().phi(10));
		new FareyNumbers().generateFareySeries(1000);
	}
}
