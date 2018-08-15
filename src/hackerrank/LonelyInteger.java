package hackerrank;

import java.util.Scanner;

public class LonelyInteger {
    // Complete the lonelyinteger function below.
    static int lonelyinteger(int[] a) {
        int bitKeeper = 0;
        for (int j = 0; j < a.length; j++) {
            if (((bitKeeper >> (a[j] - 1)) & 1) == 1) {
                bitKeeper = bitKeeper & ~(1 << (a[j] - 1));
            } else {
                bitKeeper = 1 << (a[j] - 1) | bitKeeper;
            }
        }

        for (int j = 0; j < a.length; j++) {
            if (((bitKeeper >> (a[j] - 1)) & 1) == 1) {
                return a[j];
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(scanner.next());
            a[i] = aItem;
        }

        int result = lonelyinteger(a);
        System.out.println(result);
        scanner.close();
    }
}
