package hackerearth.examples;

import java.util.Scanner;

public class Supertables {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int a = in.nextInt();
			int b = in.nextInt();
			long N = in.nextLong();
			// nth val can atmost be multiple of max(a, b)*N
			long start = 1;
			long end = Math.max(a, b) * N;
			long nthVal=findNth(a, b, start, end, N);
			System.out.println(nthVal);
		}
	}

	private static long  findNth(int a, int b, long start, long end, long n) {
		// explore at mid.
		long mid = (start + end) / 2;
		long i = mid / a + mid / b - mid / lcm(a, b);
		if(i==n){
			return Math.max((mid/a)*a, (mid/b)*b);
		}else if(i<n){
			return findNth(a, b, mid+1, end, n);
		}else{
			return findNth(a, b, start, mid-1, n);
		}
	}

	private static int lcm(int a, int b) {
		return (a * b) / gcd(Math.max(a,b), Math.min(a,b));
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
