package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class THEFOOTBALLFEST {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int testCases = in.nextInt();
		for (int t = 0; t < testCases; t++) {
			int N = in.nextInt();
			int id = in.nextInt();
			Stack<Integer> stack = new Stack<>();
			stack.push(id);
			for (int i = 1; i <= N; i++) {
				String s = in.next();
				if (s.equals("P")) {
					stack.push(in.nextInt());
				} else {
					if (!stack.isEmpty()) {
						int a = stack.pop();
						if (!stack.isEmpty()) {
							int b = stack.pop();
							stack.push(a);
							stack.push(b);
						}
					}
				}
				System.out.println(stack);
			}
			System.out.println("Player " + stack.peek());
		}
	}
}
