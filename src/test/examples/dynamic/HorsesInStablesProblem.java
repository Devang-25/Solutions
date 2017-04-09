package test.examples.dynamic;

import java.util.Arrays;

public class HorsesInStablesProblem {
	public static void main(String[] args) {
		//int horses[]={0,1,1,1,0,1,1,0,1,1,1};
		int horses[]={-1, 0,1,1,1,0,1};
		 Integer []whitesUptoI=getHorses(horses, 1);
		 System.out.println(Arrays.asList(whitesUptoI));
		 Integer []blacksUptoI=getHorses(horses,0);
		 System.out.println(Arrays.asList(blacksUptoI));
		 int stables=4;
		 int sum=getOptimalSum(stables, whitesUptoI, blacksUptoI);
		 System.out.println();
		 System.out.println(sum);
		 
		
	}

	private static int getOptimalSum(int stables, Integer whites[], Integer black[]) {
		int sum[][]=new int[stables+1][whites.length];
		for(int i=1;i<whites.length;i++){
			sum[1][i]=whites[i]*black[i];
			System.out.print(sum[1][i]+"\t");
		}
		for(int i=2;i<sum.length;i++){
			for(int j=i;j<whites.length;j++){
				int min=Integer.MAX_VALUE;
				for(int p=i-1;p<j;p++){
					int prod=(whites[j]-whites[p])*(black[j]-black[p]);
					System.out.println("prod:"+prod);
					int val=sum[i-1][p]+prod;
					System.out.println("sum("+(i-1)+","+p+")= "+val);
					min=Math.min(min,val );
				}
				sum[i][j]=min;
				System.out.println("sum["+i+"]["+j+"]= "+min);
			}
		}
		return sum[stables][whites.length-1];
	}

	private static Integer[] getHorses(int[] horses, int horseId) {
		Integer till[]=new Integer[horses.length];
		int horsesCount=0;
		for(int i=1;i<horses.length;i++){
			if(horses[i]==horseId){
				horsesCount++;
			}
			till[i]=horsesCount;
		}
		return till;
	}
}
