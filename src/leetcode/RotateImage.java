package leetcode;

public class RotateImage {

    public static void main(String[] args) {
        final int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        print(matrix);
        System.out.println();
        new RotateImage().rotate(matrix);

        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        final int n = matrix.length;
        for (int i = 0; i <= n / 2; i++) {
            rotate(matrix, i, n - 2 * i, n);
        }
    }

    private void rotate(int[][] matrix, int i, int n, int N) {
        for (int j = i; j < i + n - 1; j++) {
            int a = i;
            int b = j;
            int prev = matrix[a][b];
            int copy;
            System.out.println(a + "," + b);
            for (int t = 1; t <= 4; t++) {
                int x = a;
                a = b;
                b = N - 1 - x;
                System.out.println(a + "," + b);
                copy = matrix[a][b];
                matrix[a][b] = prev;
                prev = copy;
            }
        }
        print(matrix);
        System.out.println();


    }
}
