package codechef.problems.binarysearch;

/**
 * http://www.codechef.com/problems/SQUIRREL
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;



class SQUIRREL {
	int[] sTime, dropFreqs, nutsInTime;
	int trees, squirrels, chestNuts;
	long currentMinTime;

	boolean checkAtTime(int time) {
		nutsInTime = new int[trees];
		for (int i = 0; i < trees; i++) {
			if (sTime[i] <= time)
				nutsInTime[i] = 1 + (time - sTime[i]) / dropFreqs[i];
			else
				nutsInTime[i] = 0;
		}
		long sum = 0;
		if (squirrels < trees) {
			Arrays.sort(nutsInTime);
			for (int i = 1; i <= squirrels; i++)
				sum = sum + nutsInTime[trees - i];
			if (sum >= chestNuts)
				return true;
		} else {
			for (int i = 0; i < trees; i++)
				sum = sum + nutsInTime[i];
			if (sum >= chestNuts)
				return true;
		}
		return false;
	}

	void solve() throws IOException {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream s = new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(s);
		int testCase = in.nextInt();
		while (testCase-- > 0) {
			trees = in.nextInt();
			squirrels = in.nextInt();
			chestNuts = in.nextInt();
			dropFreqs = new int[trees];
			sTime = new int[trees];
			for (int i = 0; i < trees; i++)
				{sTime[i] = in.nextInt();}
			for (int i = 0; i < trees; i++)
				{dropFreqs[i] = in.nextInt();}
			//find the most optimal tree.
			long min = sTime[0] + (chestNuts - 1) * dropFreqs[0];
			for (int i = 1; i < trees; i++) {
				long nutsForI = sTime[i] + (long) (chestNuts - 1)
						* dropFreqs[i];
				if (nutsForI < min)
					min = nutsForI;
			}
			// answer is lesser than min.
			long low = 0;
			long high = min;
			// use binary search to converge.
			while (low <= high) {
				int mid = (int) ((high + low) / 2);
				if (checkAtTime(mid)) {
					high = mid - 1;
					currentMinTime = mid;
				} else
					low = mid + 1;
			}
			System.out.println(currentMinTime);
		}

	}

	public static void main(String[] args) throws IOException {
		new SQUIRREL().solve();
		System.out.flush();

	}

}