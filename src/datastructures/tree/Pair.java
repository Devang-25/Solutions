/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tree;

/**
 *
 * @author gopimac
 */
public class Pair<T, V> {

    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
