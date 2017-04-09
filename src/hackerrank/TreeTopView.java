package hackerrank;


import java.util.Stack;

public class TreeTopView {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null, new Node(9, null, null));
        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, node1, node4);

        Node node7 = new Node(7, new Node(6, null, null), null);
        Node node6 = new Node(4, null, null);
        Node node2 = new Node(2, node6, node7);
        Node node3 = new Node(3, node5, node2);
        top_view(node3);


    }

    private static void top_view(Node root) {
        if (root == null) {
            return;
        }
        Node cir = root;
        Stack<Integer> stack = new Stack();
        while (cir != null) {
            stack.push(cir.data);
            cir = cir.left;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        cir = root.right;
        while (cir != null) {
            System.out.print(cir.data + " ");
            cir = cir.right;
        }

    }


}
