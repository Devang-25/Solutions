package test.examples.dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LotteryTickets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int count=in.nextInt();
			Integer intervals[][]=new Integer[count][3];
			for(int i=0;i<count;i++){
				intervals[i][0]=in.nextInt();
				intervals[i][1]=in.nextInt();
				intervals[i][2]=in.nextInt();
			}
			Arrays.sort(intervals, new IntervalComparator());
			int maxProbSoFar[]=new int[count];
			int max=Integer.MIN_VALUE;
			for(int i=0;i<intervals.length;i++){
				int maxProbI=intervals[i][2];
				for(int j=0;j<i;j++){
					if(intervals[i][0]>=intervals[j][1]){
						//there is no conflict with jth interval.
						if(maxProbSoFar[j]+intervals[i][2]>maxProbI){
							maxProbI=maxProbSoFar[j]+intervals[i][2];
						}
					}
				}
				maxProbSoFar[i]=maxProbI;
				if(maxProbSoFar[i]>max){
					max=maxProbSoFar[i];
				}
			}
			System.out.println(String.format("%.2f",((double)max)/100));
		}
	}
	
	static class IntervalComparator implements Comparator<Integer[]>{

		@Override
		public int compare(Integer[] interval1, Integer[] interval2) {
			if(interval1[1]<interval2[1]){
				return -1;
			}
			return 1;
		}}
}
