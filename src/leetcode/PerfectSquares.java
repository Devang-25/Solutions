package leetcode;

public class PerfectSquares {


    public static void main(String[] args) {
        final int r = new PerfectSquares().numSquares(13);
        System.out.println(r);
    }

    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        int l[] = new int[n + 1];
        l[0] = 0;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            l[i] = Integer.MAX_VALUE;
            while (j * j <= i) {
                l[i] = Math.min(l[i], 1 + l[i - j * j]);
                j++;
            }
        }
        return l[n];
    }

}
