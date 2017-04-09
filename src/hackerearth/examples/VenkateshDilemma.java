package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;
/*incorrect...*/
public class VenkateshDilemma {
	private static long count = 0;
	private static long boxes[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long s = in.nextLong();
		boxes = new long[n];
		for (int b = 0; b < n; b++) {
			long chocs = in.nextLong();
			boxes[b] = chocs;
		}
		int group = 2;
		count+=removeGTEQ(Arrays.copyOf(boxes,boxes.length), s);
		while (group <= n) {
			System.out.println("For group:" + group);
			long[] copy = Arrays.copyOf(boxes, boxes.length);
			for (int boxI = 0; boxI < n; boxI++) {
				count(boxes, boxI, copy, s, group - 1);
			}
			group++;
		}
		System.out.println(count);
	}

	private static boolean count(long boxes[], int index, long[] remBoxes,
			long s, int level) {
		if (level == 0) {
			if (isEmpty(remBoxes) || s == 0) {
				return false;
			}
			System.out.println("Given s="+s);
			display(remBoxes);
			int ct=removeGTEQ(remBoxes, s);
			System.out.println(ct);
			count += ct;
			count %= 1000000007;
			return true;
		}
		long chocolates=boxes[index];
		remBoxes[index]=-1;
		for (long i = 1; i <= chocolates; i++) {
			if (!count(boxes, index+1, remBoxes, s - i, level - 1)) {
				break;
			}
		}
		if (index + 1 == boxes.length) {
			return true;
		}
		remBoxes[index+1]=-1;
		count(boxes, index + 1, remBoxes, s, level);
		return true;

	}

	private static void display(long[] remBoxes) {
		for(long e:remBoxes){
			System.out.print(e+" ");
		}
		System.out.println();
	}

	static boolean isEmpty(long array[]) {
		for (long e : array) {
			if (e != -1) {
				return false;
			}
		}
		return true;
	}

	static int removeGTEQ(long[] array, long val) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= val) {
				array[i] = -1;
				count++;
			}
		}
		return count;
	}
}
