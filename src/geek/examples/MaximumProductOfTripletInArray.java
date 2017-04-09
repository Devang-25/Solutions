package geek.examples;

public class MaximumProductOfTripletInArray {

    public static void main(String[] args) {
        int arr[] = {1, -4, 3, -6, 7, 0};
        long max2 = getMin(arr);
        long max1 = getMax(arr);
        System.out.println(Math.max(max1, max2));
    }

    static long getMax(int arr[]) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = right[arr.length - 1] = -1;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(maxLeft, arr[i - 1]);
            maxLeft = left[i];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(maxRight, arr[i + 1]);
            maxRight = right[i];
        }
        long maxProduct = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            maxProduct = Math.max(maxProduct, arr[i] * left[i] * right[i]);
        }
        return maxProduct;
    }


    static long getMin(int arr[]) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = right[arr.length - 1] = -1;
        int maxLeft = Integer.MAX_VALUE;
        int maxRight = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.min(maxLeft, arr[i - 1]);
            maxLeft = left[i];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.min(maxRight, arr[i + 1]);
            maxRight = right[i];
        }
        long maxProduct = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length - 1; i++) {
            maxProduct = Math.max(maxProduct, arr[i] * left[i] * right[i]);
        }
        return maxProduct;
    }
}
