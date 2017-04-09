package test2;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int N = in.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}
			int len[] = new int[arr.length];
			TreeSet<Integer> set = new TreeSet<Integer>();
			set.add(arr[arr.length - 1]);
			for (int i = arr.length - 2; i >= 0; i--) {
				len[i] = set.headSet(arr[i]).size();
				set.add(arr[i]);
			}
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < len.length; i++) {
				b.append(len[i] + " ");
			}
			System.out.println(b.toString());
		}
	}
}
