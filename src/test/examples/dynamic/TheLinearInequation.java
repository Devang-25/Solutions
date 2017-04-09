package test.examples.dynamic;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class TheLinearInequation {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int n = in.nextInt();
		long arr[] = new  long[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextLong();
		}
		long[][] pre = new long[n + 1][n + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				long temp=(arr[i] * arr[j]) % 1000000007;
				//System.out.println("temp"+temp);
				pre[i][j] = (pre[i + 1][j + 1] + temp) % 1000000007;//i till end, j till end.
				//System.out.println(pre[i][j]);
			}
		}
		//verify
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(pre[i][j] + "  ");
//			}
//			System.out.println();
//		}
		//
		System.setOut(new PrintStream(new BufferedOutputStream(System.out)));
		int queries = in.nextInt();
		for (int q = 1; q <= queries; q++) {
			int i = in.nextInt() - 1;
			int j = in.nextInt() - 1;
			int s = in.nextInt();
			if(i>j){
				int temp=i;
				i=j;
				j=temp;
			}
			System.out
					.println((pre[i][j] - pre[i + s][j + s] + 1000000007) % 1000000007);

		}
		System.out.flush();
	}
}
