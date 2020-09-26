package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        final List<TreeNode> nodes = new UniqueBinarySearchTrees().trees(0, 4);
    }

    public class TreeNode {
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


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return trees(1, n);
    }

    List<TreeNode> trees(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtree = trees(start, i - 1);

            List<TreeNode> rightSubtree = trees(i + 1, end);

            for (int j = 0; j < leftSubtree.size(); j++) {
                TreeNode left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    TreeNode right = rightSubtree.get(k);
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
