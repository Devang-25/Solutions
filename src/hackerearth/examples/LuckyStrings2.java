package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyStrings2 {
	static int result = 0;

	public static void main(String[] args) {
		long time=System.currentTimeMillis();
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < testCases; i++) {
			String luckyString = scan.next();
			ArrayList<Character> arr = changeStringToList(luckyString);
			int strCount = scan.nextInt();
			for (int j = 0; j < strCount; j++) {
				String str = scan.next();
				result += checkString(str, arr);
			}
			output.add(result);
			result = 0;
		}
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
		System.out.println(System.currentTimeMillis()-time);
	}

	public static ArrayList<Character> changeStringToList(String str) {
		ArrayList<Character> arr = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			arr.add(str.charAt(i));
		}
		return arr;
	}

	public static int checkString(String str, ArrayList<Character> arr) {
		ArrayList<Character> newArr = new ArrayList<Character>(arr);
		for (int i = 0; i < str.length(); i++) {
			if (!newArr.isEmpty()) {
				Character c = str.charAt(i);
				if (newArr.contains(c))
					newArr.remove(c);
				else
					return 0;
			}
		}
		if (newArr.isEmpty())
			return 1;
		return 0;
	}

}
