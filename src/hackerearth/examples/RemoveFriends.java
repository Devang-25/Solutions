package hackerearth.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RemoveFriends {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream s = new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(s);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int array[] = new int[n];
			for (int i = 0; i < array.length; i++) {
				array[i] = in.nextInt();
			}
			delete(array, k);
			print(array, k);
		}
		System.out.flush();
	}

	public static void delete(int[] array, int k) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(0);
		for (int i = 1; i < array.length; i++) {
			if (k <= 0)
				break;
			while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
				array[stack.pop()] = -1;
				k--;
				if (k <= 0)
					break;
			}
			stack.push(i);
		}
	}

	public static void print(int[] array, int k) {
		for (int i = 0; i < array.length && k >= 0; i++) {
			if (array[i] != -1) {
				System.out.print(array[i] + " ");
				k--;
			}
		}
		System.out.println();
	}
}
