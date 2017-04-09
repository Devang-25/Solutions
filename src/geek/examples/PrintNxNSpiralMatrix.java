package geek.examples;

public class PrintNxNSpiralMatrix {
    public static void main(String[] args) {
        int n = 5;
        int arr[][] = new int[n][n];
        int x = n / 2;
        int y = n / 2;
        int num = 2;
        int xs = x;
        int ys = y;
        for (int cycle = 0; cycle < n / 2; cycle++) {
            ys = ys - 1;
            for (int j = 1; j <= 2 * cycle + 1; j++) {
                arr[xs + j][ys] = num++;
            }
            ys++;
            for (int j = 1; j <= 2 * cycle; j++) {
                arr[xs][ys + j] = num++;
            }
            xs--;
            for (int j = 1; j <= 2 * cycle; j++) {
                arr[xs - j][ys] = num++;
            }
            ys--;
            for (int j = 1; j <= 2 * cycle; j++) {
                arr[xs][ys - j] = num++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i][j] + "\t");
            }
        }
    }
}
