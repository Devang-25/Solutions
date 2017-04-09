package hackerrank;

public class HuffmanEncoding {


    static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;

        public Node(char data, Node left, Node right, int frequency) {
            this.data = data;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node root_right = new Node('A', null, null, 3);

        Node root_left_left = new Node('B', null, null, 1);
        Node root_right_right = new Node('C', null, null, 1);
        Node root_left = new Node('#', root_left_left, root_right_right, 2);
        Node root = new Node('#', root_left, root_right, 5);
        new HuffmanEncoding().decode("1001011", root);
    }


    void decode(String S, Node root) {
        StringBuilder sb = new StringBuilder();
        Node c = root;
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i) == '1' ? c.right : c.left;
            if (c.left == null && c.right == null) {
                sb.append(c.data);
                c = root;
            }
        }
        System.out.print(sb);
    }


}




