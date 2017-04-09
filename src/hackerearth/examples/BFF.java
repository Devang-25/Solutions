package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BFF {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int c = 1; c <= testCases; c++) {
			int chocolates = in.nextInt();
			List<Integer> list = new ArrayList<Integer>(chocolates);
			int sum = 0;

			for (int choc = 1; choc <= chocolates; choc++) {
				int taste=in.nextInt();
				list.add(taste);
				sum += taste;
			}
			Collections.sort(list);
			Collections.reverse(list);
			//System.out.println(list);
			int count = 0;
			if(sum%2==1){
				sum+=1;
			}
			int remaining =sum/2;
			//System.out.println("rem"+remaining);
			for (int taste : list) {
				if (taste < remaining) {
					//System.out.println(taste);
					count++;
					remaining = remaining - taste;
				} else if (taste >= remaining) {
					//System.out.println(taste);
					count++;
					break;
				}
			}
			System.out.println(count);
		}

	}
}
