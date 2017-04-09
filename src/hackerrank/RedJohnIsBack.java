package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class RedJohnIsBack {
	private static boolean primes[] = new boolean[41];
	private static int primesC[] = new int[41];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		fillSieve();
		int tst = in.nextInt();
		for (int t = 1; t <= tst; t++) {
			int N = in.nextInt();
			if (N < 3) {
				System.out.println(0);
			} else {
				int M = getWays(41);
				System.out.println(primesC[M+1]);
			}
		}
	}

	private static int getWays(int n) {
		int k=n/4;
		int sum=0;
		sum+=(n-4+1);
		for(int i=2;i<=k;i++){
			sum+=(n+1-4*i)*i;
		}
		return sum;
	}

	// set up the prime sieve
	public static void fillSieve() {
		Arrays.fill(primes, true); // assume all integers are prime.
		primes[0] = primes[1] = false; // we know 0 and 1 are not prime.
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (int j = 2; i * j < primes.length; j++) {
					primes[i * j] = false;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				sum++;
			}
			primesC[i] = sum;
		}
	}
}
