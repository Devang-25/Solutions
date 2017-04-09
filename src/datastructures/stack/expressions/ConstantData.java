/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.stack.expressions;


/**
 *
 * @author gopimac
 */
public class ConstantData extends Symbol implements DataItem{

    double data;

    public ConstantData(double value) {
        super(Double.toString(value));
        this.data = value;
    }

    public double getVal() {
        return this.data;
    }

    public void setVal(double val) {
        this.data=val;
    }
}
