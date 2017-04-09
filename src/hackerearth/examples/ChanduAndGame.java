package hackerearth.examples;

import java.util.Scanner;

public class ChanduAndGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		long moves=0;
		int x[]=new int[k];
		int y[]=new int[k];
		for(int i=0;i<k;i++){
			x[i]=in.nextInt();
		}
		for(int i=0;i<k;i++){
			y[i]=in.nextInt();
		}
		for(int i=0;i<k;i++){
			if(x[i]-1<=n-x[i]){
				moves+=x[i]-1;
			}else{
				moves+=n-x[i];
			}
			if(y[i]-1<=n-y[i]){
				moves+=y[i]-1;
			}else{
				moves+=n-y[i];
			}
			System.out.println(moves);
		}
		System.out.println(moves);
		
	}
}
