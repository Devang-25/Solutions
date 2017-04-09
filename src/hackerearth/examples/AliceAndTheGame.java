package hackerearth.examples;

import java.util.HashMap;
import java.util.Scanner;

public class AliceAndTheGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int noOfBoxes = in.nextInt();
			HashMap<Integer, Integer> boxes=new HashMap<Integer, Integer>(101);
			for(int m=0;m<=100;m++){
				boxes.put(m, 0);
			}
			for (int b = 1; b <=noOfBoxes; b++) {
				int chocolates=in.nextInt();
				boxes.put(chocolates, boxes.get(chocolates)+1);
			}
			int k=in.nextInt();
			int ways=0;
			for(int ithBox=1;ithBox<=k/2;ithBox++){
				//System.out.println("Box:"+ithBox);
				int kMinusIthBox=k-ithBox;
				//System.out.println("KMinusIth:"+kMinusIthBox);
				if(kMinusIthBox==ithBox){
					ways+=((boxes.get(ithBox)*(boxes.get(ithBox)-1))/2);
					//System.out.println("w:"+ways);
				}else{
					ways+=boxes.get(ithBox)*boxes.get(kMinusIthBox);
					//System.out.println("w:"+ways);
				}
			}
			System.out.println(ways);
			
		}
	}
}
