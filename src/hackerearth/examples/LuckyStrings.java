package hackerearth.examples;

import java.util.Scanner;

/*works perfectly but not getting accepted.*/
public class LuckyStrings {

	public static void main(String[] args) {
		long time=System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		int input[][] = new int[26][2];
		int testCases = in.nextInt();
		int count = 0;
		for (int i = 1; i <= testCases; i++) {
			String anagram = in.next();
			for (char c : anagram.toCharArray()) {
				input[c - 97][0]++;
			}
			int books = in.nextInt();
			for (int j = 1; j <= books; j++) {
				char book[] = in.next().toCharArray();

				//System.out.println(new String(book));
				boolean different = false;
				for (int p = 0; p < book.length; p++) {
					if (input[book[p] - 97][0] != 0) {
						input[book[p] - 97][1]++;
					} else {
						//System.out.println("char missing:" + book[p]);
						different = true;
						break;
					}
				}
				if (!different) {
					boolean match = true;
					for (int r = 0; r < input.length; r++) {
						if (input[r][0] != input[r][1]) {
							match = false;
							break;
						}
					}
					if (match) {
						//System.out.println("accepted ");
						count++;
					} else {
						//System.out.println("rejected ");
					}
				}
				for (int m = 0; m < input.length; m++) {
					input[m][1] = 0;
				}
			}
			System.out.println(count);
		}
		System.out.println(System.currentTimeMillis()-time);
	}

}
