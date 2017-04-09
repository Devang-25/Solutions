package hackerearth.examples;

import java.math.BigInteger;
import java.util.Scanner;

public class PotionClasses {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int q = in.nextInt();
			int ai[] = new int[n];
			for (int i = 0; i < n; i++) {
				ai[i] = in.nextInt();
			}
			for (int query = 1; query <= q; query++) {
				int w = in.nextInt();
				int x = in.nextInt();
				int y = in.nextInt();
				int z = in.nextInt();
				//System.out.println(w+" "+x+" "+y+" "+z);
				BigInteger big = new BigInteger("0");
				for (int i = y; i <= z; i++) {
					long mul = (w + i) * ai[x + i-1];
					BigInteger another = new BigInteger(mul + "");
					big = big.add(another);
				}
				long mod = ((long) Math.pow(10, 9)) + 7;
				//System.out.println(mod);
				System.out.println(big.mod(new BigInteger(mod + "")));
			}

		}
	}
}
