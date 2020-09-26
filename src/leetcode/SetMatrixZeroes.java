package leetcode;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean br[] = new boolean[matrix.length];
        boolean bc[] = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    br[i] = true;
                    bc[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (br[i] | bc[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
