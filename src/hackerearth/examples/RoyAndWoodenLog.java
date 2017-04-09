package hackerearth.examples;

import java.util.Scanner;

public class RoyAndWoodenLog {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int testCases=in.nextInt();
		for(int i=1;i<=testCases;i++){
			long length = in.nextLong();
			long floor=(long)(Math.floor(length / 2));
			long noOfWaysOfCutting = (long) (floor + 1);
			long minCuts = length%2==1?floor:floor-1;
			System.out.println(noOfWaysOfCutting+" "+minCuts);
		}
		
	}
}
