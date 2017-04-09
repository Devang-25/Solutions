package test2;

import java.util.Scanner;

public class CountAlphabets {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	String str=in.nextLine();
	int c[]=process(str);
	for(int n:c){
		System.out.print(n+" ");
	}
}

private static int[] process(String str) {
	int arr[]=new int[26];
	for(char c:str.toCharArray()){
		int intC=c;
		if(intC>=65 && intC<=90){
			arr[c-65]++;
		}else if(intC>=97 && intC<=122){
			arr[c-97]++;
		}
	}
	return arr;
}
}
