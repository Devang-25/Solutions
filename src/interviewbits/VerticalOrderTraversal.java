package interviewbits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        TreeNode root2=new TreeNode(2);
        TreeNode root3=new TreeNode(3);
        TreeNode root4=new TreeNode(4);
        TreeNode root5=new TreeNode(5);
        root1.left=root2;
        root1.right=root3;
        root3.left=root4;
        root4.right=root5;
        ArrayList<ArrayList<Integer>> arrayLists = verticalOrderTraversal(root1);
        System.out.println(arrayLists);
    }

    private static final Map<Integer, ArrayList<Integer>> verticalOrder = new HashMap<>();
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        process(A, 0);
        ArrayList<ArrayList<Integer>> order = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            ArrayList<Integer> integers = verticalOrder.get(i);
            Integer last = integers.get(integers.size() - 1);
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(last);
            order.add(temp);
        }
        return order;
    }

    public static void process(TreeNode treeNode, int disp) {
        if (max < disp) {
            max = disp;
        }
        if (min > disp) {
            min = disp;
        }
        verticalOrder.putIfAbsent(disp, new ArrayList<>());
        verticalOrder.get(disp).add(treeNode.val);
        if (treeNode.left != null) {
            process(treeNode.left, disp - 1);
        }
        if (treeNode.right != null) {
            process(treeNode.right, disp + 1);
        }
    }
}
