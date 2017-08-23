package hackerrank;

import java.util.Scanner;

public class SummingPieces {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        long cache[][] = new long[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            cache[i][i] = arr[i];
        }
        long rem = (long) (Math.pow(10, 9) + 7);
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;
                System.out.println("(" + i + "," + j + ")");
                cache[i][j] = (((cache[i][j - 1])) + cache[j][j]) % rem;
                System.out.println(cache[i][j]);
            }
        }

        System.out.println(cache[0][n - 1]);
    }
}
