/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.btree;

/**
 *
 * @author gopimac
 */
public class Pair<T,K> {

    private T first;
    private K second;

    public Pair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }
}
