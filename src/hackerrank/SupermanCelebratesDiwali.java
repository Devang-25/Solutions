package hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SupermanCelebratesDiwali {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int H = in.nextInt();
        int I = in.nextInt();
        int ppl[][] = new int[H][N];
        int max[][] = new int[H][N];
        for (int i = 0; i < N; i++) {
            int U = in.nextInt();
            for (int u = 1; u <= U; u++) {
                ppl[in.nextInt() - 1][i]++;
            }
        }
        display(ppl);
        for (int building = 0; building < N; building++) {
            max[0][building] = ppl[0][building];
        }
        for (int floor = 1; floor < H; floor++) {
            if (floor - I >= 0) {
                int[] copy = Arrays.copyOf(max[floor - I], N);
                Arrays.sort(copy);
                int max1 = copy[copy.length - 1];
                int max2 = copy[copy.length - 2];
                for (int k = 0; k < N; k++) {
                    if (max[floor - I][k] == max1) {
                        max[floor][k] = max2;
                    }
                    max[floor][k] = max1;
                }
            }
            display(max);
            for (int building = 0; building < N; building++) {
                max[floor][building] = Math.max(max[floor][building], max[floor - 1][building]);
            }
            display(max);
            for (int b = 0; b < N; b++) {
                max[floor][b] += ppl[floor][b];
            }
            display(max);
        }
        int m = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            m = Math.max(m, max[max.length - 1][i]);
        }
        System.out.println(m);


    }

    /*
    *
3 0 0 0
0 0 0 0
0 1 1 0
1 0 1 0
0 1 1 0
0 0 1 0
0 2 0 0
0 2 0 0
0 2 1 0
1 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
    * */
    private static void display(int a[][]) {
        System.out.println("ARRAY :-");
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + i + "]: ");
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
