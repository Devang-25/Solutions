/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.avltree;

import java.util.Collection;

import datastructures.tree.Pair;

public final class AVLTree<T extends Comparable<T>> implements GTreeInterface_<T, AVLNode<T>> {

    AVLNode<T> root = null;

    public AVLTree() {
        root = null;
    }

    public AVLTree(Collection<? extends T> col) {
        for (T i : col) {
            this.insert(i);
            this.inOrder();
        }
    }

    public void insert(T val) {
        if (root == null) {
            root = new AVLNode<>();
            root.val = val;
        } else {
            System.out.println("\nInserting " + val);
            if (val.compareTo(this.root.val) == 1) {
                root.right = this.insert(root.right, root, val);
            } else {
                root.left = this.insert(root.left, root, val);
            }
        }
    }

    private AVLNode<T> insert(AVLNode<T> root, AVLNode<T> parent, T data) {
        if (root == null) {
            root = new AVLNode<>();
            root.val = data;
        } else if (data.compareTo(root.val) == -1) {
            root.left = this.insert(root.left, root, data);
            int heightGap = Math.abs(this.getHeight(root.left) - this.getHeight(root.right));
            System.out.println("HeightGap " + root.val + ":" + heightGap);
            if (heightGap == 2) {
                //then there is violation and we must fix it..
                System.out.println("Fixing need at " + root.val);
                if (data.compareTo(root.left.val) == -1) {
                    System.out.println("Rotate left");
                    root = this.rotateLeft(root);
                } else {
                    System.out.println("Double rotate left");
                    root = this.doubleLeftRotate(root);
                }
            }
        } else if (data.compareTo(root.val) == 1) {
            root.right = this.insert(root.right, root, data);
            int heightGap = Math.abs(this.getHeight(root.left) - this.getHeight(root.right));
            System.out.println("HeightGap " + root.val + ":" + heightGap);
            if (heightGap == 2) {
                //there is violationa and we must fix it..
                System.out.println("Fixing need at " + root.val);
                if (data.compareTo(root.right.val) == 1) {
                    System.out.println("Rotating right");
                    root = this.rotateRight(root);
                } else {
                    System.out.println("Double Rotate Right");
                    root = this.doubleRightRotate(root);
                }
            }
        }
        root.height = Math.max(this.getHeight(root.left), this.getHeight(root.right)) + 1;
        return root;
    }

    public Pair<AVLNode<T>, AVLNode<T>> search(T val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void preOrder() {
        this.pre(root);
    }

    private void pre(AVLNode<?> node) {
        if (node != null) {
            System.out.print(node.val + "\t");
            pre(node.left);
            pre(node.right);
        }
    }

    public void inOrder() {
        this.in(root);
    }

    private void in(AVLNode<?> node) {
        if (node != null) {
            in(node.left);
            System.out.print(node.val + "\t");
            in(node.right);
        }
    }

    public void postOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(int val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public AVLNode<T> getNodeInstance(int val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private AVLNode<T> rotateLeft(AVLNode<T> x) {
        AVLNode<T> w = x.left;
        x.left = w.right;
        w.right = x;
        x.height = Math.max(this.getHeight(x.left), this.getHeight(x.right)) + 1;
        w.height = Math.max(this.getHeight(w.left), this.getHeight(x)) + 1;//b careful here
        return w;
    }

    private AVLNode<T> rotateRight(AVLNode<T> w) {
        AVLNode<T> x = w.right;
        w.right = x.left;
        x.left = w;
        w.height = Math.max(this.getHeight(w.right), this.getHeight(w.left)) + 1;
        x.height = Math.max(this.getHeight(w), this.getHeight(x.right)) + 1;//b careful here
        return x;
    }

    private AVLNode<T> doubleLeftRotate(AVLNode<T> z) {
        z.left = this.rotateRight(z.left);
        return this.rotateLeft(z);
    }

    private AVLNode<T> doubleRightRotate(AVLNode<T> x) {
        x.right = this.rotateLeft(x.right);
        return rotateRight(x);
    }

    private int getHeight(AVLNode n) {
        if (n == null) {
            return -1;
        }
        return n.height;
    }
}
