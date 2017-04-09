package hackerearth.examples;

import java.util.Scanner;

public class DigitEDigit {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int min = in.nextInt();
			int max = in.nextInt();
			int ch = in.nextInt();
			// System.out.println(c);
			int count = 0;
			char c = new String(ch + "").toCharArray()[0];
			for (int j = min; j <= max; j++) {
				String a = j + "";
				char[] arr = a.toCharArray();
				boolean has=false;
				int t=0;
				for (int m = 0; m < arr.length; m++) {
					if (arr[m] == c) {
						has=true;
						t++;
					}
				}
				if(t==1){
					count+=t;
					System.out.println(a);
				}
				
			}
			System.out.println(count);
		}
	}
}
