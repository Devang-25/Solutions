package flipkart.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GoldMines {

	private static List<Integer[]> path = new ArrayList<Integer[]>();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int gold[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				gold[i][j] = in.nextInt();
			}
		}
		System.out.println(	getMaxGold(gold, 0,0));
		Collections.reverse(path);
		for(Integer[] p:path){
			System.out.println(p[0]+"-"+p[1]);
		}
	}

	private static int getMaxGold(int[][] gold, int i, int j) {
		if(i==-1 || i==gold.length||j==gold[0].length){
			return 0;
		}
		System.out.println(i+","+j);
		int v1=getMaxGold(gold, i+1, j);
		int v2=getMaxGold(gold, i-1, j+1);
		int v3=getMaxGold(gold, i+1, j+1);
		Integer[] p=new Integer[2];
		int max=Math.max(v1,  v2);
		max=Math.max(max, v3);
		System.out.println("Max is:"+max);
		if(max==v1){
			p[0]=i+1;
			p[1]=j;
		}else if(max==v2){
			p[0]=i-1;
			p[1]=j+1;
		}else if(max==v3){
			p[0]=i+1;
			p[1]=j+1;
		}
		path.add(p);
		return gold[i][j]+max;
	}

	
}
