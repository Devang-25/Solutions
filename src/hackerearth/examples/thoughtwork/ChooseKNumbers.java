package hackerearth.examples.thoughtwork;

import java.util.Scanner;

public class ChooseKNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = in.nextInt();
            long S = in.nextLong();

            int maxV = Integer.MIN_VALUE;
            int a[] = new int[N];
            for (int i = 0; i < N; i++) {
                int v = in.nextInt();
                if (v > maxV) {
                    maxV = v;
                }
                a[i] = v;
            }

            long[] E = new long[maxV + 1];
            int H[] = new int[maxV + 1];
            for (int i = 0; i < a.length; i++) {
                H[a[i]]++;
            }
            for (int i = 1; i < E.length; i++) {
                E[i] = E[i - 1] + H[i];
            }
            int i = 0;
            int j = 0;
            long maxK = Long.MIN_VALUE;
            long diff = -1;
            while (i < E.length && j < E.length) {
                if (H[i] == 0) {
                    i++;
                    continue;
                }
                if (H[j] == 0) {
                    j++;
                    continue;
                }
                long k = E[j] - E[i] + H[i];
                long diffK = (j - i) * k;
                if (diffK <= S) {
                    if (maxK < k) {
                        maxK = k;
                        diff = diffK;
                    }
                    j++;
                } else {
                    i++;
                }
            }
            System.out.println(maxK + " " + diff);


        }
    }
}
