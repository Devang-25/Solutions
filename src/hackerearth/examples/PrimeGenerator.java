package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {

	public List<Integer> GgetPrimes(int minNumbers, int maxNumbers) {
		List<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
		int operations = 0;
		for (int number = minNumbers; number <= ((maxNumbers % 2 != 0) ? maxNumbers
				: maxNumbers - 1); number += 2) {
			System.out.println("checking  prime :" + number);
			boolean isPrime = true;
			for (int p = 1; p < primes.size(); p++) {
				// System.out.println(primes);
				if (primes.get(p) <= Math.floor(number / primes.get(p - 1))) {
					operations++;
					System.out.println("\t\t dividing by :" + primes.get(p));
					if (number % primes.get(p) == 0) {
						isPrime = false;
						break;
					}
				}
			}
			if (isPrime) {
				primes.add(number);
			}
		}
		System.out.println("Operations= " + operations);
		System.out.println(primes.size());
		System.out.println(primes);
		return primes;

	}
}
