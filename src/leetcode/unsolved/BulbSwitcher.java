package leetcode.unsolved;

public class BulbSwitcher {


    public static void main(String[] args) {
        final int result = new BulbSwitcher().bulbSwitch(1);
        System.out.println(result);
    }

    public int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        for (int i = 1; i <= n; i++) {
            int k = i;
            while (k <=n) {
                bulbs[k - 1] = !bulbs[k - 1];
                k = k + i;
            }
        }
        int on = 0;
        for (int i = 0; i < n; i++) {
            if (bulbs[i]) {
                on++;
            }
        }
        return on;
    }


}
