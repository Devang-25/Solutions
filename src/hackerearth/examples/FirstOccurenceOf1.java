package hackerearth.examples;

//be very careful at the boundary.
public class FirstOccurenceOf1 {
	// assumption array is sorted.
	public static int occrOne(int[] array, int start, int end) {
		System.out.println(start + " :" + end);
		if (start == end) {
			return end;
		} else if (start + 1 == end) {
			if (array[start] == 1) {
				return start;
			}
			return end;
		}
		int mid = (start + end) / 2;
		System.out.println("mid :" + mid);
		if (array[mid] == 1) {
			return occrOne(array, start, mid);
		}
		return occrOne(array, mid + 1, end);
	}

	public static void main(String args[]) {
		int array[] = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		int array2[] = { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };

		int one = occrOne(array, 0, array.length - 1);
		System.out.println(one);
		System.out.println("array 2 len:" + array2.length);
		one = occrOne(array2, 0, array2.length - 1);
		System.out.println(one);
	}
}
