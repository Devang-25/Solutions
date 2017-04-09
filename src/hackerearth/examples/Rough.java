package hackerearth.examples;

import java.util.Arrays;
import java.util.Comparator;

public class Rough {

	public static void main(String[] args) {
		String a = "oracleIndia";
		System.out.println(a.charAt(7));

		String words[] = { "good", "bad", "ugly" };
		Comparator<String> bestC = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.charAt(1) - o1.charAt(1);
			}
		};
		
		Arrays.sort(words, bestC);
		System.out.println(words[0]);
	}

}
