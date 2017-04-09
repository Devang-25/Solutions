/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.binaryHeaps;

import java.util.Collection;

import datastructures.redBlackTrees.Pair;

/**
 *
 * @author gopimac
 */
public class MinMaxHeap<K extends Comparable<K>, T> {

    private GenericPriorityQueueMax<K, T> maxHeap;
    private GenericPriorityQueueMin<K, T> minHeap;

    public MinMaxHeap(Collection<Pair<K, T>> col) {
        this.maxHeap = new GenericPriorityQueueMax<K, T>(col);
        this.minHeap = new GenericPriorityQueueMin<K, T>(col);
    }

    public void insert(Pair<K, T> p) {
        this.maxHeap.insert(p);
        this.minHeap.insert(p);
    }

    public Pair<K, T> max() {
        return this.maxHeap.getMaximum();
    }

    public Pair<K, T> min() {
        return this.minHeap.getMinimum();
    }

    public Pair<K, T> deleteMin() {
        Pair<K, T> p = this.minHeap.deleteMin();
        int index = this.maxHeap.getIndex(p);
        this.maxHeap.deleteAt(index);
        return p;
    }

    public Pair<K, T> deleteMax() {
        Pair<K, T> p = this.maxHeap.deleteMax();
        int index = this.minHeap.getIndex(p);
        this.minHeap.deleteAt(index);
        return p;
    }

    @Override
    public String toString() {
        return "maxHeap is::\n" + this.maxHeap + "\nminHeap is::" + this.minHeap;
    }
}
