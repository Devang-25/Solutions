/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;


public class GenericPriorityQueueMin<K extends Comparable<K>, T> {

    private ArrayList<Pair<K, T>> list = new ArrayList<Pair<K, T>>();

    public GenericPriorityQueueMin() {
    }

    public GenericPriorityQueueMin(Collection<Pair<K, T>> col) {
        for (Pair<K, T> i : col) {
            this.insert(i);
        }
    }

    public Pair<K, T> getMinimum() {
        return list.get(0);
    }

    private int parent(int i) {
        if (i < 0 || i >= list.size()) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public final void insert(Pair<K, T> p) {
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
        int min = i;
        System.out.println("Left child " + lChild + "..., RChild " + rChild);
        if (lChild != -1 && list.get(lChild).getFirst().compareTo(list.get(i).getFirst()) == -1) {
            min = lChild;
        }
        if (rChild != -1 && list.get(rChild).getFirst().compareTo(list.get(min).getFirst()) == -1) {
            min = rChild;
        }
        if (min != i) {
            System.out.println(list.get(i) + " and " + list.get(min) + " are swapped");
            Pair<K, T> temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
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

    public Pair<K, T> deleteMin() {
        if (!this.list.isEmpty()) {
            Pair<K, T> data = this.list.get(0);
            this.list.set(0, this.list.get(this.list.size() - 1));
            this.list.remove(list.size() - 1);
            this.percolateDown(0);
            return data;
        }
        throw new NoSuchElementException();
    }

    public Pair<K, T> deleteAt(int i) {
        Pair<K, T> val = this.list.get(i);
        this.list.set(i, this.list.get(this.list.size() - 1));
        this.list.remove(this.list.size() - 1);
        this.percolateDown(i);
        return val;
    }

    void percolateDown(int i) {
        int lChild = this.getLeftChild(i);
        int rChild = this.getRightChild(i);
        int min = i;
        if (lChild != -1 && list.get(lChild).getFirst().compareTo(list.get(i).getFirst()) == -1) {
            min = lChild;
        }
        if (rChild != -1 && list.get(rChild).getFirst().compareTo(list.get(min).getFirst()) == -1) {
            min = rChild;
        }
        if (min != i) {
            Pair<K, T> temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
            this.percolateDown(min);
        }
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int getIndex(Pair p) {
        return this.list.indexOf(p);
    }

    public void setKey(Pair p, K val) {
        if (val == null) {
            return;
        }
        int index = this.list.indexOf(p);
        if (index != -1) {
            Pair<K, ?> pair = this.list.get(index);
            pair.setFirst(val);
            if (val.compareTo(pair.getFirst()) == -1) {
                this.fix(index);
            } else {
                this.percolateDown(index);
            }
        }
    }

    @Override
    public String toString() {
        return this.list.size()+":::::"+this.list.toString();
    }
}
