package hackerearth.examples;

import java.util.Arrays;

public class PrimeGen {
	public static void main(String args[]) {
		primes = new boolean[1000000];
		fillSieve2();
		
	}
	

	static boolean[] primes = null;
	public static void fillSieve2(){
		int count=0;
		Arrays.fill(primes, true); // assume all integers are prime.
		primes[0] = primes[1] = false; // we know 0 and 1 are not prime.
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				count++;
				if(count==10001){
					System.out.println(i);
					break;
				}
				for (int j = 2; i * j < primes.length; j++) {
					primes[i * j] = false;
				}
			}
		}
	}
	// set up the primesieve
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
	}

	public static boolean isPrime(int n) {
		return primes[n];
	}
}
