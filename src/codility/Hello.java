package codility;

public class Hello {

    public static void main(String[] args) {

        Tree None = null;
        Tree tree = new Tree(1, new Tree(2, None, new Tree(4, None, None)), new Tree(3, new Tree(5, new Tree(7, None, None), new Tree(8, None, None)), new Tree(6, new Tree(9, None, None), new Tree(10, new Tree(11, None, None), None))));
        Hello hello = new Hello();
        int solution = hello.solution(tree);
        System.out.println(solution);

    }

    public int solution(Tree t) {
        process(t);
        return max;
    }

    int max = Integer.MIN_VALUE;

    public int process(Tree t) {
        // write your code in Java SE 8
        if (t == null) {
            return 0;
        }
        int result_left = process(t.l);
        int result_right = process(t.r);
        max = Math.max(max, result_left);
        max = Math.max(max, result_right);
        if (result_left == result_right) {
            int v = 2 * result_left + 1;
            //System.out.println(v);
            return v;
        }
        return (t.l != null && t.r != null) ? 3 : 1;
    }


    static class Tree {
        public int x;
        public Tree l;
        public Tree r;

        public Tree(int x, Tree l, Tree r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }
    }
}
