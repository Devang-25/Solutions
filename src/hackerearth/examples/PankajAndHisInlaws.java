package hackerearth.examples;

import java.util.Scanner;

public class PankajAndHisInlaws {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfElements = in.nextInt();
		int list[] = new int[noOfElements];
		for (int i = 0; i < noOfElements; i++) {
			list[i] = in.nextInt();
		}
		int max=longestIncreasingSeq(list);
		System.out.println(Integer.toBinaryString(max));
	}

	static int longestIncreasingSeq(int arr[]) {
		int lis[], i, j, max = 0;
		lis = new int[arr.length];

		for (i = 0; i < arr.length; i++)
			lis[i] = 1;

		for (i = 1; i < arr.length; i++) {
			for (j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		for (i = 0; i < arr.length; i++)
			if (max < lis[i])
				max = lis[i];

		return max;
	}
}
