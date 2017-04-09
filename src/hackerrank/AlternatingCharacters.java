
package hackerrank;

import java.util.Scanner;


public class AlternatingCharacters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			char s[] = in.next().toCharArray();
			char cur = s[0];
			int i = 1;
			int len = 0;
			while (i < s.length) {
				if (s[i] != cur) {
					cur = s[i];
				}else{
					len++;
				}
				i++;
			}
			System.out.println(len);
		}
	}
}
