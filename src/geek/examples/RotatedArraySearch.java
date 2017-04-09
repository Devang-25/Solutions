package geek.examples;

import java.util.Arrays;

public class RotatedArraySearch {
	public static void main(String[] args) {
		int array[] = { 13, 26, 22, 1, 3, 7, 9, 12 };
		int pivot = getPivot(array);
		int at = -1;
		int val = -3;
		if (pivot == -1) {
			at = Arrays.binarySearch(array, val);
		} else {
			if (array[pivot - 1] < val || array[pivot] > val) {
				at = -1;
			} else if (val >= array[0]) {
				at = Arrays.binarySearch(array, 0, pivot, val);
			} else {
				at = Arrays.binarySearch(array, pivot + 1, array.length, val);
			}
		}
		if (at < 0) {
			System.out.println("not found");

		} else {
			System.out.println(at);
		}

	}

	private static int getPivot(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[0]) {
				return i;
			}
		}
		return -1;
	}
}
