package hackerearth.examples;

import java.util.Scanner;

public class MagicSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n=in.nextInt();
			int val[]=new int[n];
			for (int index = 0; index <n; index++) {
				val[index]=in.nextInt();
			}
			long sum=magicSum(val);
			System.out.println(sum);
		}
	}

	private static long magicSum(int[] val) {
		int firstLeaf=val.length/2;
		int lastLeaf=val.length-1;
		long max=Long.MIN_VALUE;
		for(int i=firstLeaf;i<=lastLeaf;i++){
			for(int j=i;j<=lastLeaf;j++){
				long sum=0;
				int ancestorI=i;
				int ancestorJ=j;
				while(ancestorI!=ancestorJ){
					sum+=val[ancestorI]+val[ancestorJ];
					//go one up.
					ancestorI=(ancestorI-1)/2;
					//go one up.
					ancestorJ=(ancestorJ-1)/2;
				}
				//add ancestor itself.
				sum+=val[ancestorJ];
				if(sum>max){
					max=sum;
				}
			}
		}
		return max;
	}
}
