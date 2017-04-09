/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tree;

import datastructures.redBlackTrees.Node;

/**
 *
 * @author gopimac
 */
public interface GTreeInterface<N extends Node<N>> {

    N  insert(int val);

    Pair<N,N> search(int val);

    void preOrder();

    void inOrder();

    void postOrder();

    void delete(int val);

    N getNodeInstance(int val);
}
