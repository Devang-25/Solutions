/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.threadedBinaryTrees;

import java.util.Collection;

/**
 *
 * @author gopimac
 */
public class ThreadedBinaryTree {

    class TNode {

        int val;
        boolean isLThreaded;
        TNode l;
        boolean isRThreaded;
        TNode r;

        public TNode(int val, boolean isLThread, TNode l, boolean isRThreaded, TNode r) {
            this.val = val;
            this.isLThreaded = isLThread;
            this.l = l;
            this.isRThreaded = isRThreaded;
            this.r = r;
        }

        public TNode() {
            dummy.l = dummy;
            dummy.r = dummy;
        }
    }
    private TNode dummy = new TNode(-1, true, null, true, null);

    public void insert(Collection<Integer> col) {
        for (int i : col) {
            this.insert(i);
        }
    }

    public boolean insert(int val) {
        if (this.dummy.isLThreaded) {
            TNode newNode = new TNode(val, true, dummy, true, dummy);
            dummy.isLThreaded = false;
            dummy.l = newNode;
            return true;
        }
        TNode node = this.dummy.l;
        while (true) {
            if (val > node.val) {
                if (!node.isRThreaded) {
                    node = node.r;
                } else {
                    TNode newNode = new TNode(val, true, node, true, node.r);
                    node.isRThreaded = false;
                    node.r = newNode;
                    return true;
                }
            } else if (val < node.val) {
                if (!node.isLThreaded) {
                    node = node.l;
                } else {
                    TNode newNode = new TNode(val, true, node.l, true, node);
                    node.isLThreaded = false;
                    node.l = newNode;
                    return true;
                }
            } else if (node.val == val) {
                System.out.println("Duplicates value not allowed");
                return false;
            }
        }
    }

    public TNode getInOrderSuccessor(TNode node) {
        if (node == null) {
            return null;
        }
        if (!node.isRThreaded) {
            TNode t = node.r;
            while (!t.isLThreaded) {
                t = t.l;
            }
            return t;
        } else {
            return node.r;
        }
    }

    private void inOrder(TNode node) {
        TNode inSuccessor = this.getInOrderSuccessor(node);
        while (inSuccessor != dummy) {
            System.out.print(inSuccessor.val + "\t");
            inSuccessor = this.getInOrderSuccessor(inSuccessor);
        }
    }

    public void inOrder() {
        if (dummy.isLThreaded) {
            return;
        }
        TNode node = this.dummy.l;
        while (!node.isLThreaded) {
            node = node.l;
        }
        System.out.print(node.val + "\t" + node.r.val + "\t");
        this.inOrder(node.r);
    }

    public void preOrder() {
        System.out.println("\nPreOrder is");
        if (dummy.isLThreaded) {
            return;
        }
        TNode node = this.dummy.l;
        System.out.print(node.val + "\t");
        while (node.r != dummy) {
            node = this.getPreOrderSuccessor(node);
            System.out.print(node.val + "\t");
        }
    }

    private TNode getPreOrderSuccessor(TNode node) {
        if (node == null) {
            return null;
        }
        if (!node.isLThreaded) {
            return node.l;
        }
        if (node.isRThreaded) {
            if (node.r.l == node || node.l.r == node) {
                TNode t = node.r;
                while (t.isRThreaded) {
                    t = t.r;
                }
                return t.r;
            }
        } else {
            return node.r;
        }
        return null;
    }
}
