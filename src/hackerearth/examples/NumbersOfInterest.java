package hackerearth.examples;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//unable to solve..the idea matches others.
public class NumbersOfInterest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			List<BigDecimal> s = new LinkedList<BigDecimal>();
			int x = in.nextInt();
			int y = in.nextInt();
			int n = in.nextInt();
			for (int j = 0; j < x; j++) {
				s.add(new BigDecimal(y));
			}
			BigDecimal sum = new BigDecimal(x * y);
			BigDecimal l = new BigDecimal(0);
			if (n <= x) {
				System.out.println(s.get(0));
			} else {
				BigDecimal sumX = new BigDecimal(0);
				for (int j = x; j < n; j++) {
					if (j == x) {
						sumX = sum;
					} else {
						sumX = sumX.subtract(l).add(sumX);
					}
					s.add(sumX);
					l = s.get(0);
					s.remove(0);
				}
				System.out.println(sumX);
			}
		}
	}
}
