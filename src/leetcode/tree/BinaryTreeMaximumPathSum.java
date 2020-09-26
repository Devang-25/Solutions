package leetcode.tree;

import java.util.Arrays;
import java.util.Collections;

public class BinaryTreeMaximumPathSum {


    public static void main(String[] args) {
        final int result = new BinaryTreeMaximumPathSum().maxPathSum(new TreeNode(-1, null, new TreeNode(9, new TreeNode(-6), new TreeNode(3, null, new TreeNode(-2)))));
        System.out.println(result);
    }

    public int maxPathSum(TreeNode root) {
        final int[] result = maxPathSum_(root);
        return Math.max(result[0], result[1]);
    }

    private int[] maxPathSum_(TreeNode root) {

        if (root.right != null && root.left != null) {
            int[] left = maxPathSum_(root.left);
            int leftHistory = left[1];
            int leftExtended = left[0];
            int[] right = maxPathSum_(root.right);

            int rightHistory = right[1];
            int rightExtended = right[0];
            int h_ = Collections.max(Arrays.asList(leftHistory, rightHistory, leftExtended + root.val, rightExtended + root.val, leftExtended + rightExtended + root.val, root.val));
            int e_ = Collections.max(Arrays.asList(root.val, rightExtended + root.val, leftExtended + root.val));
            return new int[]{e_, h_};
        } else if (root.right != null) {
            int[] right = maxPathSum_(root.right);

            int rightHistory = right[1];
            int rightExtended = right[0];
            int h_ = Collections.max(Arrays.asList(rightHistory, rightExtended + root.val, root.val));
            int e_ = Collections.max(Arrays.asList(root.val, rightExtended + root.val));
            return new int[]{e_, h_};
        } else if (root.left != null) {
            int[] left = maxPathSum_(root.left);
            int leftHistory = left[1];
            int leftExtended = left[0];
            int h_ = Collections.max(Arrays.asList(leftHistory, leftExtended + root.val, root.val));
            int e_ = Collections.max(Arrays.asList(root.val, leftExtended + root.val));
            return new int[]{e_, h_};
        } else {
            return new int[]{root.val, root.val};
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
