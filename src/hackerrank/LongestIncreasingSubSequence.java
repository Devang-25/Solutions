/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * @author makkg
 *
 */
public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		System.out.println(lis(arr, arr.length));
	}

	static int lis(int arr[], int n) {
		int lis[] = new int[n], max = 0;
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}
		for (int i = 0; i < n; i++) {
			if (max < lis[i]) {
				max = lis[i];
			}
		}

		return max;
	}
}
