package hackerearth.examples.dynamic;

import java.util.Scanner;

public class SubsequencesDivisibleBy6 {
	static long limit = 1000000007;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			char sequence[] = in.next().toCharArray();
			System.out.println(noOfMinutes2(sequence));
		}
	}

	static int noOfMinutes2(char[] s) {
		int a = 0, b = 0, c = 0;
		for (int i = s.length - 1; i >= 0; i--) {

			int item = (s[i] - '0');

			if (item % 3 == 0) {
				a = a * 2;
				b = b * 2;
				c = c * 2;
			} else if (item % 3 == 1) {
				int a1 = a, b1 = b, c1 = c;
				a += c1;
				b += a1;
				c += b1;
			} else if (item % 3 == 2) {
				int a1 = a, b1 = b, c1 = c;
				a += b1;
				b += c1;
				c += a1;
			}

			if (item % 6 == 0)
				a++;
			else if (item % 3 == 1 && item % 2 == 0)
				b++;
			else if (item % 3 == 2 && item % 2 == 0)
				c++;
		}
		return a;
	}

	static long noOfMinutes(char[] sequence) {
		long b = 0;
		long c = 0;
		long a = 0;
		long output = 0;
		long tb = 0;
		long tc = 0;
		long ta = 0;
		long sum = 0;
		/*
		 * Till a point i, we have some subsequences with remainder 1, 2 , 0 we
		 * count them in subsR1= subsequences with remainder 1. when we look at
		 * i+1 th no.. we have two options, to include it to all those
		 * subsequences or not. if included then all , for rem 1 , all subsR0
		 * will add to subsR1=b. if not, we still have subsR1, so
		 * totalSubR1=subsR1(=b)+subsR0(=a);
		 */
		for (int i = 0; i < sequence.length; i++) {
			int remainder = (sequence[i] - '0') % 3;
			switch (remainder) {
			case 0:
				tb = (b + b) % limit;
				tc = (c + c) % limit;
				ta = (a + a) % limit;
				//doubt here..
				sum = a + 1;
				b = tb;
				c = tc;
				a = ta;
				a++;
				break;
			case 1:
				tb = (b + a) % limit;
				tc = (c + b) % limit;
				ta = (a + c) % limit;
				sum = c;
				b = tb;
				c = tc;
				a = ta;
				b++;
				break;
			case 2:
				tb = (b + c) % limit;
				tc = (c + a) % limit;
				ta = (a + b) % limit;
				sum = b;
				b = tb;
				c = tc;
				a = ta;
				c++;
				break;
			}
			if ((sequence[i] - '0') % 2 == 0)
				output = (output + sum) % limit;
		}
		return output;
	}
}
