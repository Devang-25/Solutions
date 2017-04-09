package hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class MaximumIndexProblem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = in.nextInt();
		}
		int left[] = new int[arr.length];
		Stack<Integer> indexStackL = new Stack<Integer>();
		indexStackL.push(1);
		for (int i = 2; i < arr.length; i++) {
			int val = arr[i];
			if(val >=arr[indexStackL.peek()]){
				while(!indexStackL.isEmpty() &&arr[indexStackL.peek()]<=val ){
					indexStackL.pop();
				}
				if (!indexStackL.isEmpty()) {
					left[i] = indexStackL.peek();
				}
			}
			else{
				left[i] = indexStackL.peek();
			}
			System.out.println("max L:"+val+"="+arr[left[i]]);
			indexStackL.push(i);

		}
		
		int right[] = new int[arr.length];
		Stack<Integer> indexStack = new Stack<Integer>();
		indexStack.push(arr.length-1);
		for (int i = arr.length-2; i >1; i--) {
			int val = arr[i];
			if(val >=arr[indexStack.peek()]){
				while(!indexStack.isEmpty() &&arr[indexStack.peek()]<=val ){
					indexStack.pop();
				}
				if (!indexStack.isEmpty()) {
					right[i] = indexStack.peek();
				}
			}
			else{
				right[i] = indexStack.peek();
			}
			indexStack.push(i);
			System.out.println("max R:"+val+"="+arr[right[i]]);
		}
		int max=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++){
			int prod=left[i]*right[i];
			if(prod>max){
				max=prod;
			}
		}
		
		System.out.println(max);
	}
}
