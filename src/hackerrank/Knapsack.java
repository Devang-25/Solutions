package hackerrank;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Knapsack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int k = in.nextInt();
			TreeSet<Integer> nos = new TreeSet<Integer>();
			for (int i = 0; i < n; i++) {
				nos.add(in.nextInt());
			}
			if (nos.contains(1)) {
				System.out.println(k);
			} else {
				int no = s(k, nos.headSet(k, true));
				System.out.println(k-no);
			}
		}
	}

	private static int s(int k, SortedSet<Integer> headSet) {
		//System.out.println(k+":"+headSet);
		if (headSet.isEmpty() || k == 0) {
			return k;
		}
		if(headSet.contains(k)){
			return 0;
		}
		int minRem = Integer.MAX_VALUE;
		for (int n : headSet) {
			minRem=Math.min(minRem, s(k%n, headSet.headSet(k%n)));
			if(minRem==0){
				return minRem;
			}
		}
		return minRem;
	}
}
