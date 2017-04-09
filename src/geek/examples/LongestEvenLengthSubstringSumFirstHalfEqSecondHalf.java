package geek.examples;

public class LongestEvenLengthSubstringSumFirstHalfEqSecondHalf {
	public static void main(String[] args) {
		//int d[]=new int[]{1,5,3,8,0,2,3};		
		int d[]=new int[]{7,1,7,6,5,1,8,2,1,3};
		System.out.println(process(d));
	}
	
	private static int process(int d[]){
		int max=Integer.MIN_VALUE;
		int sum[][]=new int[d.length][d.length];
		for(int i=0;i<d.length;i++){
			sum[i][i]=d[i];
		}
		for(int window=2; window<=d.length; window++){
			for(int i=0;i<d.length+1-window;i++){
				int j=i+window-1;
				int k=window/2;
				sum[i][j]=sum[i][i+k-1]+sum[i+k][j];
				System.out.println("sum["+i+"]["+j+"]="+sum[i][j]+","+sum[i][i+k-1]+","+sum[i+k][j]);
				if(window%2==0 && sum[i][i+k-1]==sum[i+k][j] && max<window){
					max=window;
				}
			}
		}
		return max;
	}
}
