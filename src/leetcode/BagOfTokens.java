package leetcode;

import java.util.Arrays;

public class BagOfTokens {


    public static void main(String[] args) {
        final int score = new BagOfTokens().bagOfTokensScore(new int[]{100}, 50);
        System.out.println(score);
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int points = 0, ans = 0;
        while (left <= right && (points > 0 || P >= tokens[left])) {
            while (left <= right && P >= tokens[left]) {
                P -= tokens[left++];
                points++;
            }

            ans = Math.max(ans, points);
            if (left <= right && points > 0) {
                P += tokens[right--];
                points--;
            }
        }

        return ans;
    }
}
