/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.binaryHeaps;

import datastructures.redBlackTrees.Pair;

/**
 *
 * @author gopimac
 */
public class asStack<T> {

    GenericPriorityQueueMax<Integer, T> bh=new GenericPriorityQueueMax<Integer, T>();
    int c=0;
    public void push(T val) {
        bh.insert(new Pair<Integer, T>(c++,val));
    }

    public T pop() {
        return bh.deleteMax().getSecond();
    }

    public boolean isEmpty() {
        return bh.isEmpty();
    }
}
