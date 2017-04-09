package hackerearth.examples;

import java.util.HashMap;
import java.util.Scanner;

public class PartTimeJob {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		in.nextLine();
		for(int i=1;i<=testCases;i++){
			String leftShoes[]=in.nextLine().split("\\s");
			int leftColor[]=new int[leftShoes.length];
			for(int s=0;s<leftShoes.length;s++){
				leftColor[s]=Integer.parseInt(leftShoes[s]);
			}
			//System.out.println(Arrays.asList(leftColor));
			String rightShoes[]=in.nextLine().split("\\s");
			int rightColor[]=new int[rightShoes.length];
			for(int s=0;s<rightShoes.length;s++){
				rightColor[s]=Integer.parseInt(rightShoes[s]);
			}
			//System.out.println(Arrays.asList(rightColor));
			process(leftColor, rightColor);
		}
		
	}
	
	private static void process(int leftColor[],int rightColor[]){
		HashMap<Integer, Integer> colorCount = new HashMap<Integer, Integer>(1000);
		for (int c : leftColor) {
			if (colorCount.containsKey(c)) {
				colorCount.put(c, colorCount.get(c) + 1);
			} else {
				colorCount.put(c, 1);
			}
		}
		int shoesToBeReplaced = 0;
		for (int c : rightColor) {
			if (colorCount.containsKey(c)) {
				if (colorCount.get(c) == 0) {
					shoesToBeReplaced++;
				} else {
					colorCount.put(c, colorCount.get(c) - 1);
				}
			} else {
				shoesToBeReplaced++;
			}
		}
		System.out.println(shoesToBeReplaced);
	}
}
