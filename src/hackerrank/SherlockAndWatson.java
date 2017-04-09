package hackerrank;

import java.util.Scanner;

public class SherlockAndWatson {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	int n=in.nextInt();
	int k=in.nextInt();
	int q=in.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<n;i++){
		arr[i]=in.nextInt();
	}
	k=k%n;
	for(int i=1;i<=q;i++){
		int at=in.nextInt();
		if(at-k>=0){
			System.out.println(arr[at-k]);
		}else{
			System.out.println(arr[n-k+at]);
		}
		
	}
}
}
