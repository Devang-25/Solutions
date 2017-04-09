package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class Spheres {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int R1=in.nextInt();
			int R2=in.nextInt();
			int x[] = fetch(in);
			int a[] = fetch(in);
			int y[] = fetch(in);
			int b[] = fetch(in);
			long A = (deltaSQ(a, b));
			long B = 0;
			for (int i = 0; i < 3; i++) {
				B += ((b[i] - a[i]) * (y[i] - x[i]));
			}
			B*=4;
			long C = 4*(deltaSQ(x, y)-(R1+R2)*(R1+R2));
			BigInteger d = new BigInteger(B+"");
			d=d.multiply(new BigInteger(""+B));
			BigInteger temp=new BigInteger(-1*4*A+"");
			temp=temp.multiply(new BigInteger(""+C));
			d=d.add(temp);
			System.out.println(d);
			if (d.compareTo(new BigInteger("0"))==-1) {
				System.out.println("NO");
			} else {
				double di=d.shiftLeft(1).doubleValue();
				System.out.println(di);
				double t1 = (-1 * B + di) / (2 * A);
				double t2 = (-1 * B - di) / (2 * A);
				if (t1 > 0 || t2 > 0) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}

		}
	}

	private static int deltaSQ(int[] b, int[] a) {
		int sq = 0;
		for (int i = 0; i < 3; i++) {
			int d = b[i] - a[i];
			sq += d * d;
		}
		return sq;
	}

	private static int[] fetch(Scanner in) {
		int v[] = new int[3];
		for (int i = 0; i < 3; i++) {
			v[i] = in.nextInt();
		}
		return v;
	}
}
