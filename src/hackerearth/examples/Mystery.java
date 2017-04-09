package hackerearth.examples;

import java.util.Scanner;

public class Mystery {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int m = 1; m <= testCases; m++) {
			String input = in.next();
			int d = in.nextInt() % 26;
			if (d == 0) {
				System.out.println(input);
				return;
			}
			//System.out.println(d);
			char output[] = new char[input.length()];
			if (d > 0) {
				for (int i = 0; i < input.length(); i++) {
					char c = input.charAt(i);
					if ('z' - c < d) {
						int gap = 'z' - c;
						//System.out.println(c + " g: " + gap);
						char n = (char) ('a' + d - gap - 1);
						output[i] = n;
					} else {
						output[i] = (char) (c + d);
					}
				}
			} else {
				d = d * -1;
				for (int i = 0; i < input.length(); i++) {
					char c = input.charAt(i);
					if (c - 'a' < d) {
						int gap = c - 'a';
						// System.out.println(c+" g: "+gap);
						char n = (char) ('z' - (d - gap) + 1);
						output[i] = n;
					} else {
						output[i] = (char) (c - d);
					}
				}
			}
			System.out.println(new String(output));
		}
	}
}
