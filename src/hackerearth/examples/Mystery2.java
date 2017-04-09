package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mystery2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		List<String> out = new ArrayList<String>();
		for (int i = 0; i < testCases; i++) {
			String s = in.next();
			int d = in.nextInt();
			char[] charArray = s.toCharArray();
			String ouput = "";
			for (int j = 0; j < charArray.length; j++) {
				int ascii = (int) charArray[j];
				int mod = d % 26;
				int code = ascii + mod;
				if (code > 122) {
					code = 96 + (ascii + mod) - 122;
				} else if (code < 97) {
					code = 123 - (97 - code);
				}
				ouput += String.valueOf((char) (code));
			}
			out.add(ouput);
		}
		for (int i = 0; i < out.size(); i++) {
			System.out.println(out.get(i));
		}
	}

}
