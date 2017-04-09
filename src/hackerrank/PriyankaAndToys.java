package hackerrank;

import java.util.Scanner;

public class PriyankaAndToys {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        boolean weights[] = new boolean[10001];
        for (int i = 0; i < N; i++) {
            int w=in.nextInt();
            weights[w] = true;
        }
        int start = -1;
        int coin = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i]) {
                if (start == -1 || i - start > 4) {
                    start = i;
                    coin++;
                }
            }
        }
        System.out.println(coin);
    }
}
