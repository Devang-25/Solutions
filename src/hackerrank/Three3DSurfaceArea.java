package hackerrank;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Three3DSurfaceArea {

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] a) {
        int totalSum = 2 * a.length * a[0].length;

        totalSum += dimensionalSurfaceAreaX(a);
        totalSum += dimensionalSurfaceAreaY(a);

        return totalSum;
    }


    static int dimensionalSurfaceAreaX(int[][] a) {
        int totalSum = 0;
        for (int x : a[0]) {
            totalSum += x;
        }

        for (int x : a[a.length - 1]) {
            totalSum += x;
        }
        for (int i = 1; i < a.length; i++) {
            final int c = i;
            totalSum += IntStream.range(0, a[i].length).map(x -> Math.abs(a[c][x] - a[c - 1][x])).sum();
        }
        return totalSum;
    }


    static int dimensionalSurfaceAreaY(int[][] a) {
        int totalSum = 0;
        for (int i = 0; i < a.length; i++) {
            totalSum += a[i][0];
        }

        for (int i = 0; i < a.length; i++) {
            totalSum += a[i][a[0].length - 1];
        }
        for (int i = 1; i < a[0].length; i++) {
            final int c = i;
            totalSum += IntStream.range(0, a.length).map(x -> Math.abs(a[x][c] - a[x][c - 1])).sum();
        }
        return totalSum;
    }


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);
        System.out.println(result);

        scanner.close();
    }
}
