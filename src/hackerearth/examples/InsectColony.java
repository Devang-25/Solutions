package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InsectColony {
public static void main(String[] args) {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner in = new Scanner(br);
	int testCases = in.nextInt();
	for (int t = 0; t < testCases; t++) {
		int N=in.nextInt();
		int evenC=0;
		int oddC=0;
		for(int i=1;i<=N;i++){
			long n=in.nextLong();
			if(n%2==1){
				oddC++;
			}else{
				evenC++;
			}
		}
		if(evenC%2==0 && oddC%2==0){
			System.out.println("Yes");
		}else if(evenC%2==1 && oddC%2==1){
			System.out.println("No");
		}else if(evenC%2==1 && oddC%2==0){
			System.out.println("Yes");
		}else if(evenC%2==0 && oddC%2==1){
			System.out.println("No");
		}
	}
}
}
