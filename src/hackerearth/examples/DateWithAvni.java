package hackerearth.examples;

import java.util.Scanner;

public class DateWithAvni {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	int testCases=in.nextInt();
	for(int t=1;t<=testCases;t++){
		String text=in.next();
		char[] textC=text.toCharArray();
		char prev=textC[0];
		boolean slap=false;
		for(int i=1;i<textC.length;i++){
			if(textC[i]==prev){
				slap=true;
				break;
			}
			prev=textC[i];
		}
		if(slap){
			System.out.println("SLAP");
		}else{
			System.out.println("KISS");
		}
	}
}
}
