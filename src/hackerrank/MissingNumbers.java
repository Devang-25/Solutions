package hackerrank;

import java.util.Scanner;

public class MissingNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int aA[] = new int[a];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < aA.length; i++) {
			aA[i] = in.nextInt();
			if (min > aA[i]) {
				min = aA[i];
			}
		}
		int b = in.nextInt();
		int hashB[] = getHash(in, b);
		int hashA[] = getHash(aA, min);
		for(int i=0;i<hashB.length;i++){
			if(hashA[i]!=hashB[i]){
				System.out.print((i+min)+" ");
			}
		}

	}

	private static int[] getHash(int[] aA, int min) {
		int hash[] = new int[101];
		for (int r : aA) {
			hash[r - min]++;
		}
		return hash;
	}

	static int[] getHash(Scanner in, int a) {
		int min = Integer.MAX_VALUE;
		int arr[] = new int[a];
		for (int i = 0; i < a; i++) {
			arr[i] = in.nextInt();
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		int hash[] = getHash(arr, min);
		return hash;
	}
}
