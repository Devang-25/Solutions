/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.redBlackTrees;

import datastructures.redBlackTrees.RBNode.Color;
import datastructures.tree.GTreeInterface;
import datastructures.tree.Pair;

//faulty code...no been tested yet
public class RedBlackTree implements GTreeInterface<RBNode> {

    private SimpleBinaryTree binaryTree;

    public RedBlackTree() {
        this.binaryTree = new SimpleBinaryTree();
    }

    public RBNode insert(int val) {
        RBNode z = this.binaryTree.insert(val);
        if (z.parent == null) {
            z.color = Color.BLACK;
        } else {
            z.color = Color.RED;
        }
        this.binaryTree.inOrder();
        this.fixUpBinaryTree(z);
        return null;
    }

    public Pair<RBNode, RBNode> search(int val) {
        return this.binaryTree.search(val);
    }

    public void preOrder() {
        this.binaryTree.preOrder();
    }

    public void inOrder() {
        this.binaryTree.inOrder();
    }

    public void postOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(int val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public RBNode getNodeInstance(int val) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void fixUpBinaryTree(RBNode z) {
        if (z.parent == null) {
            System.out.println("Parent of z is null");
            //do nothing coz we knw only root, has no parent...
            return;
        }
        while (z.parent.color == Color.RED) {
            RBNode zPapa = z.parent;

            if (zPapa == zPapa.parent.left) {
                RBNode uncle = zPapa.parent.right;
                if (uncle.color == Color.RED) {
                    //then this our case 1   both brothers must be black and their daddy must be red
                    zPapa.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    zPapa.parent.color = Color.RED;
                    z = zPapa.parent;//z goes to grandPa...but the problem isn't solved yet...we must check if grandpa 's parent is red...in that case..ppt 4 again  is violated...

                } else if (uncle.color == Color.BLACK) {
                    if (z == zPapa.right) {
                        z = zPapa;
                        this.leftRotate(z);
                    }
                    zPapa.color = Color.BLACK;
                    zPapa.parent.color = Color.RED;
                    this.rightRotate(zPapa.parent);
                }
            } else if (zPapa == zPapa.parent.right) {
                RBNode uncle = zPapa.parent.left;
                if (uncle.color == Color.RED) {
                    //then this our case 1   both brothers must be black and their daddy must be red
                    zPapa.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    zPapa.parent.color = Color.RED;
                    z = zPapa.parent;//z goes to grandPa...but the problem isn't solved yet...we must check if grandpa 's parent is red...in that case..ppt 4 again  is violated...

                } else if (uncle.color == Color.BLACK) {
                    if (z == zPapa.left) {
                        z = zPapa;
                        this.leftRotate(z);
                    }
                    zPapa.color = Color.BLACK;
                    zPapa.parent.color = Color.RED;
                    this.rightRotate(zPapa.parent);
                }
            }
        }
        System.out.println("Fixing up ended");
    }

    private void leftRotate(RBNode z) {
        System.out.println("Performing left rotation");
        RBNode zRightLeftKid = z.right.left;
        if (z == z.parent.left) {
            z.parent.left = z.right;
        } else {
            z.parent.right = z.right;
        }
        z.right.left = z;
        z.right = zRightLeftKid;

    }

    private void rightRotate(RBNode z) {
        System.out.println("Performing RIGHT rotation");
        RBNode zLeftRightKid = z.left.right;
        if (z == z.parent.left) {
            z.parent.left = z.left;
        } else {
            z.parent.right = z.left;
        }
        z.left.right = z;
        z.left = zLeftRightKid;

    }
}
