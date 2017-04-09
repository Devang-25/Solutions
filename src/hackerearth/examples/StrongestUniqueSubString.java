package hackerearth.examples;

import java.util.Scanner;

public class StrongestUniqueSubString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextInt();
		String str = in.next();
		int repository = 0;
		int i = 0;
		String best =new String(str);
		StringBuilder b = new StringBuilder();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		while (i != str.length()) {
			int c = str.charAt(i) - 97;
			if (((repository >> c) & 1) == 1) {
				if (sum > max) {
					max = sum;
					best = b.toString();
				}
				sum = 0;
				b = new StringBuilder();
				repository = 0;
			}
			repository |= (1 << c);
			b.append(str.charAt(i));
			sum += c;
			i++;
		}
		System.out.println(best);
	}
}
