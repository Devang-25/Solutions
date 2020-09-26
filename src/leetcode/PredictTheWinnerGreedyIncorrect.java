package leetcode;

public class PredictTheWinnerGreedyIncorrect {

    public static void main(String[] args) {
        final boolean result = new PredictTheWinnerGreedyIncorrect().PredictTheWinner(new int[]{1, 5, 233, 7});
        System.out.println(result);
    }

    public boolean PredictTheWinner(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int p1_score = 0;
        int p2_score = 0;
        int turn = 1;
        while (i <= j) {
            if (nums[i] > nums[j]) {
                if (turn == 1) {
                    p1_score += nums[i];
                    turn = 2;
                } else {
                    p2_score += nums[i];
                    turn = 1;
                }
                i++;
            } else {
                if (turn == 1) {
                    p1_score += nums[j];
                    turn = 2;
                } else {
                    p2_score += nums[j];
                    turn = 1;
                }
                j--;
            }
        }
        return p1_score > p2_score;
    }

}
