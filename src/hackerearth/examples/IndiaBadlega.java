package hackerearth.examples;

import java.util.Scanner;

public class IndiaBadlega {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int N = in.nextInt();
			int arr[] = new int[N];
			int X = in.nextInt();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}
			boolean reservoir = false;
			int i = 1;
			int resvI = 0;
			int resvJ = 0;
			boolean downState = false;
			int water = 0;
			while (i < arr.length) {
				if (!reservoir) {
					System.out.println("No resv" + i);
					if (arr[i] >= arr[resvI]) {
						resvI = i;// this is the highest point till now.
					} else {
						reservoir = true;
						downState = true;
					}
					i++;
				} else if (downState) {
					System.out.println("down" + i);
					if (arr[i] > arr[i - 1]) {
						downState = false;
						resvJ = i;
					}
					i++;
				} else {
					System.out.println("resv up" + i);
					if (arr[i] > arr[i - 1]) {
						resvJ = i;
						System.out.println("resvJ:" + resvJ);
					} else if (arr[i] < arr[i - 1]) {
						// this is the point where i don my calculation.
						water += calculateStoredWater(arr, resvI, resvJ);
						System.out.println("water is :" + water);
						resvI = resvJ;
						reservoir = true;
						downState = true;
					}
					i++;

				}
			}
			if (reservoir && !downState) {
				System.out.println("last resv");
				water += calculateStoredWater(arr, resvI, resvJ);
			}
			System.out.println("water" + water);
			if (water >= X) {
				System.out.println(0);
			} else {
				System.out.println(X - water);
			}
		}

	}

	private static int calculateStoredWater(int[] arr, int resvI, int resvJ) {
		System.out.println(resvI + ";" + resvJ);
		int minHeight = Math.min(arr[resvI], arr[resvJ]);
		System.out.println(minHeight);
		int water = 0;
		for (int i = resvI + 1; i < resvJ; i++) {
			int cap = minHeight - arr[i];
			if (cap > 0) {
				water += cap;
			}
		}
		return water;
	}
}
