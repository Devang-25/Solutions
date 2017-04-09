package hackerearth.examples;

import java.util.Set;
import java.util.TreeSet;

public class FibonacciNumbers {
	static long[] cache = new long[1000];
	public static void main(String[] args) {
		buildFibonacciCache();
		for(int i=1;i<cache.length;i++){
			TreeSet<Long> primeFactors=primeFactors(i);
			if(primeFactors.size()==1 && primeFactors.first()==i){
				System.out.println(i+"; "+cache[i]+";"+primeFactors(i));
			}
			
		}
		int k=161;
		TreeSet<Long> primeFactors=primeFactors(k);
		long sFactor=primeFactors.first();
		System.out.println(cache[(int) sFactor]);
		
		// System.out.println(primeFactors(1000000));
	}

	static void buildFibonacciCache() {
		long a = 1;
		long b = 2;
		cache[2]=2;
		cache[3]=3;
		long max=(long) Math.pow(10, 18);
		for (int i = 1; i <=100; i++) {
			long sum = a + b;
			a = b;
			b = sum;
			if (b>max) {
				break;
			}
			Set<Long> factors = primeFactors(b);
			for (long factor : factors) {
				if (factor < 1000) {
					int f = (int) (factor);
					if (cache[f] == 0) {
						//this is the first time this factor has appeared in this any fibonacci.
						//so save it.
						cache[f] = b;
					}
				}
			}
		}
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
