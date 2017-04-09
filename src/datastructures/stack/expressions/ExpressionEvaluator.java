/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datastructures.stack.expressions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gopimac
 */
public class ExpressionEvaluator {
Stack s = new Stack();
    Map<String, Integer> precedenceLookUp = new HashMap<>();
    StringTokenizer st = null;
    Map<String, Operand> operandTable;
    ArrayList<Symbol> postFix = new ArrayList<>();

    public ExpressionEvaluator() {
        precedenceLookUp.put("(", 16);
        precedenceLookUp.put(")", 16);
        precedenceLookUp.put("/", 15);
        precedenceLookUp.put("*", 14);
        precedenceLookUp.put("-", 13);
        precedenceLookUp.put("+", 13);
    }

    public String infixToPostfix(String equation) {
        operandTable = new HashMap<>();
        st = new StringTokenizer(equation, "(+-*/)", true);
        String postFixExpression = "";
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println("processing " + c);
            if (isOperator(c)) {
                if (c.equals(")")) {
                    try {
                        while (!s.top().equals("(")) {
                            String ch = s.pop();
                            System.out.println(ch);
                            Operator opr = new Operator(ch);
                            postFix.add(opr);
                            postFixExpression += " " + ch;
                        }
                        s.pop();
                    } catch (NoSuchElementException nEE) {
                    }
                } else {
                    try {
                        while (precedenceLookUp.get(c) <= precedenceLookUp.get(s.top()) & !(s.isEmpty()) && !(s.top().equals("("))) {
                            String ch = s.pop();
                            System.out.println(ch);
                            Operator opr = new Operator(ch);
                            this.postFix.add(opr);
                            postFixExpression += ch;
                        }
                    } catch (NoSuchElementException nEE) {
                    }
                    s.push(c);
                }
            } else if (isOperand(c)) {
                System.out.println(c);
                if (!operandTable.containsKey(c)) {
                    Operand op = new Operand(c);
                    operandTable.put(c, op);
                }
                this.postFix.add(operandTable.get(c));
                postFixExpression += " " + c;
            } else {
                ConstantData ta = new ConstantData(Double.parseDouble(c));
                postFixExpression += c;
                this.postFix.add(ta);
            }
        }
        while (!s.isEmpty()) {
            String pop = s.pop();
            Operator opr = new Operator(pop);
            this.postFix.add(opr);
            postFixExpression += pop;
        }
        return postFixExpression;
    }

    private boolean isOperator(String c) {
        return this.precedenceLookUp.containsKey(c);
    }

    public double evaluatePostFixExpression() {
        java.util.LinkedList<Double> stack = new java.util.LinkedList<>();
        for (Symbol sym : this.postFix) {
            System.out.println(sym.getSymbol());
            if (sym instanceof DataItem) {
                DataItem dItem = (DataItem) sym;
                stack.push(dItem.getVal());
            } else if (sym instanceof Operator) {
                Operator operator = (Operator) sym;
                double val1 = stack.pop();
                double val2 = stack.pop();
                double val3 = this.solve(val2, operator.getSymbol(), val1);
                System.out.println("intrn result:" + val3);
                stack.push(val3);
            }
        }
        return stack.pop();
    }

    private Double solve(double val1, String symbol, double val2) {
        System.out.println("Evaluating" + val1 + symbol + val2);
        if (symbol.equals("+")) {
            return val1 + val2;
        }
        if (symbol.equals("-")) {
            return val1 - val2;
        }
        if (symbol.equals("*")) {
            return val1 * val2;
        }
        if (symbol.equals("/")) {
            return val1 / val2;
        }
        throw new IllegalArgumentException();
    }

    public void getValuesFromConsole() {
        Scanner in = new Scanner(System.in);
        for (String operand : this.operandTable.keySet()) {
            System.out.println("Enter a value for " + operand);
            if (in.hasNextDouble()) {
                double val = in.nextDouble();
                Operand O = this.operandTable.get(operand);
                O.setVal(val);
            }
        }
    }

    public String getExpressionFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an expression:");
        String equation = "";
        if (in.hasNext()) {
            equation = in.nextLine();
        }
        equation=equation.trim();
        System.out.println("equation "+equation);
        return this.infixToPostfix(equation);
    }

    private boolean isOperand(String c) {
        try {
            double val = Double.parseDouble(c);
            return false;
        } catch (NumberFormatException nFE) {
            String regex = "\\b[A-Za-z]+_?[A-Za-z0-9]*\\b";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(c);
            if (m.find()) {
                System.out.println(c + " is a valid operand");
                return true;
            }
        }
        return false;
    }

    ExpressionTree getExpressionTree(List<Symbol> postFix){

        return null;
    }
}
