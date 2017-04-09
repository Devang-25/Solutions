package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;

public class AniruddhasQueue {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		for(int t=1;t<=testCases;t++){
			int daysOfYears=in.nextInt();
			int steps[]=new int[daysOfYears];
			long sum=0;
			long progress[]=new long[daysOfYears];
			for(int i=0;i<steps.length;i++){
				steps[i]=in.nextInt();
				sum+=steps[i];
				progress[i]=sum;
			}
			long m=in.nextLong();
			m=m%sum;
			//System.out.println(sum);
			int day=Arrays.binarySearch(progress, m);
			if(day<0){
				day+=1;
				day*=-1;
			}else{
				if(day==0){
					break;
				}
				int i=day;
				while(i!=0 && progress[i-1]!=progress[i]){
					i--;
				}
				day=i-1;
			}
			System.out.println(day+1);
			//int day=binarySearch(progress, m, 0, progress.length);
		}
	}

	/*private static int binarySearch(long[] progress, long target, int n, int m) {
		int mid=(n+m)/2;
		
	}*/
}
