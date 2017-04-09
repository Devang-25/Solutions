package hackerrank;

import java.util.Scanner;

public class DiwaliLights {
private static int table[] =new int[10000];
public static void main(String[] args) {
	int no=1;table[0]=1;
	for(int i=1;i<table.length;i++){
		no=no*2;
		no%=100000;
		table[i]=no;
	}
	Scanner in =new Scanner(System.in);
	int testCases=in.nextInt();
	for(int t=1;t<=testCases;t++){
		int n=in.nextInt();
		System.out.println(table[n]-1);
	}
	
}
}
