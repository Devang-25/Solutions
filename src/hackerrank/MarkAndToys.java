package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++)
            prices[i] = in.nextInt();
        Arrays.sort(prices);
        // Compute the final answer from n,k,prices
        int i = 0;
        int sum = 0;
        while (sum <= k) {
            sum += prices[i];
            i++;
        }
        System.out.println(i - 1);
    }
}

