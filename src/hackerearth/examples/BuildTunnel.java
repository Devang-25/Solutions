package hackerearth.examples;

import java.util.Scanner;

public class BuildTunnel {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		StringBuilder builder=new StringBuilder();
		for (int i = 1; i <= testCases; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int d = in.nextInt();
			int l = in.nextInt();
			if (a == b) {
				if (l >= d - (2 * a) && l <= d) {
					builder.append("YES");
				} else {
					builder.append("NO");
				}
			} else {
				int r1 = Math.min(a, b);
				int r2 = Math.max(a, b);
				//System.out.println(d * d - (r2 - r1) * (r2 - r1));
				double difSQ=(r1+r2)*(r1+r2);
				double f=Math.sqrt(r1*r1+(1+((l*l)/difSQ)));
				double s=Math.sqrt(r2*r2+(1+((l*l)/difSQ)));
				if (l >= d - (r1+r2)&& (f+s)<=d ) {
					builder.append("YES");
				} else {
					builder.append("NO");
				}
			}
			if(i!=testCases){
				builder.append("\n");
			}
		}
		System.out.println(builder.toString());

	}
}
