package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MissingAlphabet {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		JumbleComparator c=new JumbleComparator();
		for(int i=1;i<=testCases;i++){
			String jumbledAlbhabets=in.next();
			//System.out.println(jumbledAlbhabets);
			//in.nextLine();
			c.setDictionaryOrder(jumbledAlbhabets);
			int words=in.nextInt();
			ArrayList<String> wordsList=new ArrayList<>(words);
			for(int j=1;j<=words;j++){
				wordsList.add(in.next());
			}
			Collections.sort(wordsList,c);
			for(String s:wordsList){
				System.out.println(s);
			}
		}

	}
}

class JumbleComparator implements Comparator<String> {

	private int table[] = new int[26];

	public int compare(String s1, String s2) {
		int minLength = Math.min(s1.length(), s2.length());
		for (int i = 0; i < minLength; i++) {
			int p1 = table[s1.charAt(i)-97];
			int p2 = table[s2.charAt(i)-97];
			if (p1 < p2) {
				return -1;
			} else if (p1 > p2) {
				return 1;
			}
		}
		if (s1.length() == minLength) {
			return -1;
		}
		return 1;
	}

	public void setDictionaryOrder(String order) {
		char[] alphabet = order.toCharArray();
		int i = 0;
		for (char c : alphabet) {
			table[c - 97] = i;
			i++;
		}
	}
}
