package hackerearth.examples.thoughtwork;

import java.util.Scanner;

public class PolynomialSign {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long lastNonZeroCoff = -1;
        int power = -1;
        int n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            long c = in.nextLong();
            if (c != 0) {
                lastNonZeroCoff = c;
                power = i;
            }
        }
        // for positive
        if (lastNonZeroCoff > 0) {
            System.out.print(1+" ");
        } else {
            System.out.print(-1+" ");
        }

        //for negative case.
        if (power % 2 == 0) {
            // for positive
            if (lastNonZeroCoff > 0) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        } else {
            if (lastNonZeroCoff > 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        }

    }
}
