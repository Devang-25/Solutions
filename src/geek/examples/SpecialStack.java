package geek.examples;

import java.util.Stack;

public class SpecialStack {
	private Stack<Integer> mainStack;
	private Stack<Integer> auxStack;

	public SpecialStack() {
		ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
		mainStack = new Stack<>();
		auxStack = new Stack<>();
	}

	public void push(int e) {
		if (!this.auxStack.isEmpty()) {
			int top = this.auxStack.peek();
			if (top < e) {
				this.auxStack.push(top);
			} else {
				this.auxStack.push(e);
			}
		}else{
			this.auxStack.push(e);
		}
		this.mainStack.push(e);
	}

	public int pop() {
		if(this.auxStack.isEmpty()){
			return Integer.MIN_VALUE;
		}
		int auxTop = this.auxStack.pop();
		int mainTop = this.mainStack.pop();
		assert mainTop == auxTop;
		return mainTop;
	}

	public int getMin() {
		if(this.auxStack.isEmpty()){
			return Integer.MIN_VALUE;
		}
		return this.auxStack.peek();
	}

	public static void main(String args[]) {
		SpecialStack stack = new SpecialStack();
		stack.push(14);
		stack.push(10);
		stack.push(12);
		stack.push(16);
		stack.push(26);
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.getMin());

	}

}
