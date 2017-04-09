
package datastructures.redBlackTrees;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import datastructures.redBlackTrees.RBNode.Color;

/**
 *
 * @author gopimac
 */
public class SimpleBinaryTree extends GenericTree<RBNode> {

    List<LinkedList<RBNode>> pathList = new LinkedList<>();
    List<LinkedList<Node<Node>>> pathlist2 = new LinkedList<>();
    int pre[];
    int in[];

    private SimpleBinaryTree(RBNode root) {
        super.root = root;
    }

    @Override
    public RBNode getNodeInstance(int val) {
        return new RBNode(val, Color.RED);
    }

    interface NodeCondition {

        public boolean checkOnNode(Node<RBNode> node);

        public void apply();

        public int get();
    }

    class leaveCondition implements NodeCondition {

        private int leave;

        public boolean checkOnNode(Node<RBNode> node) {
            if (node.left == null && node.right == null) {
                return true;
            }
            return false;
        }

        public void apply() {
            leave++;
        }

        public int get() {
            return leave;
        }
    }

    public SimpleBinaryTree() {
    }

    public SimpleBinaryTree(Collection<Integer> collection) {
        super(collection);
    }

    public void levelOrder() {
        LinkedList<RBNode> queue = new LinkedList<>();
        System.out.println("level order:");
        RBNode current = null;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            current = queue.removeFirst();
            System.out.println(current.val);
            if (current.left != null) {
                queue.addLast(current.left);
            }
            if (current.right != null) {
                queue.addLast(current.right);
            }
        }
        queue = null;
    }

    public void levelOrderTraversalInReverse() {
        System.out.println("ReverseLevelTransversal");
        LinkedList<RBNode> stack = new LinkedList<>();
        LinkedList<RBNode> queue = new LinkedList<>();
        RBNode node = super.root;
        queue.addLast(node);
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            if (node.right != null) {
                queue.addLast(node.right);
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + "\t");
        }
    }

    private int getHeight(RBNode node) {
        if (node == null) {
            return 0;
        }
        int hL = this.getHeight(node.left);
        int hR = this.getHeight(node.right);
        int hMax = (hL > hR) ? hL : hR;
        return hMax + 1;
    }

    public int getHeight() {
        return this.getHeight(super.root) - 1;
    }

    public int getHeightNonRecursive() {
        int level = 0;
        LinkedList<RBNode> queue = new LinkedList<>();
        queue.addLast(this.root);
        queue.addLast(null);
        RBNode temp = this.root;
        while (!queue.isEmpty()) {
            temp = queue.removeFirst();
            if (temp == null) {
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                } else {
                    return level;
                }
                level++;
            } else {
                if (temp.left != null) {
                    queue.addLast(temp.left);
                }
                if (temp.right != null) {
                    queue.addLast(temp.right);
                }
            }
        }
        return level;
    }

    public RBNode getDeepestNode() {
        LinkedList<RBNode> queue = new LinkedList<>();
        RBNode node = super.root;
        queue.addLast(node);
        RBNode prev = null;
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
            prev = node;
        }
        return prev;
    }

    class fullNodeCondition implements NodeCondition {

        int fullNodeCount;

        public boolean checkOnNode(Node<RBNode> node) {
            if (node.left != null && node.right != null) {
                return true;
            }
            return false;
        }

        public void apply() {
            this.fullNodeCount++;
        }

        public int get() {
            return fullNodeCount;
        }
    }

    private int getNodeCount(NodeCondition nc) {
        RBNode temp = super.root;
        LinkedList<RBNode> queue = new LinkedList<>();
        int count = 0;
        queue.addLast(temp);
        while (!queue.isEmpty()) {
            temp = queue.removeFirst();
            if (nc.checkOnNode(temp)) {
                nc.apply();
            }
            if (temp.left != null) {
                queue.addLast(temp.left);
            }
            if (temp.right != null) {
                queue.addLast(temp.right);
            }
        }
        return nc.get();
    }

    public int getLeaveCount() {
        return this.getNodeCount(new leaveCondition());
    }

    public int getFullNodeCount() {
        return this.getNodeCount(new fullNodeCondition());
    }

    public <M extends Node<M>, N extends Node<N>> boolean isStructurallyIdenticalTo(Node<M> node1, Node<N> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (this.isStructurallyIdenticalTo(node1.right, node2.right) && this.isStructurallyIdenticalTo(node1.left, node2.left));
    }

    public <N extends Node<N>> boolean isStructurallyTo(GenericTree<N> tree) {
        return this.isStructurallyIdenticalTo(this.root, tree.root);
    }

    public int getLevelWithMaxSum() {
        int level = 0;
        int sum = 0;
        int curLevelSum = 0;
        int curLevel = 0;
        RBNode node = super.root;
        LinkedList<RBNode> queue = new LinkedList<>();
        queue.addLast(super.root);
        queue.addLast(null);
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            if (node == null) {
                System.out.println("Current Level Sum is:" + curLevelSum);
                if (curLevelSum > sum) {
                    sum = curLevelSum;
                    level = curLevel;
                }
                curLevelSum = 0;
                if (!queue.isEmpty()) {
                    queue.addLast(null);
                }
                curLevel++;
            } else if (node != null) {
                curLevelSum += node.val;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        System.out.println(sum);
        return level;
    }

    //print out all route to leave paths..
    void Path(RBNode node, LinkedList<RBNode> base) {
        base.addLast(node);
        if (node.left != null) {
            this.Path(node.left, (LinkedList<RBNode>) base.clone());
        }
        if (node.right != null) {
            this.Path(node.right, (LinkedList<RBNode>) base.clone());
        }
        if (node.left == null && node.right == null) {
            this.pathList.add(base);
        }
    }

    public List<LinkedList<RBNode>> getPathList() {
        this.Path(super.root, new LinkedList<RBNode>());
        return this.pathList;
    }

    public boolean isPathForSum(int sum) {
        return this.isPathForSum(super.root, sum);
    }

    private boolean isPathForSum(RBNode node, int sum) {
        if (node == null) {
            return (sum == 0);
        } else {
            int remSum = sum - node.val;
            return (isPathForSum(node.left, remSum) || isPathForSum(node.right, remSum));
        }
    }

    private int add(Node<Node> node) {
        if (node == null) {
            return 0;
        } else {
            return node.val + this.add(node.left) + this.add(node.right);
        }
    }

    public int add_() {
        Node<? extends Node> node = this.root;
        int sum = 0;
        LinkedList<Node<? extends Node>> queue = new LinkedList<Node<? extends Node>>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            sum += node.val;
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return sum;
    }

    public SimpleBinaryTree getMirrorTree() {
        return new SimpleBinaryTree(this.getMirror(super.root));
    }

    private RBNode getMirror(RBNode node) {
        RBNode newNode = null;
        if (node != null) {
            newNode = new RBNode();
            newNode.val = node.val;
            newNode.left = this.getMirror(node.right);
            newNode.right = this.getMirror(node.left);
        }
        return newNode;
    }

    public SimpleBinaryTree getBinaryTree(int[] inOrder, int[] preOrder) {
        return new SimpleBinaryTree(this.getBinaryTreeNode(inOrder, preOrder));
    }

    public SimpleBinaryTree getBinaryTree_(int[] inOrder, int[] preOrder) {
        this.pre = preOrder;
        this.in = inOrder;
        System.out.println("\nSubtree_ using preOrder and inOrder");
        return new SimpleBinaryTree(this.getBinaryTreeNode_(new Bounds(0, inOrder.length - 1), new Bounds(0, preOrder.length - 1)));
    }

    RBNode getBinaryTreeNode(int[] inOrder, int[] preOrder) {
        System.out.println("Length :" + inOrder.length + ":" + preOrder.length);
        int length = inOrder.length;
        int pN = preOrder[0];
        RBNode node = null;
        System.out.println("");
        for (int i = 0; i < inOrder.length; i++) {
            if (pN == inOrder[i]) {
                int lowerIn[] = Arrays.copyOfRange(inOrder, 0, i);
                System.out.println("lowerIn");
                display(lowerIn);
                int upperIn[] = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);
                System.out.println("UpperIn");
                display(upperIn);
                int lowerPre[] = Arrays.copyOfRange(preOrder, 1, 1 + lowerIn.length);
                System.out.println("lower pre");
                display(lowerPre);
                int upperPre[] = Arrays.copyOfRange(preOrder, 1 + lowerIn.length, 1 + lowerIn.length + upperIn.length);
                System.out.println("upper pre");
                display(upperPre);
                node = new RBNode();
                node.val = pN;
                if (lowerIn.length == 0) {
                    node.left = null;
                } else if (lowerIn.length == 1) {
                    node.left = new RBNode();
                    node.left.val = lowerIn[0];
                } else {
                    node.left = this.getBinaryTreeNode(lowerIn, lowerPre);
                }
                if (upperIn.length == 0) {
                    node.right = null;
                } else if (upperIn.length == 1) {
                    node.right = new RBNode();
                    node.right.val = upperIn[0];
                } else {
                    node.right = this.getBinaryTreeNode(upperIn, upperPre);
                }
            }
        }
        return node;
    }

    RBNode getBinaryTreeNode_(Bounds inOrderB, Bounds preOrderB) {
        int pN = pre[preOrderB.getLowerBound()];
        RBNode node = null;
        for (int i = inOrderB.getLowerBound(); i <= inOrderB.getUpperBound(); i++) {
            if (pN == in[i]) {
                Bounds lIn = new Bounds(inOrderB.getLowerBound(), i - 1);
                Bounds uIn = new Bounds(i + 1, inOrderB.getUpperBound());
                Bounds lPre = new Bounds(preOrderB.getLowerBound() + 1, preOrderB.getLowerBound() + lIn.length());
                Bounds uPre = new Bounds(1 + preOrderB.getLowerBound() + lIn.length(), preOrderB.getLowerBound() + lIn.length() + uIn.length());
                node = new RBNode();
                node.val = pN;
                if (lIn.length() == 0) {
                    node.left = null;
                } else if (lIn.length() == 1) {
                    node.left = new RBNode();
                    node.left.val = in[lIn.getLowerBound()];
                } else {
                    node.left = this.getBinaryTreeNode_(lIn, lPre);
                }
                if (uIn.length() == 0) {
                    node.right = null;
                } else if (uIn.length() == 1) {
                    node.right = new RBNode();
                    node.right.val = in[uIn.getLowerBound()];
                } else {
                    node.right = this.getBinaryTreeNode_(uIn, uPre);
                }
            }
        }
        return node;
    }

    void display(int[] a) {
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println("");
    }

    public void printAllAncestors(int val) {
        this.printAllAncestors(super.root, val);
    }

    private boolean printAllAncestors(Node<? extends Node> node, int val) {
        /*check if the node whose ancestors to be printed is left of the given node,
         *or right of the given node or down the left branch of
         *the node or the right branch of the node.
         */
        if (node == null) {
            return false;
        }
        if (node.left != null) {
            if (node.left.val == val) {
                System.out.println("\nAncestor is:" + node.val);
                return true;
            }
        }
        if (node.right != null) {
            if (node.right.val == val) {
                System.out.println("\nAncestor is:" + node.val);
                return true;
            }
        }
        if (this.printAllAncestors(node.left, val) || this.printAllAncestors(node.right, val)) {
            System.out.println("\nAncestor is:" + node.val);
            return true;
        }
        return false;
    }
    //assuming its a binary search tree

    public int findLeastCommonAncestor(int v1, int v2) {
        Node<? extends Node> node = super.root;
        while (node != null) {
            if (v1 == node.val || v2 == node.val) {
                break;
            }
            if ((v1 > node.val && v2 > node.val)) {
                node = node.right;
            } else if (v1 < node.val && v2 < node.val) {
                node = node.left;
            } else if ((v1 < node.val && v2 > node.val) || (v1 > node.val && v2 < node.val)) {
                return ((this.search(v2).getSecond() != null) && this.search(v1).getSecond() != null) ? node.val : -1;
            }
        }
        int toSearch = (node.val == v1) ? v2 : v1;
        System.out.println("searching:" + toSearch);
        return (super.search(toSearch).getSecond() != null) ? node.val : -1;
    }

    public int findLeastCommonAncestor_(int v1, int v2) {
        return this.findLeastCommonAncestor_(this.root, v1, v2);
    }
