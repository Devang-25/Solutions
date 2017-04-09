package test2;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class SortedArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int N = in.nextInt();
		int arrN[] = new int[N];
		for (int i = 0; i < N; i++) {
			arrN[i] = in.nextInt();
		}

		int M = in.nextInt();
		int arrM[] = new int[M];
		for (int i = 0; i < M; i++) {
			arrM[i] = in.nextInt();
		}
		StringBuilder b=new StringBuilder();
		int newSorted[] = sortedMerge(arrN, arrM);
		for(int i:newSorted){
			b.append(i+ " ");
		}
		System.out.println(b.toString());

	}

	private static int[] sortedMerge(int[] arrN, int[] arrM) {
		int newSorted[] = new int[arrM.length + arrN.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arrN.length && j < arrM.length) {
			if (arrN[i] <= arrM[j]) {
				newSorted[k] = arrN[i];
				i++;
			} else {
				newSorted[k] = arrM[j];
				j++;
			}
			k++;
		}
		if (i == arrN.length) {
			for (int m = j; m < arrM.length; m++) {
				newSorted[k] = arrM[m];
				k++;
			}
		} else if (j == arrM.length) {
			for (int n = i; n < arrN.length; n++) {
				newSorted[k] = arrN[n];
				k++;
			}
		}
		return newSorted;
	}
}
