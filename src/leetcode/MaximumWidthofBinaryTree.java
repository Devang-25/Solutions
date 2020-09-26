package leetcode;

import geek.examples.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

    public static class TreeNode {
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
        final int width = new MaximumWidthofBinaryTree().widthOfBinaryTree(new TreeNode(1,
                        new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null),
                        new TreeNode(2, null, new TreeNode(9, null, new TreeNode(7)))
                )
        );
        System.out.println(width);
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0, 0));
        int min = 0;
        int max = 0;
        int level = 0;
        int width = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node);
            if (level != node.level) {
                width = Math.max(width, max - min + 1);
                min = node.pos;
                level = node.level;
            } else {
                max = node.pos;
            }
            if (node.treeNode.left != null) {
                queue.add(new Node(node.treeNode.left, level + 1, 2 * node.pos + 1));
            }

            if (node.treeNode.right != null) {
                queue.add(new Node(node.treeNode.right, level + 1, 2 * node.pos + 2));
            }
        }
        return Math.max(width, max - min + 1);
    }


    class Node {
        TreeNode treeNode;
        int level;
        int pos;

        public Node(TreeNode treeNode, int level, int pos) {
            this.treeNode = treeNode;
            this.level = level;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "treeNode=" + treeNode.val +
                    ", level=" + level +
                    ", pos=" + pos +
                    '}';
        }
    }

}
