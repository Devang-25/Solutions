package hackerrank;

import java.util.Scanner;

public class Stock {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a = 0; a < t; a++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            //arr is the array of predicted stock prices.
            int maxFromNow[] = new int[arr.length];
            int max = Integer.MIN_VALUE;
            for (int i = maxFromNow.length - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                maxFromNow[i] = max;
            }
            long profit = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < maxFromNow[i]) {
                    profit += (maxFromNow[i] - arr[i]);
                }
            }
            System.out.println(profit);
        }
        in.close();
    }
}
