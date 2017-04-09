package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BrioNHouse2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			double x1 = in.nextInt();
			double y1 = in.nextInt();
			double x2 = in.nextInt();
			double y2 = in.nextInt();
			double r = in.nextInt();
			double m =0;
			if(x1!=x2){
				m = (y1 - y2) / (x1 - x2);
			}
			double c = y1 - m * x1;
			double d=Math.abs(c)/Math.sqrt(1+m*m);
			d=d-r;
			//System.out.println(d);
			if (d > 0) {
				System.out.println("SAFE");
			} else if (d == 0) {
				System.out.println("JUST MISSED");
			} else {
				System.out.println("REPLANNING");
			}
		}
	}
}
