/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.stack.expressions;


/**
 *
 * @author gopimac
 */
public class Operand extends Symbol implements DataItem {

    private double val;

    public Operand(String symbol) {
        super(symbol);
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}
