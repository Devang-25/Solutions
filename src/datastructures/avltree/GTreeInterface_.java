/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.avltree;

import datastructures.tree.Pair;

/**
 *
 * @author gopimac
 */
public interface GTreeInterface_<T extends Comparable<T>, N extends AVLNode<T>> {

    void  insert(T val);

    Pair<N, N> search(T val);

    void preOrder();

    void inOrder();

    void postOrder();

    void delete(int val);
}
