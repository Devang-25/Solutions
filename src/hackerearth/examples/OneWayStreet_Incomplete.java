package hackerearth.examples;

import java.util.Scanner;

public class OneWayStreet_Incomplete {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int testCases=in.nextInt();
	for(int i=1;i<=testCases;i++){
		int cities=in.nextInt();
		int cityLinks[]=new int[cities+1];
		for (int j = 1; j <=cities-1; j++) {
			int a=in.nextInt();
			int b=in.nextInt();
			cityLinks[a]=b;
			cityLinks[b]=a;
		}
		int queries=in.nextInt();
		for (int j = 1; j < cityLinks.length; j++) {
			
		}
	}
}
}
