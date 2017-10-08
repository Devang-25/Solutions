package hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class IndianJob {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = in.nextInt();
            int g = in.nextInt();
            Integer[] time = new Integer[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                time[arr_i] = in.nextInt();
            }
            Arrays.sort(time, Comparator.reverseOrder());
            System.out.println(Arrays.asList(time));
            int selected = time[0];
            int total = selected;
            int other = 0;
            int i = 1;
            while (total <= g && i < time.length) {
                if (other + time[i] <= selected) {
                    other += time[i];
                } else {
                    total += selected;
                    selected = other + time[i] - selected;
                    other = 0;
                }
                i++;
            }
            if (i == time.length) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
