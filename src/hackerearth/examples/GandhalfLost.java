package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GandhalfLost {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int dictionary = in.nextInt();
		List<String> lib = new ArrayList<String>();
		for (int i = 1; i <= dictionary; i++) {
			lib.add(in.next());
		}
		Collections.sort(lib, new LexComparator());
		System.out.println(lib);
		int queries = in.nextInt();
		for (int i = 1; i <= queries; i++) {
			String query = in.next();
			int at = Collections.binarySearch(lib, query);
			if (at >=0) {
				System.out.println(at + 1);
			} else
				System.out.println(-1);
		}

	}
}
 class LexComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		int i = 0;
		int min = Math.min(s1.length(), s2.length());
		while (i < min) {
			if (s1.charAt(i) == s2.charAt(i)) {
				i++;
			} else {
				return s1.charAt(i) - s2.charAt(i);
			}
		}
		if (s1.length() == min) {
			return -1;
		}
		return 1;
	}

}