package hackerearth.examples;

/*Given array of N integers ranging from 0 to N-1. 
 * Output maximum repeating integer. 
 * */
public class MaxRepeatFindAlgoO1 {

	private static final int K = 10;

	/* buggy code. */
	public static void main(String args[]) {
		int arr[] = { 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 7, 3, 9, 9,
				9, 2, 2, 9, 9, 9, 7, 5 };
		for (int i = 0; i < arr.length; i++) {
			arr[arr[i] % K] += K;
		}
		int max = -1;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				result = i;
				max = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] % K;
		}
		System.out.println(max);
		System.out.println(result);
	}

}
