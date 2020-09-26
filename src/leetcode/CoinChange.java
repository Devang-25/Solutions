package leetcode;

public class CoinChange {


    public static void main(String[] args) {
        final int result = new CoinChange().coinChange(new int[]{1,2,5}, 11);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        int min[] = new int[amount + 1];
        min[0] = 0;
        for (int i = 1; i <= amount; i++) {
            min[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    final int v = min[i - coins[j]];
                    if(v!=Integer.MAX_VALUE) {
                        min[i] = Math.min(min[i], 1 + v);
                    }
                }
            }
        }
        return min[amount] == Integer.MAX_VALUE ? -1 : min[amount];
    }


}
