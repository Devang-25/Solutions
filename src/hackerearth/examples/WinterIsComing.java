package hackerearth.examples;

import java.util.Scanner;

public class WinterIsComing {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		for(int t=1;t<=testCases;t++){
			int N=in.nextInt();
			int array[]=new int[100009];
			int remainder[]=new int[100009];
			for(int i=1;i<=N;i++){
				array[i]=in.nextInt();
			}
			int min=Integer.MAX_VALUE;
			int window=min;
			int sum=0;
			int start=0;
			int end=0;
			for(int i=1;i<=N;i++){
				sum+=array[i];
				int rem=(sum%=N);
				if(remainder[rem]==0){
					if(rem==0){
						window=i;
					}else{
						window=Integer.MAX_VALUE;
					}
				}else{
					/*now my remainder is sum.
					at index of rem[sum] ,my remainder was sum.
					so it means the sum of all elements in the middle is dividible by N
					*/
					window=i-remainder[rem];
				}
				if(window<min){
					min=window;
					start=remainder[rem]+1;
					end=i;
				}
				remainder[rem]=i;
			}
			System.out.println(start+" "+end);
		}
	}
}
