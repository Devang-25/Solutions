package hackerearth.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TransformTheExpression {
	Stack s = new Stack();
	Map<String, Integer> precedenceLookUp = new HashMap<String, Integer>();
	StringTokenizer st = null;
	Map<String, Operand> operandTable;
	ArrayList<Symbol> postFix = new ArrayList<Symbol>();

	public TransformTheExpression() {
		precedenceLookUp.put("^", 17);
		precedenceLookUp.put("(", 16);
		precedenceLookUp.put(")", 16);
		precedenceLookUp.put("/", 15);
		precedenceLookUp.put("*", 14);
		precedenceLookUp.put("-", 13);
		precedenceLookUp.put("+", 13);
	}
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		TransformTheExpression er=new TransformTheExpression();
		for(int i=1;i<=testCases;i++){
			String expression=in.next();
			System.out.println(er.infixToPostfix(expression));
		}
	}
	public String infixToPostfix(String equation) {
		operandTable = new HashMap<>();
		st = new StringTokenizer(equation, "(+-*/)", true);
		String postFixExpression = "";
		while (st.hasMoreTokens()) {
			String c = st.nextToken();
			//System.out.println("processing " + c);
			if (isOperator(c)) {
				if (c.equals(")")) {
					try {
						while (!s.top().equals("(")) {
							String ch = s.pop();
							//System.out.println(ch);
							Operator opr = new Operator(ch);
							postFix.add(opr);
							postFixExpression += ch;
						}
						s.pop();
					} catch (NoSuchElementException nEE) {
					}
				} else {
					try {
						while (precedenceLookUp.get(c) <= precedenceLookUp
								.get(s.top())
								& !(s.isEmpty())
								&& !(s.top().equals("("))) {
							String ch = s.pop();
							//System.out.println(ch);
							Operator opr = new Operator(ch);
							this.postFix.add(opr);
							postFixExpression += ch;
						}
					} catch (NoSuchElementException nEE) {
					}
					s.push(c);
				}
			} else if (isOperand(c)) {
				//System.out.println(c);
				if (!operandTable.containsKey(c)) {
					Operand op = new Operand(c);
					operandTable.put(c, op);
				}
				this.postFix.add(operandTable.get(c));
				postFixExpression +=c;
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



	private boolean isOperand(String c) {
		try {
			double val = Double.parseDouble(c);
			return false;
		} catch (NumberFormatException nFE) {
			String regex = "\\b[A-Za-z]+_?[A-Za-z0-9]*\\b";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(c);
			if (m.find()) {
				//System.out.println(c + " is a valid operand");
				return true;
			}
		}
		return false;
	}
}

class Operand extends Symbol implements DataItem {

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

class Symbol {

	private String symbolName;

	public Symbol(String symbolName) {
		this.symbolName = symbolName;
	}

	public String getSymbol() {
		return this.symbolName;
	}
}

 interface DataItem {
    public double getVal();

    public void setVal(double val);
}
 
  class Stack {

	    LinkedList<String> list = new LinkedList<>();

	    void push(String  c) {
	        list.addFirst(c);
	    }

	   String pop() {
	        return list.removeFirst();
	    }

	   String top() throws NoSuchElementException{
	       return list.element();
	   }
	   boolean isEmpty(){
	       return list.isEmpty();
	   }
	}
  
   class Operator  extends Symbol{

	    public Operator(String symbol) {
	        super(symbol);
	    }

	}
   
    class ConstantData extends Symbol implements DataItem{

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
