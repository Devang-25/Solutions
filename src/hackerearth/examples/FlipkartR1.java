package hackerearth.examples;

public class FlipkartR1 {
	public static int getNumberAsIndex(int array[], int s, int e) {
		if (s == e) {
			// System.out.println("s" + s);
			if (array[s] == s) {
				return s;
			}
			return Integer.MIN_VALUE;
		}
		int mid = (s + e) / 2;
		if (array[mid] == mid) {
			return mid;
		}
		if (array[mid] < 0 || array[mid] < mid) {
			return getNumberAsIndex(array, mid + 1, e);
		}
		return getNumberAsIndex(array, s, mid - 1);
	}

	public static void main(String rags[]) {
		int array1[] = { -11, -6, -2, -1, 0, 1, 2, 3, 8, 11, 12, 17, 19 };
		int answer1 = getNumberAsIndex(array1, 0, array1.length - 1);
		System.out.println(answer1);
		int array2[] = { -20, -15, -0, -5, -2, -1, 0, 3, 5, 7, 10 };
		int answer2 = getNumberAsIndex(array2, 0, array2.length - 1);
		System.out.println(answer2);
		int array3[] = { -20, -15, -0, -5, -2, -1 };
		int answer3 = getNumberAsIndex(array3, 0, array3.length - 1);
		System.out.println(answer3);
		int array4[] = { 2, 3, 8, 11, 12, 17, 19 };
		int answer4 = getNumberAsIndex(array4, 0, array4.length - 1);
		System.out.println(answer4);
	}

}
