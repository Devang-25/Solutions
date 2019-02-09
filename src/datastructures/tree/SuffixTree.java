package datastructures.tree;

public class SuffixTree {
    private String text = null;

    public static void main(String[] args) {
        String cagtcagg = "cagtcagg";
        SuffixTree tree = new SuffixTree(cagtcagg);
        tree.add(cagtcagg);
    }

    public SuffixTree(String text) {
        this.text = text;
    }

    private SuffixNode root = null;

    public void add(String s) {
        root = new SuffixNode(-1, -1);
        char sChar[] = s.toCharArray();
        for (int i = sChar.length - 1; i >= 0; i--) {
            System.out.println("Adding suffix :" + text.substring(i));
            root.add(i, i);

        }
    }

    public int[] findPattern(String pattern) {
        SuffixNode node = this.root;
        if (this.root.children[pattern.charAt(0) - 97] == null) {
            return new int[]{};
        }
        return this.root.children[pattern.charAt(0) - 97].search(pattern, 0);

    }

    class SuffixNode {
        int start;
        int end;
        int init;
        boolean isLeaf = false;
        SuffixNode[] children = new SuffixNode[26];

        public SuffixNode(int s, int e) {
            this.start = s;
            this.end = e;
            System.out.println("Creating suffix Node :"
                    + (s != -1 ? text.substring(start, end + 1) : ""));
        }

        public int[] search(String pattern, int i) {
            int s = start;
            for (; i < text.length() && s <= end; s++) {
                if (pattern.charAt(i) != ch(s)) {
                    break;
                }
                i++;
            }
            if (s == end + 1) {
                // consumed with the node.
                if (this.children[pattern.charAt(i) - 97] != null) {
                    return this.children[pattern.charAt(i) - 97].search(pattern, i);
                }
                return new int[]{};
            }
            if (i == text.length()) {
                //our pattern is exhausted.

            }
            return null;
        }

        public void add(int i, int init) {
            System.out.println("Adding " + text.charAt(i) + ";" + i);
            int j = start;
            if (start != -1) {
                while (i != text.length() && j <= end
                        && text.charAt(j) == text.charAt(i)) {
                    j++;
                    i++;
                }
            }
            if (i == text.length()) {
                this.init = init;
                isLeaf = true;
            } else if (j == end + 1) {
                SuffixNode newNode = new SuffixNode(i, text.length() - 1);
                children[ch(i)] = newNode;
            } else if (children[ch(i)] == null) {
                SuffixNode newNode = new SuffixNode(i, text.length() - 1);
                if (j != start) {
                    SuffixNode newNode2 = new SuffixNode(j, end);
                    this.end = j - 1;
                    System.out.println("This node reduced to "
                            + text.substring(start, this.end + 1));
                    children[ch(i)] = newNode2;
                }
                children[ch(i)] = newNode;
            } else {
                children[ch(i)].add(i, start);
            }

        }
    }

    private int ch(int i) {
        return text.charAt(i) - 97;
    }
}
