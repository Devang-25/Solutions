package hackerearth.examples.intervals;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Altf4AndBeetles {
	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream s = new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(s);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int N = in.nextInt();
			int entry[] = new int[N + 1], exit[] = new int[N + 1];
			long A = in.nextInt(), B = in.nextInt(), C = in.nextInt();
			for (int i = 0; i < N; i++) {
				entry[i] = in.nextInt();
				exit[i] = in.nextInt();
			}
			entry[N] = exit[N] = Integer.MAX_VALUE;
			Arrays.sort(entry);
			Arrays.sort(exit);
			int i = 0;
			int j = 0;
			long dest = N * A;
			long min = dest;
			while (i < N && j < N) {
				if (entry[i] <= exit[j]) {
					dest += B - A;
					i++;
				} else {
					dest += C - B;
					j++;
				}
				min = Math.max(min, dest);
			}
			System.out.println(min);
		}
		System.out.flush();
	}
}
