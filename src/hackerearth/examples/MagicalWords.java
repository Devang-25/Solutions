package hackerearth.examples;

import java.util.Scanner;

public class MagicalWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			String word = in.next();
			int sum = word.length();
			for (int i = 0; i < word.length(); i++) {
				int s=getPalindromeSum(word, i);
				//System.out.println(s);
				sum+=s;
			}
			for (int i = 0; i < word.length() - 1; i++) {
				int s=getPalindromeSum2(word, i);
				//System.out.println(s);
				sum+=s;
			}
			System.out.println(sum);
		}
	}

	private static int getPalindromeSum2(String word, int i) {
		if(word.charAt(i)!=word.charAt(i+1)){
			return 0;
		}
		int sum = 4;
		int at = 1;
		while ((i - at) >= 0 && (i +1+ at) != word.length()
				&& word.charAt(i - at) == word.charAt(i + at)) {
			sum += (1 + 2*at+1)*(2*at+1+1);
			at++;
		}
		return sum;
	}
	
	private static int getPalindromeSum(String word, int i) {
		int sum = 0;
		int at = 1;
		while ((i - at) >= 0 && (i + at) != word.length()
				&& word.charAt(i - at) == word.charAt(i + at)) {
			sum += (1 + 2*at)*(2*at+1);
			at++;
		}
		return sum;
	}
}
