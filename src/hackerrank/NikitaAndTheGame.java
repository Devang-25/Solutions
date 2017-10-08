package hackerrank;

import java.util.Scanner;

public class NikitaAndTheGame {
    private static int sumSoFar[] = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            sumSoFar = new int[arr.length];
            sumSoFar[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                sumSoFar[i] = sumSoFar[i - 1] + arr[i];
            }
            /*for (int i = 0; i < sumSoFar.length; i++) {
                System.out.print(sumSoFar[i] + ",");
            }
            System.out.println();
            */
            int maxPoints = maxPoints(arr, 0, arr.length - 1);
            System.out.println(maxPoints);
        }
    }

    private static int maxPoints(final int[] arr, int s, int e) {
        if (s == e) {
            return 0;
        }
        for (int j = s; j < e; j++) {
            if (sum(arr, s, j) == sum(arr, j + 1, e)) {
                return 1 + Math.max(maxPoints(arr, s, j), maxPoints(arr, j + 1, e));
            }
        }
        return 0;
    }

    private static int sum(int arr[], int s, int e) {
        //System.out.println("Sum[" + s + "][" + e + "]=" + (sumSoFar[e] - sumSoFar[s]));
        return sumSoFar[e] - sumSoFar[s] + arr[s];
    }
}
