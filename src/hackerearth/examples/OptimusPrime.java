package hackerearth.examples;

import java.math.BigInteger;

public class OptimusPrime {
	static boolean[] primes = null;

	public static void main(String argsp[]) {
		BigInteger b=new BigInteger("100000000001");
		System.out.println(b.isProbablePrime(5));
	}

	/*public static void fillSieve() {
		Arrays.fill(primes, true); // assume all integers are prime.
		primes[0] = primes[1] = false; // we know 0 and 1 are not prime.
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (int j = 2; i * j < primes.length; j++) {
					primes[i * j] = false;
				}
			}
		}
	}

	public static boolean isPrime(int n) {
		return primes[n];
	}*/
}
