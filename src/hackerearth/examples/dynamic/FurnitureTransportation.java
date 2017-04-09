package hackerearth.examples.dynamic;

import java.util.Scanner;

public class FurnitureTransportation {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	int N=in.nextInt();
	int I=in.nextInt();
	int M=in.nextInt();
	long ways=0;
	int len=0;
	for(int i=1;i<=N;i++){
		int val=in.nextInt();
		if(val<=I){
			len++;
		}else{
			 if(len>=M){
				 ways+=(len-M+1);
			 }
			 len=0;
		}
	}
	if(len>=M){
		ways+=(len-M+1);
	}
	System.out.println(ways);
}
}
