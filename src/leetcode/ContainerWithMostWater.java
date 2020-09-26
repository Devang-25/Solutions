package leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(arr));
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }
}
