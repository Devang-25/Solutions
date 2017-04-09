package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChangAndMathematicalBrainbuster {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int no=in.nextInt();
		ArrayList<Integer> set = new ArrayList<Integer>(no);
		for(int i=1;i<=no;i++){
			set.add(in.nextInt());
		}
		//int arr[] = { 1,7,13,26,17,12,14,2,19 };
		//
		Collections.sort(set);
		//System.out.println(set);
		System.out.println(getMin(set, 0, set.size()-1));

	}
	private static int getMin(List<Integer> l,int start, int end){
		if(start==end){
			//check here..
			return 1;
		}
		if(l.get(end)<=3*l.get(start)){
			//System.out.println(l.get(end)+";"+l.get(start));
			return 0;
		}
		int a=getMin(l, start+1, end);
		if(a==0){
			return 1;
		}
		int b=getMin(l, start, end-1);
		
		//System.out.println(a+":"+b);
		return 1+Math.min(a, b);
	}
}