//faulty code..not tested yet...

    private int findLeastCommonAncestor_(RBNode node, int v1, int v2) {
        if (node == null) {
            return -1;
        }

        if (node.val == v1 || node.val == v2) {
            return node.val;
        }
        int l = this.findLeastCommonAncestor_(node.left, v1, v2);
        int r = this.findLeastCommonAncestor_(node.right, v1, v2);
        if (l != -1 && r != -1) {
            return node.val;
        }
        return -1;
    }

    public void zigZagOrder() {
        LinkedList<RBNode> one = new LinkedList<>();
        LinkedList<RBNode> other = new LinkedList<>();
        RBNode node = super.root;
        one.push(node);
        boolean lToR = true;
        while (!one.isEmpty()) {
            node = one.pop();
            if (node != null) {
                System.out.print(node.val + "\t");
                if (lToR) {
                    if (node.left != null) {
                        other.push(node.left);
                    }
                    if (node.right != null) {
                        other.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        other.push(node.right);
                    }
                    if (node.left != null) {
                        other.push(node.left);
                    }
                }
            }
            if (one.isEmpty()) {
                LinkedList<RBNode> temp = one;
                one = other;
                other = temp;
                lToR = lToR ? false : true;
            }
        }
        System.out.println("\nReaching the end:Both stacks empty");
    }

    public void inOrder_() {
        RBNode node = super.root;
        while (node != null) {
            System.out.println(node.val);
            node = this.getInOrderSuccessor(node);

        }
    }
    private LinkedList<RBNode> stack_local = new LinkedList<>();
