/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.redBlackTrees;

/**
 *
 * @author gopimac
 */
public abstract class Node<T> {

    public T left, right;
    public T parent;
    public int val;

    public abstract Node<T> copy();
}
