package hackerearth.examples;

import java.util.Scanner;

public class TheTimeInWords {
	static String w[] = new String[] { "", "one", "two", "three", "four", "five",
			"six", "seven", "eight", "nine","ten","eleven","twelve" };
	static String k[] = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int hh = in.nextInt();
		int mmI = in.nextInt();
		if (mmI == 0) {
			System.out.println(w[hh] + " o' clock");
		} else if (mmI == 15) {
			System.out.println("quarter past " + w[hh]);
		} else if (mmI == 30) {
			System.out.println("half past " + w[hh]);
		} else if (mmI == 45) {
			System.out.println("quarter to " + (w[hh + 1]));
		} else if (mmI < 30) {
			int a = mmI/10;
			int b = mmI%10;
			if (a == 0) {
				System.out.println(w[b]+" minutes past "+w[hh]);
			}else if(a==1){
				System.out.println(k[b]+" minutes past "+w[hh]);
			}else{
				System.out.println("twenty "+w[b]+(!w[b].equals("")?" ":"")+"minutes past "+w[hh]);
			}
		} else {
			mmI=60-mmI;
			int a = mmI/10;
			int b = mmI%10;
			hh++;
			if (a == 0) {
				System.out.println(w[b]+" minutes to "+w[hh]);
			}else if(a==1){
				System.out.println(k[b]+" minutes to "+w[hh]);
			}else{
				System.out.println("twenty "+w[b]+" minutes to "+w[hh]);
			}
		}
	}
}
