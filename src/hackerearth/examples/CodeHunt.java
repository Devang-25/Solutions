package hackerearth.examples;

import java.util.Scanner;

public class CodeHunt {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		boolean cache[]=new boolean[101];
		for (int t = 1; t <= testCases; t++) {
			int numbers = in.nextInt();
			int arr[] = new int[numbers];
			for (int i = 0; i < numbers; i++) {
				arr[i] = in.nextInt();
			}
			System.out.println(process(arr));
		}

	}

	public static long process(int arr[]) {
		long doorNumber = 0;

		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					if (arr[i] % arr[j] == 0) {
							doorNumber = doorNumber + 1;
					}
				}
			}
		return doorNumber;
	}
}