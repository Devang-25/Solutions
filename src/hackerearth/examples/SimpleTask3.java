/**
 * 
 */
package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author makkg
 *
 */
public class SimpleTask3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int r = in.nextInt();
			int k = in.nextInt();
			int v = in.nextInt();
			if (r == 0 && k == 0 && v == 0) {
				System.out.println(0);
			} else {
				int nos[] = new int[] { r, k, v };
				Arrays.sort(nos);
				System.out.println(nos[1] * 2 + 1);
			}
		}
	}
}
