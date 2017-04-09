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
public class asQueue<T> {

    private GenericPriorityQueueMax<Integer, T> binaryHeap = new GenericPriorityQueueMax<>();
    int c = Integer.MAX_VALUE;

    public void enQueue(T val) {
        binaryHeap.insert(new Pair<Integer, T>(c--, val));
    }

    public T deQueue() {
        return binaryHeap.deleteMax().getSecond();
    }

    public boolean isEmpty() {
        return binaryHeap.isEmpty();
    }
}
