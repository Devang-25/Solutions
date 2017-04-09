package hackerearth.examples;

import java.util.Scanner;
/* incorrect.*/
public class CodeHunt2 {
	 
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int numbers = in.nextInt();
			boolean cache[]=new boolean[101];
			int count=0;
			//int arr[] = new int[numbers];
			for (int i = 0; i < numbers; i++) {
				int num=in.nextInt();
				if(cache[num]){
					count++;
				}else{
					cache[num]=true;
				}
			}
			//System.out.println(count);
			System.out.println(process(cache, count));
		}

	}

	public static long process(boolean cache[], int count) {
		long doorNumber=count;
		for (int i = 1; i < cache.length - 1; i++)
			for (int j = i + 1; j < cache.length; j++) {
				if (cache[i] && cache[j]) {
					if (j%i == 0) {
							doorNumber = doorNumber + 1;
					}
				}
			}
		return doorNumber;
	}
}