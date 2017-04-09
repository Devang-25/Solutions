package test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	private static Map<Character, Integer> dashTable;

	public Solution() {
		dashTable=new HashMap<Character, Integer>();
		dashTable.put('0', 6);
		dashTable.put('1', 2);
		dashTable.put('2', 5);
		dashTable.put('3', 5);
		dashTable.put('4', 4);
		dashTable.put('5', 5);
		dashTable.put('6', 6);
		dashTable.put('7', 4);
		dashTable.put('8', 7);
		dashTable.put('9', 6);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String text = in.nextLine();
		int countOfDashes = new Solution().getCountOfDashes(text);
		System.out.println(countOfDashes);
	}

	private  int getCountOfDashes(String text) {
		char[] textC = text.toCharArray();
		int count=0;
		for(char c:textC){
			count+=dashTable.get(c);
		}
		return count;
	}

}
