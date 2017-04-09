package codechef.problems;

import java.util.Scanner;
//incorrect...
public class PouringWaterIncorrect {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if (a < b) {
				int temp = a;
				a = b;
				b = temp;
			}
			double steps=((double)c-a%b)/b;
			//System.out.println(steps);
			if(((int)steps)==steps){
				System.out.println((int)steps);
			}else{
				System.out.println("-1");
			}
		}
	}
}
