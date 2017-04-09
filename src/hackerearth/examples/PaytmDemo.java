package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaytmDemo {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		if (in.hasNextInt()) {
			int testCases = in.nextInt();
			List<Integer> ranges = new ArrayList<Integer>();
			int i = 1;
			while (i <= testCases) {
				ranges.add(in.nextInt());
				i++;
			}
			for (Integer r : ranges) {
				for (int j = 1; j <= r; j++) {
					if (j % 5 == 0 && j % 3 == 0) {
						System.out.println("FizzBuzz");
					} else if (j % 5 == 0) {
						System.out.println("Buzz");
					} else if (j % 3 == 0) {
						System.out.println("Fizz");
					} else {
						System.out.println(j);
					}
				}
			}
		}
	}
}
