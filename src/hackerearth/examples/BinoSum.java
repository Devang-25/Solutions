package hackerearth.examples;

import java.math.BigInteger;
import java.util.Scanner;

public class BinoSum {
	static long repository[][] = new long[1001][1001];

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		//int testCases = in.nextInt();
		for (int t = 1; t <= 1000000; t++) {
			int N = (int) (1+Math.random()*1000);//;in.nextInt();
			int P =(int) (Math.random()*N); //in.nextInt();
			BigInteger b = new BigInteger("0");
			for (int i = 0; i <= P; i++) {
				if (repository[N][P] == 0) {
					long bC = binomialCoeff(N, i);
					repository[N][i] = bC;
				}
				b=b.add(new BigInteger("" + repository[N][i]));
			}
			System.out.println(b.mod(new BigInteger("1000000007")));
		}
	}

	static long binomialCoeff(int n, int k) {
		long res = 1;

		if (k > n - k)
			k = n - k;

		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}
}
