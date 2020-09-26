package leetcode;

public class ArithmeticSlices {

    public static void main(String[] args) {
        final int i = new ArithmeticSlices().numberOfArithmeticSlices(new int[]{1,  3, 5, 7, 9});
        System.out.println(i);
    }

    public int numberOfArithmeticSlices(int[] A) {
        int diff[] = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            diff[i - 1] = A[i] - A[i - 1];
        }
        int count = 1;
        int total = 0;
        for (int i = 1; i < diff.length; i++) {
            if (diff[i] == diff[i - 1]) {
                count++;
            } else {
                total += compute(count);
                count = 1;
            }
        }
        if (count > 1) {
            total += compute(count);
        }
        return total;
    }

    private int compute(int count) {
        int sum = 0;
        final int num = count + 1;
        for (int i = 3; i <= num; i++) {
            final int v = (num - i) + 1;
            sum += v;
        }
        return sum;
    }
}
