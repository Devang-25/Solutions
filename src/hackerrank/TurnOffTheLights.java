package hackerrank;

import java.util.Scanner;

public class TurnOffTheLights {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        answer(c, k);
    }

    private static void answer(final int c[], final int k) {
        long ans = Long.MAX_VALUE;
        for (int st = 0; st <= k && st < c.length; st++) {
            int la = 0;
            long co = 0;
            for (int i = st; i < c.length; i += 2 * k + 1) {
                co += c[i];
                la = i;
            }

            if (c.length - la <= k + 1) ans = Math.min(ans, co);
        }

        System.out.println(ans);
    }
}
