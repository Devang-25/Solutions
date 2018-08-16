package hackerrank;

import java.util.Scanner;
import java.util.TreeSet;

public class MininumLoss {

    // Complete the minimumLoss function below.
    static long minimumLoss(long[] price) {
        TreeSet<Long> soFar = new TreeSet<>();
        long min = Long.MAX_VALUE;
        for (int i = price.length - 1; i >= 0; i--) {
            Long maxSoFarSmallerThanX = soFar.floor(price[i]);
            if (maxSoFarSmallerThanX != null) {
                if (price[i] - maxSoFarSmallerThanX < min) {
                    min = price[i] - maxSoFarSmallerThanX;
                }
            }
            soFar.add(price[i]);
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        long result = minimumLoss(price);
        System.out.println(result);

        scanner.close();
    }
}
