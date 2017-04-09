/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.stack.expressions;

import datastructures.redBlackTrees.Node;

/**
 *
 * @author gopimac
 */
public class SymbolNode extends Node<SymbolNode> {

    Symbol symbol;

    public SymbolNode(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public Node copy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
