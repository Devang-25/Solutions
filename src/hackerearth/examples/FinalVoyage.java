package hackerearth.examples;

import java.util.Scanner;

public class FinalVoyage {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int no = in.nextInt();
			// System.out.println(no);
			int w = in.nextInt();
			int weight[] = new int[no];// {2,4,5,7 };
			int val[] = new int[no];// { 4,9,7,5};
			for (int j = 0; j < no; j++) {
				weight[j] = in.nextInt();
			}
			// System.out.println(display(weight, 0));
			for (int j = 0; j < no; j++) {
				val[j] = in.nextInt();
			}
			// System.out.println(display(val, 0));
			System.out.println(value(w, weight, val, 0));
		}

	}

	private static int value(int w, int weight[], int val[], int ith) {
		// System.out.println("value(" + w + "," + weight[ith]+","+val[ith] +
		// ")");
		if (w == 0) {
			return 0;
		}
		if (ith == weight.length) {
			return 0;
		}
		/*
		 * System.out.println("value(" + w + "," + display(weight, ith) + "," +
		 * display(val, ith) + ")");
		 */
		// System.out.println("val:" + val[ith]);
		int includingIth = 0;
		if (w - weight[ith] >= 0) {
			includingIth = val[ith]
					+ value(w - weight[ith], weight, val, ith + 1);
		} else {
			// System.out.println("ignored");
		}
		int excludingIth = value(w, weight, val, ith + 1);
		// System.out.println(includingIth + "," + excludingIth);
		return Math.max(includingIth, excludingIth);

	}

	private static String display(int arr[], int from) {
		StringBuilder b = new StringBuilder();
		b.append("{");
		for (int i = from; i < arr.length; i++) {
			b.append(arr[i] + ",");
		}
		b.append("}");
		return b.toString();
	}
}
