/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.binaryHeaps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import datastructures.redBlackTrees.Pair;

/**
 *
 * @author gopimac
 */
public class GBinaryHeap<T> {

    private ArrayList<Pair<Integer, T>> list = new ArrayList<Pair<Integer, T>>();

    public GBinaryHeap() {
    }

    public GBinaryHeap(Collection<Pair<Integer, T>> col) {
        for (Pair<Integer, T> i : col) {
            this.insert(i);
        }
    }

    public T getMaximum() {
        return list.get(0).getSecond();
    }

    private int parent(int i) {
        if (i < 0 || i >= list.size()) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public final void insert(Pair<Integer, T> p) {
        list.add(p);
        System.out.println(p + " has been inserted");
        if (list.size() > 1) {
            int parent = this.parent(list.indexOf(p));
            System.out.println(parent);
            this.fix(parent);
        }
    }

    private void fix(int i) {
        System.out.println("Fixing:::" + list.get(i));
        int lChild = this.getLeftChild(i);
        int rChild = this.getRightChild(i);
        int max = i;
        System.out.println("Left child " + lChild + "..., RChild " + rChild);
        if (lChild != -1 && list.get(lChild).getFirst() > list.get(i).getFirst()) {
            max = lChild;
        }
        if (rChild != -1 && list.get(rChild).getFirst() > list.get(max).getFirst()) {
            max = rChild;
        }
        if (max != i) {
            System.out.println(list.get(i) + " and " + list.get(max) + " are swapped");
            Pair<Integer, T> temp = list.get(i);
            list.set(i, list.get(max));
            list.set(max, temp);
            this.fix(this.parent(i));
        }
        System.out.println("Fixing stopped");
    }

    private int getLeftChild(int parent) {
        int left = 2 * parent + 1;
        if (left >= list.size()) {
            return -1;
        }
        return left;
    }

    private int getRightChild(int parent) {
        int right = 2 * parent + 2;
        if (right >= list.size()) {
            return -1;
        }
        return right;
    }

    public Pair<Integer, T> deleteMax() {
        if (!this.list.isEmpty()) {
            Pair<Integer, T> data = this.list.get(0);
            this.list.set(0, this.list.get(this.list.size() - 1));
            this.list.remove(list.size() - 1);
            this.percolateDown(0);
            return data;
        }
        throw new NoSuchElementException();
    }

    public Pair<Integer, T> deleteAt(int i) {
        System.out.println(this.list);
        System.out.println("");
        Pair<Integer, T> val = this.list.get(i);
        this.list.set(i, this.list.get(this.list.size() - 1));
        this.list.remove(this.list.size() - 1);
        this.percolateDown(i);
        System.out.println(this.list);
        return val;
    }

    void percolateDown(int i) {
        int lChild = this.getLeftChild(i);
        int rChild = this.getRightChild(i);
        int max = i;
        if (lChild != -1 && list.get(lChild).getFirst() > list.get(i).getFirst()) {
            max = lChild;
        }
        if (rChild != -1 && list.get(rChild).getFirst() > list.get(max).getFirst()) {
            max = rChild;
        }
        if (max != i) {
            Pair<Integer, T> temp = list.get(i);
            list.set(i, list.get(max));
            list.set(max, temp);
            this.percolateDown(max);
        }
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
