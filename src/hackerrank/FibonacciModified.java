/**
 * 
 */
package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author makkg
 *
 */
public class FibonacciModified {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BigInteger a = new BigInteger(in.nextInt() + "");
		BigInteger b = new BigInteger(in.nextInt() + "");
		int N = in.nextInt();
		BigInteger c = null;
		for (int i = 3; i <= N; i++) {
			c = b.multiply(b).add(a);
			a = b;
			b = c;
		}
		System.out.println(c);
	}
}
