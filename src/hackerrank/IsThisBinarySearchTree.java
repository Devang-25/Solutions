package hackerrank;

public class IsThisBinarySearchTree {
    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < max && root.data < min)
            return checkBST(root.left, min, root.data) && checkBST(root.right, min, root.data);
        return false;
    }
}

class Node {
    int data;
    Node left;
    Node right;
}
