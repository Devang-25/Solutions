package leetcode.tree;

public class AddOneRowtoTree {

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

    public static void main(String[] args) {
        //new AddOneRowtoTree().addOneRow()
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode treeNode = new TreeNode(v);
            treeNode.left = root;
            return treeNode;
        }
        addOneRow_(root, v, 1, d);
        return root;
    }

    public void addOneRow_(TreeNode root, int v, int level, int d) {
        if (level == d-1) {
            TreeNode leftNew = new TreeNode(v);
            TreeNode rightNew = new TreeNode(v);
            leftNew.left = root.left;
            rightNew.right = root.right;
            root.left = leftNew;
            root.right = rightNew;
        } else if (root.left != null) {
            addOneRow_(root.left, v, level + 1, d);
        } else if (root.right != null) {
            addOneRow_(root.right, v, level + 1, d);
        }
    }

}
