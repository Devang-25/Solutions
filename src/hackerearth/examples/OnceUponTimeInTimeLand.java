package hackerearth.examples;

import java.util.Scanner;

public class OnceUponTimeInTimeLand {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int elements = in.nextInt();
			int gap = in.nextInt();
			Integer array[] = new Integer[elements];
			for (int e = 0; e < array.length; e++) {
				array[e] = in.nextInt();
			}
			// System.out.println(new ArrayList<>(Arrays.asList(array)));
			/*
			 * long max = max(array, 0, gap); if(max<=0){ System.out.println(0);
			 * }else{ System.out.println(max); }
			 */

			System.out.println(maxDynamic(array, gap));
		}
	}

	private static long maxDynamic(Integer[] array, int gap) {
		int max[] = new int[array.length];
		max[0] = array[0]<0?0:array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > 0) {
				if (i - gap-1>= 0) {
					max[i] = Math.max(max[i - 1], array[i] + max[i - gap-1]);
				} else {
					max[i] = Math.max(array[i],max[i - 1]);
				}
			} else {
				max[i] = max[i - 1];
			}
			//System.out.println(max[i]);
		}
		return max[array.length - 1];
	}

	private static long max(Integer[] array, int index, int gap) {
		System.out.println("max(" + index + ")");
		if (index == array.length - 1) {
			return array[index];
		}
		if (index >= array.length) {
			return 0;
		}
		if (array[index] <= 0) {
			System.out.println("Neg: " + array[index]);
			return max(array, index + 1, gap);
		}
		System.out.println("exclude :");
		long exclude = max(array, index + 1, gap);
		System.out.println("include :" + array[index]);
		long include = array[index] + max(array, index + gap + 1, gap);
		return Math.max(exclude, include);

	}
}
