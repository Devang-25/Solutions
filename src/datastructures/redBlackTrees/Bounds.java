/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.redBlackTrees;

/**
 *
 * @author gopimac
 */
public class Bounds extends Pair<Integer, Integer> {

    public Bounds(int l, int u) {
        super(l, u);
    }

    public int getUpperBound() {
        return super.getSecond();
    }

    public int getLowerBound() {
        return super.getFirst();
    }

    public int length() {
        return super.getSecond() - super.getFirst();
    }
}
