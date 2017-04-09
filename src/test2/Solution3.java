package test2;

import java.util.Scanner;

public class Solution3 {
	private static final long fact[] = new long[1000000];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		fact[1]=1;
		fact[2]=2;
		for(int i=2;i<1000000;i++){
			long temp=i*fact[i-1];
			fact[i]=(temp)%1000000007;
			System.out.println(fact[i]);
		}
		for (int t = 1; t <= testCases; t++) {
			int N = in.nextInt();
			int count = 0;
			for (int i = 1; i <= N - 2; i++) {
				for (int j = 1; j < i; j++) {
					int k = N - (i + j);
					count += (fact(N) / (fact(i) * fact(j) * fact(k))) * 3;
				}
			}
			System.out.println(count);
		}

	}

	private static long fact(int n) {
		
		return fact[n];
	}
}
