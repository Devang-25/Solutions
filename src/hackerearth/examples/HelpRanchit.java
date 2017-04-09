package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;

public class HelpRanchit {
	public static void main(String args[]) {
		primes = new boolean[100020001];
		fillSieve();
		Scanner in = new Scanner(System.in);
		//int testCases = in.nextInt();
		//List<Integer> tests = new ArrayList<Integer>();
		
		long t = System.currentTimeMillis();
		for (int m = 1; m <= 100000; m++) {
			int aNo = /*in.nextInt();*/ (int) (Math.random() * 10000);//
									// in.nextInt();
			findPercentage(aNo);
		}
		System.out.println(System.currentTimeMillis()-t);

	}
	
	public static void findPercentage(int aNo){
		int matrixSize = aNo;
		int levels = matrixSize / 2;
		int no = 1;
		int primeCount = 0;
		int totalDiagElements = 4 * levels + 1;
		for (int i = 2; i <= 2 * levels; i += 2) {
			for (int j = 1; j <= 4; j++) {
				no += i;
				if (isPrime(no)) {
					//System.out.print(no+"\t");
					primeCount++;
				}
			}
		}
		//System.out.println();
		//System.out.println(totalDiagElements);
		double d = ((double) primeCount / totalDiagElements) * 100;
		d = Math.round(d * 1000000) / 1000000.0;
		System.out.println(d);
	}

	static boolean[] primes = null;

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
