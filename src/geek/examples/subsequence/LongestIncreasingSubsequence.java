package geek.examples.subsequence;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        final int lis = new LongestIncreasingSubsequence().lis(new int[]{50, 3, 10, 7, 40, 80});
        System.out.println(lis);
    }

    public int lis(int v[]) {
        int lis[] = new int[v.length];
        lis[0] = 1;
        for (int i = 1; i < v.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (v[i] > v[j]) {
                    lis[i] = Math.max(1 + lis[j], lis[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }
}
