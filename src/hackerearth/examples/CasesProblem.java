package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CasesProblem {

	  	public static void main(String args[]) {
			Scanner in = new Scanner(System.in);
			int testCases = in.nextInt();
			List<Integer> cases = new ArrayList<Integer>();
			for (int i = 1; i <= testCases; i++) {
				cases.add(in.nextInt());
			}
			
			 //System.out.println(cases);
			int pairs = 0;
			int gMax = -1;
			List<Integer> primes = null;
			//long t1=System.currentTimeMillis();
			for (Integer cs : cases) {
				int max = cs;
				if (max <= 3) {
					System.out.println(0);
				} else if (max == 4) {
					System.out.println(1);
				} else {
					int maxP=max/2;
					if (max > gMax) {
						primes = getPrimes(5, maxP);
						gMax=maxP;
					}
					// System.out.println(primes);
					for (Integer p : primes) {
						int pairsWithP = (max / p) - 1;
						// System.out.println(pairsWithP);
						int pairsWithFactorP = (pairsWithP * (pairsWithP + 1)) / 2;
						// System.out.println(pairsWithFactorP);
						pairs += pairsWithFactorP;
					}
					System.out.println(pairs);
				}
			}
			//System.out.println(System.currentTimeMillis()-t1);
			//System.out.println(getPrimes(5, 1000000));
		}

		public static List<Integer> getPrimes(int minNumbers, int maxNumbers) {
			List<Integer> primes = new ArrayList<Integer>();
			if(maxNumbers==2){
				primes.add(2);
				return primes;
			}
			primes.add(2);
			primes.add(3);
			//int operations = 0;
			for (int number = minNumbers; number <= ((maxNumbers % 2 != 0) ? maxNumbers
					: maxNumbers - 1); number += 2) {
				// System.out.println("checking  prime :" + number);
				boolean isPrime = true;
				for (int p = 1; p < primes.size(); p++) {
					// System.out.println(primes);
					if (primes.get(p) <= Math.floor(number / primes.get(p - 1))) {
						//operations++;
						// System.out.println("\t\t dividing by :" + primes.get(p));
						if (number % primes.get(p) == 0) {
							isPrime = false;
							break;
						}
					}else{
						break;
					}
				}
				if (isPrime) {
					primes.add(number);
				}
			}
			// System.out.println("Operations= " + operations);
			 //System.out.println(primes.size());
			return primes;

		}
	}


