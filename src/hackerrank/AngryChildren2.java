package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gurpreet.makkar on 12/06/17.
 */
//did not pass well.
public class AngryChildren2 {
    static long result[][] = null;
    static int k = -1;
    static int arr[] = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        k = in.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        result = new long[n][k + 1];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j <= k; j++) {
                result[i][j] = Long.MAX_VALUE;
            }
        }
        min(0, 0, new ArrayList<>(), 0);
        long min = Long.MAX_VALUE;
        for (int i = 0; i < result.length; i++) {
            min = Math.min(min, result[i][k]);
        }
        System.out.println(min);
    }

    private static void min(int i, int s, ArrayList<Integer> packets, long unfairness) {
        System.out.println("min(" + i + "," + s + "," + packets + "," + unfairness + ")");
        if (i == arr.length) {
            return;
        }
        if (i == arr.length - (k - s)) {
            int a = 0;
            for (int p = i; p <= arr.length - 2; p++) {
                for (int m = p + 1; m <= arr.length - 1; m++) {
                    a += Math.abs(arr[p] - arr[m]);
                }
            }
            int b = 0;
            for (int p = i; p < arr.length; p++) {
                for (int x : packets) {
                    b += Math.abs(x - arr[p]);
                }
            }
            System.out.println("new:" + a);
            System.out.println("old:" + b);
            unfairness += (a + b);
            if (result[arr.length - 1][k] > unfairness) {
                result[arr.length - 1][k] = unfairness;
            }
            System.out.println(result[arr.length - 1][k]);
            return;
        }
        min(i + 1, s, packets, unfairness);
        if (result[i][s] < unfairness) {
            result[i][s] = unfairness;
        }
        ArrayList<Integer> packetsWithIthPacket = new ArrayList<>(packets);
        packetsWithIthPacket.add(arr[i]);
        for (int x : packets) {
            unfairness += Math.abs(x - arr[i]);
        }
        if ((s + 1) <= k) {
            min(i + 1, s + 1, packetsWithIthPacket, unfairness);
            if (result[i][s + 1] > unfairness) {
                result[i][s + 1] = unfairness;
                System.out.println("res[" + i + "][" + (s + 1) + "]=" + unfairness);
            }
        }
    }
}
