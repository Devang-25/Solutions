package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Temple {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		int i = 1;
		while (i <= testCases) {
			int noOfItems = in.nextInt();
			List<Integer> weights = new ArrayList<>(noOfItems);
			for (int j = 1; j <= noOfItems; j++) {
				weights.add(in.nextInt());
			}
			Integer arr[] = weights.toArray(new Integer[weights.size()]);
			int sum = 0;
			for (int k = 0; k < arr.length; k++) {
				sum += arr[k];
			}
			//System.out.println(Arrays.asList(arr));
			if (sum % 2 == 1) {
				System.out.println("NO");
			} else {
				// System.out.println(arr[0]);
				boolean isOk = process(arr, 1, (sum / 2) - arr[0]);
				System.out.println(isOk ? "YES" : "NO");
			}
			i++;
		}

	}

	private static boolean process(Integer arr[], int index, int sum) {
		if (arr.length == index) {
			return false;
		}
		for (int i = index; i < arr.length; i++) {
			if (arr[i] == sum) {
				// System.out.println(arr[i]);
				return true;
			} else if (arr[i] < sum) {
				if (process(arr, i + 1, sum - arr[i])) {
					// System.out.println(arr[i]);
					return true;
				}
				if (process(arr, i + 1, sum)) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

}
