/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.redBlackTrees;

/**
 *
 * @author gopimac
 */
public class Pair<T, V> {

    private T first;
    private V second;

    public Pair() {
    }

    @Override
    public String toString() {
        return "Key:" + first + "// Val:" + second;
    }

    public Pair(T node, V b) {
        first = node;
        second = b;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}
