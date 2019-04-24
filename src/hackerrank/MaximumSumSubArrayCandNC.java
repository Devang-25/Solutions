package hackerrank;

import java.util.Scanner;

public class MaximumSumSubArrayCandNC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int maxsum = 0;
            int minNeg = Integer.MIN_VALUE;
            int arr[] = new int[in.nextInt()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextInt();
                if (arr[i] > 0) {
                    maxsum += arr[i];
                }
                if (arr[i] < 0 && arr[i] > minNeg) {
                    minNeg = arr[i];
                }
            }
            int cSum = getMaximumContinuousSubArraySum(arr);
            System.out.println(((cSum == 0) ? minNeg : cSum) + " " + ((maxsum == 0) ? minNeg : maxsum));
        }

    }

    private static int getMaximumContinuousSubArraySum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
}