//a bit incomplete but correct in itself.

    private RBNode getInOrderSuccessor(RBNode node) {
        RBNode temp = null;
        if (node != null) {
            temp = node;
        }
        if (temp.right == null) {
            if (!stack_local.isEmpty()) {
                temp = stack_local.pop();
            } else {
                return null;
            }
        } else {
            temp = temp.right;
            while (temp.left != null) {
                stack_local.push(temp);
                temp = temp.left;
            }
        }
        return temp;
    }

    public Iterator<Integer> getDoubleCircularLinkedList() {
        final SimpleBinaryTree tree = new SimpleBinaryTree(super.copyTree(super.root));
        RBNode node = tree.root;
        tree.preOrder();
        while (node.left != null) {
            System.out.println("\nroot value " + tree.root.val);
            int nodeVal = node.val;
            tree.deleteNode_(node, node);
            tree.root = node;
            tree.insert(nodeVal);
            if (node.right == null) {
                nodeVal = node.val;
                node = node.left;
                tree.root = node;
                tree.insert(nodeVal);
            }
            tree.preOrder();
        }
        System.out.println("Finally");
        tree.inOrder();
        RBNode t = tree.root;
        System.out.println("\nEnsuring that evrything is well established ");
        while (t != null) {
            System.out.print(t.val + ":" + t.left + "\t");
            t = t.right;
        }
        t = tree.root;
        while (t.right != null) {
            t.right.left = t;
            t = t.right;
        }
        t.right = tree.root;
        tree.root.left = t;
        // <editor-fold defaultstate="collapsed" desc="comment">
        System.out.println("done");
        RBNode i = tree.root;
        while (i.right != tree.root) {
            System.out.println(i.val + ":" + i.right.left.val);
            i = i.right;
        }// </editor-fold>
        return new Iterator<Integer>() {

            RBNode i = tree.root.left;
            boolean hasNextCalled = false;

            public boolean hasNext() {
                this.hasNextCalled = true;
                if (i.right != tree.root.right) {
                    return true;
                }
                return false;
            }

            public Integer next() {
                if (hasNextCalled) {
                    int val = i.val;
                    i = i.right;
                    this.hasNextCalled = false;
                    return val;
                }
                throw new IllegalStateException("hasNext() method must be called before next()");
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }

    private void deleteNode_(final RBNode node, RBNode parent) {
        if (node.left != null && node.right != null) {
            System.out.println("Always 1st case");
            parent = node;
            RBNode xSuccessor = node.right;
            System.out.println("successor is:" + xSuccessor.val);
            while (xSuccessor.left != null) {
                parent = xSuccessor;
                xSuccessor = xSuccessor.left;
            }
            node.val = xSuccessor.val;
            this.deleteNode_(xSuccessor, parent);
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println("no childer:" + node.val);
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return;
        }
        if (node.left == null && node.right != null) {
            if (parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
            System.out.println("deleted one childer");
            return;
        }
        if (node.left != null && node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
            System.out.println("deleted one childer");
            return;
        }
    }

    public void printBetween(int k1, int k2) {
        this.printBetween(this.root, k1, k2);
    }

    private void printBetween(RBNode root, int k1, int k2) {
        //recursive version
        if (root != null) {
            if (root.val >= k1) {
                this.printBetween(root.left, k1, k2);
            }
            if (root.val <= k2) {
                this.printBetween(root.right, k1, k2);
            }
            if (root.val >= k1 && root.val <= k2) {
                System.out.print(root.val + "\t");
            }
        }
    }

    public void printBetween_(int k1, int k2) {
        //would give numbers in the increasing order of their levels
        LinkedList<RBNode> queue = new LinkedList<>();
        queue.addLast(this.root);
        RBNode node = this.root;
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            if (node.val >= k1 && node.val <= k2) {
                System.out.print(node.val + "\t");
            }
            if (node.left != null && node.val > k1) {
                queue.addLast(node.left);
            }
            if (node.right != null && node.val < k2) {
                queue.addLast(node.right);
            }
        }
    }

    public void printBetween__(int k1, int k2) {
        RBNode node = this.root;
        while (node.left != null) {
            stack_local.push(node);
            node = node.left;
        }
        while (node.val < k1) {
            node = this.getInOrderSuccessor(node);
        }
        while (node.val <= k2) {
            System.out.print(node.val + "\t");
            node = this.getInOrderSuccessor(node);
        }
    }
}
