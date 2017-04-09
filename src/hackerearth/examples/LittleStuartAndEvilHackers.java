package hackerearth.examples;

import java.math.BigInteger;
/*not yet solved..*/
public class LittleStuartAndEvilHackers {
	public static void main(String[] args) {
		int n = 200000;
		System.out.println(combinations(n, n / 2));
	}

	static BigInteger combinations(int n, int k) {
		BigInteger coeff = new BigInteger("1");
		System.out.println(coeff);
		for (int i = n - k + 1; i <= n; i++) {
			System.out.println(coeff);
			coeff=coeff.multiply(new BigInteger("" + i));
		}
		System.out.println(coeff);
		for (int i = 1; i <= k; i++) {
			coeff=coeff.divide(new BigInteger("" + i));
		}
		return coeff.mod(new BigInteger("1000000009"));
	}
}
