package codechef.problems;

import java.util.Scanner;

public class Mixtures {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			cache=new Integer[101][101][2];
			int no=in.nextInt();
			int p[]=new int[no];
			for(int i=0;i<p.length;i++){
				p[i]=in.nextInt();
			}
			System.out.println(colorMixture(p, 0, p.length - 1)[1]);
		}
		
	}

	private static Integer cache[][][] = null;
	static int tab = 0;
	private static void display(String msg, int t){
		for(int i=1;i<=t;i++){
			System.out.print("\t");
		}
		System.out.println(msg);
	}
	private static int[] colorMixture(int p[], int i, int j) {
		tab++;
		//display("c(" + i + "," + j + ")", tab);
		if (i == j) {
			//display("->"+p[i]+","+0,tab);
			tab--;
			return new int[] { p[i], 0 };
		}
		if (cache[i][j][0] != null) {
			//System.out.println("refer cache");
			//display("->"+cache[i][j][0]+","+cache[i][j][1] ,tab);
			tab--;
			return new int[] { cache[i][j][0], cache[i][j][1] };
		}
		int minSmoke = Integer.MAX_VALUE;
		
		int c = 0;
		for (int k = i; k < j; k++) {
			int colorSmoke1[] = colorMixture(p, i, k);
			//System.out.println(colorSmoke1[0]);
			int colorSmoke2[] = colorMixture(p, k + 1, j);
			//System.out.println(colorSmoke1[0]);
			int smoke = colorSmoke1[0] * colorSmoke2[0] + colorSmoke1[1]
					+ colorSmoke2[1];
			if (smoke < minSmoke) {
				minSmoke = smoke;
				c = (colorSmoke1[0] + colorSmoke2[0]) % 100;
			}
		}
		cache[i][j][0] = c;
		cache[i][j][1] = minSmoke;
		//display("->"+c+","+minSmoke ,tab);
		tab--;
		return new int[] { c, minSmoke };
	}
}
