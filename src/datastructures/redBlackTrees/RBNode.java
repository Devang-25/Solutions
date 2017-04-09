/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.redBlackTrees;

/**
 *
 * @author gopimac
 */
public class RBNode extends Node<RBNode> {

    public enum Color {

        RED, BLACK
    };
    public Color color;

    RBNode() {
        this.color = Color.RED;
    }

    RBNode(int val, Color color) {
        super.val = val;
        this.color = color;
    }

    @Override
    public Node copy() {
        return new RBNode(super.val, this.color);
    }

    @Override
    public String toString() {
        //fix it to show color.
        return this.val + "";
    }
}
