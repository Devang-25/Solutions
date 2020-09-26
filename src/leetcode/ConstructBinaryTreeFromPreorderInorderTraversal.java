package leetcode;


import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderInorderTraversal {

    public static void main(String[] args) {
        final TreeNode treeNode = new ConstructBinaryTreeFromPreorderInorderTraversal().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preOrderS, int preOrderE, int[] inorder, int inOrderS, int inOrderE) {
        if (preOrderS == preOrderE) {
            return new TreeNode(preorder[preOrderS]);
        }
        final int v = preorder[preOrderS];
        final int index = search(inorder, v);
        final TreeNode root = new TreeNode(v);
        if (index == inOrderS) {
            root.right = buildTree(preorder, preOrderS + 1, preOrderE, inorder, index + 1, inOrderE);
        } else if (index == inOrderE) {
            root.left = buildTree(preorder, preOrderS + 1, preOrderE, inorder, inOrderS, index - 1);
        } else {
            root.left = buildTree(preorder, preOrderS + 1, preOrderS + index - inOrderS, inorder, inOrderS, index - 1);
            root.right = buildTree(preorder, preOrderS + index - inOrderS + 1, preOrderE, inorder, index + 1, inOrderE);
        }
        return root;
    }

    private int search(int[] inorder, int v) {
        int index = -1;
        for (int i = 0; (i < inorder.length) && (index == -1); i++) {
            if (inorder[i] == v) {
                index = i;
            }
        }
        return index;
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

        @Override
        public String toString() {
            final String left = this.left != null ? " L {" + this.left + "}" : "";
            final String right = this.right != null ? " R {" + (this.right) + "}" : "";
            return this.val + left + right;
        }
    }
}
