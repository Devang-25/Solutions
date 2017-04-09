package hackerearth.examples;

import java.util.Scanner;
import java.util.TreeSet;

public class FibonacciNumbers2 {
	static long[] cache = new long[1000];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int no = in.nextInt();
			long min = Long.MAX_VALUE;
			int f = 0;
			TreeSet<Long> factors = primeFactors(no);
			for (long factor : factors) {
				long fib = smallestFibonacci(factor);
				if (min > fib) {
					min = fib;
					f = (int) factor;
				}
			}
			System.out.println(min + " " + ((min==-1)?-1:f));
		}
	}

	static Long smallestFibonacci(long factor) {
		long a = 1;
		long b = 2;
		if(factor==2){
			return 2l;
		}
		long max = (long) Math.pow(10, 18);
		while (b < max) {
			long sum = a + b;
			a = b;
			b = sum;
			if (b % factor == 0) {
				return b;
			}
		}
		return -1l;
	}

	static TreeSet<Long> primeFactors(long n) {
		TreeSet<Long> set = new TreeSet<Long>();
		if (n % 2 == 0) {
			set.add(2L);
		}
		while (n % 2 == 0) { 
			n = n / 2;
		}

		for (long i = 3; i <= Math.sqrt(n); i = i + 2) {
			// While i divides n, print i and divide n
			while (n % i == 0) {
				set.add(i);
				n = n / i;
			}
		}

		// This condition is to handle the case whien n is a prime number
		// greater than 2
		if (n > 2) {
			set.add(n);
		}
		return set;
	}

}
