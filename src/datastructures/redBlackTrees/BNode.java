/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.redBlackTrees;


/**
 *
 * @author gopimac
 */
public class BNode extends Node<BNode> {

    public BNode() {
    }

    BNode(int val) {
        super.val = val;
    }

    @Override
    public Node copy() {
        return new BNode(super.val);
    }
}
