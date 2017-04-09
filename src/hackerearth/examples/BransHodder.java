package hackerearth.examples;

import java.util.Scanner;

public class BransHodder {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int chocolates=n;
		while(n/m!=0){
			int t=n/m;
			chocolates+=t;
			n=t+n%m;
		}
		System.out.println(chocolates);
	}
}
