package hackerearth.examples.dynamic;

import java.util.Scanner;

public class UtkarshAndJumps {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int P = in.nextInt();
		double p2 = (double)P / 100;
		double p3 = 1 - p2;
		double pb[] = new double[N + 1];
		pb[2] = p2;
		pb[3] = p3;
		for (int i = 4; i < pb.length; i++) {
			pb[i] = p2 * pb[i - 2] + pb[i - 3] * p3;
			//System.out.println("pb["+i+"]="+pb[i]);
		}
		System.out.println(String.format("%.6f", pb[N]));
	}
}
