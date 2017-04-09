package hackerearth.examples;

import java.util.Scanner;

public class AbhinavAndManav {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			long max = getMax(in.nextLong(), in.nextLong());
			System.out.println(max);
		}

	}

	public static long getMax(long min, long max) {
		String minS = new String(min + "");
		String maxS = new String(max + "");
		if (minS.length() == maxS.length()) {
			System.out.println("same");
			int digits = minS.length();
			long maxima = (long) (5 * Math.pow(10, digits - 1));
			if ((minS.charAt(0) >= '5' && maxS.charAt(0) >= '5')
					|| (minS.charAt(0) <= '5' && maxS.charAt(0) <= '5')) {
				// either both lie after 5 or before 5
				System.out.println("both");
				/* we see which one is closer to 5 */
				if (Math.abs(maxima - min) < Math.abs(maxima - max)) {
					System.out.println(min + " closer");
					return min * mirror(min);
				} else {
					System.out.println(max + " closer");
					return max * mirror(max);
				}
			} else {
				return maxima * mirror(maxima);
			}
		} else {
			System.out.println("not same");
			int digitsOfMax = maxS.length();
			if (maxS.charAt(0) >= '5') {
				System.out.println("greater");
				long maxima = (long) (5 * Math.pow(10, digitsOfMax - 1));
				return maxima * mirror(maxima);
			} else {
				System.out.println("naah");
				return max * mirror(max);
			}
		}
	}

	// not optional..
	private static long mirror(long i) {
		long temp = i;
		long no = 9 - temp % 10;
		temp = temp / 10;
		// System.out.println(temp);
		int pow = 1;
		while (temp != 0) {
			// System.out.println("t:"+temp%10);
			no = (9 - temp % 10) * (int) Math.pow(10, pow) + no;
			temp = temp / 10;
			// System.out.println(temp);
			pow++;
		}
		// System.out.println(no);
		return no;
	}
}
