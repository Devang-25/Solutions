package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class MaximalSquare {
    public static void main(String[] args) {
        final int x = new MaximalSquare().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        System.out.println(x);
    }

    public int maximalSquare(char[][] matrix) {
        int mxSq[][] = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            mxSq[0][i] = (matrix[0][i] == '1') ? 1 : 0;
            if (mxSq[0][i] == 1) {
                max = 1;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            mxSq[i][0] = (matrix[i][0] == '1') ? 1 : 0;
            if (mxSq[i][0] == 1) {
                max = 1;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    mxSq[i][j] = 0;
                } else {
                    mxSq[i][j] = Collections.min(Arrays.asList(mxSq[i - 1][j - 1], mxSq[i][j - 1], mxSq[i - 1][j])) + 1;
                    if (mxSq[i][j] > max) {
                        max = mxSq[i][j];
                    }
                }
            }
        }
        return max * max;
    }
}
