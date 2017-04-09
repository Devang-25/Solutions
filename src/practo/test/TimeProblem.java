package practo.test;

import java.util.Scanner;
//yet to be improved and submitted.
public class TimeProblem {
	static final int primes[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23 };

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		int maxGoods=goods(23, 59, 59);
		System.out.println(maxGoods);
		int maxBads=23*59*59-maxGoods;
		for(int t=1;t<=testCases;t++){
			int hh=in.nextInt();
			int mm=in.nextInt();
			int ss=in.nextInt();
			int goods=goods(hh, mm, ss);
			int bads=hh*mm*ss-goods;
			System.out.println((maxGoods-goods)+":"+(maxBads-bads));

	}
	}
	static int goods(int hh, int mm, int ss) {
		int min = Math.min(hh, mm);
		min = Math.min(min, ss);
		int at = 0;
		int sum=0;
		while (at<primes.length && primes[at] <= min) {
			int p=primes[at];
			int common=(hh/p)*(mm/p)*(ss/p);
			sum+=common;
			at++;
		}
		return sum;
	}
}
