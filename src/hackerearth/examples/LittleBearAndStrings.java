package hackerearth.examples;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleBearAndStrings {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		while (true) {
			String text = in.nextLine();
			//System.out.println("text is :" + text);
			if(text.equals("\n")||text.equals("")){
				break;
			}
			String t1 = in.nextLine();
			String t2 = in.nextLine();
			Pattern p = Pattern.compile(t1);
			Matcher m1 = p.matcher(text);
			Pattern p2 = Pattern.compile(t2);
			Matcher m2 = p2.matcher(text);
			int overlap = findOverLap(t1, t2);
			int count = 0;
			int at = 0;
			while (m1.find(at)) {
				if (m2.find(m1.start() + t1.length() - overlap)) {
					count++;
					at = m2.end();
					if (at == text.length()) {
						break;
					}
				} else {
					break;
				}
			}
			System.out.println(count);
		}

	}

	private static int findOverLap(String t1, String t2) {
		int overlap = 1;
		int char1 = t1.lastIndexOf(t2.charAt(0));
		if (char1 != -1) {
			int m = 1;
			for (int i = char1 + 1; i < t1.length(); i++) {
				if (t1.charAt(i) == t2.charAt(m)) {
					overlap++;
				} else {
					return 0;
				}
				m++;
			}
			return overlap;
		} else {
			return 0;
		}
	}
}
