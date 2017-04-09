/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.redBlackTrees;

import java.util.Collection;

import datastructures.tree.GTreeInterface;
import datastructures.tree.Pair;

/**
 *
 * @author gopimac
 */
public abstract class GenericTree<N extends Node<N>>
        implements GTreeInterface<N> {

    protected N root = null;

    public GenericTree() {
        this.root = null;
    }

    public GenericTree(Collection<Integer> c) {
        for (Integer i : c) {
            insert_(i);
        }
    }

    private GenericTree(N node) {
        this.root = node;
    }

    protected N copyTree(N n) {
        if (n != null) {
            N node = (N) n.copy();
            node.left = this.copyTree(n.left);
            node.right = this.copyTree(n.right);
            return node;
        } else {
            return null;
        }
    }

    public N insert_(int val) {
        if (this.root == null) {
            root = this.getNodeInstance(val);
            return root;
        }
        return this.insert_(root, val);
    }

    private N insert_(N node, int val) {
        if (node == null) {
            N newNode = this.getNodeInstance(val);
            newNode.val = val;
            return newNode;
        }
        if (node != null) {
            if (val > node.val) {
                node.right = this.insert_(node.right, val);
            } else {
                node.left = this.insert_(node.left, val);
            }
        }
        return node;
    }

    public N insert(int val) {
        System.out.println("Inserting " + val + " in GTREE");
        if (this.root == null) {
            this.root = this.getNodeInstance(val);
            return this.root;
        }
        Pair<N, N> p = this.search(val);

        N parent = p.getFirst();
        N x = p.getSecond();
        if (x == null) {
            //that means the point doesn't exist..
            System.out.println("No match found ...so adding new element");
            N n = this.getNodeInstance(val);
            if (val <= parent.val) {
                parent.left = n;
                n.parent = parent;
            } else {
                parent.right = n;
                n.parent = parent;
            }
            return n;
        }
        //  System.out.println("Value "+x.val+":"+val+" already exists");

        return null;
    }

    public Pair<N, N> search(int val) {
        N x = this.root;
        N parent = null;
        while (x != null) {
            if (x.val == val) {
                System.out.println("Element " + val + " found");
                return new Pair<>(parent, x);
            } else if (val < x.val) {
                parent = x;
                x = x.left;
            } else if (val > x.val) {
                parent = x;
                x = x.right;
            }
        }
        System.out.println("Element not found");
        return new Pair<>(parent, x);
    }

    public void preOrder() {
        this.pre(root);
    }

    public void inOrder() {
        in(this.root);
    }

    public void postOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void pre(N node) {
        if (node != null) {
            System.out.print(node.val + "\t");
            pre(node.left);
            pre(node.right);
        }
    }

    private void in(N node) {
        if (node != null) {
            in(node.left);
            System.out.print(node + "\t");
            in(node.right);
        }
    }

    private void post(N node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(int val) {
        Pair<N, N> p = this.search(val);
        N x = p.getSecond();
        N parent = p.getFirst();
        N xSuccessor = null;
        if (x != null) {
            if (x.left != null && x.right != null) {
                //x has left as well right child.
                parent = x;
                xSuccessor = x.right;
                while (xSuccessor.left != null) {
                    parent = xSuccessor;
                    xSuccessor = xSuccessor.left;
                }
                x.val = xSuccessor.val;
                x = xSuccessor;
                System.out.println("dual children");
            }
            if (x.left == null && x.right == null) {
                if (parent.right == x) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
                System.out.println("\ndeleted leaf");
                return;
            }
            if (x.left == null && x.right != null) {
                if (parent.left == x) {
                    parent.left = x.right;
                } else {
                    parent.right = x.right;
                }
                System.out.println("deleted onchilder");
                return;
            }
            if (x.left != null && x.right == null) {
                if (parent.left == x) {
                    parent.left = x.left;
                } else {
                    parent.right = x.left;
                }
                System.out.println("deleted one childer");
                return;
            }
        }
    }

    public abstract N getNodeInstance(int val);
}
