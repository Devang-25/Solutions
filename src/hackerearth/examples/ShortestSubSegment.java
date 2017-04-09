package hackerearth.examples;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ShortestSubSegment {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String words[] = in.nextLine().split(" ");
		int k = in.nextInt();
		Set<String> set = new HashSet<String>();
		for (int i = 1; i <= k; i++) {
			String word = in.next();
			set.add(word.trim());
		}
		// System.out.println(set);
		int c = Integer.MAX_VALUE;
		int t = 0;
		int f = 0;
		for (int from = 0; from <= words.length - k; from++) {
			String word = words[from];
			if (word.endsWith(".")) {
				word = word.substring(0, word.length() - 1);
			}
			if (set.contains(word.toLowerCase())) {
				Set<String> copy = new TreeSet<String>(set);
				copy.remove(word.toLowerCase());
				int count = getLength(words, k, from, copy);
				// System.out.println("Count:"+count
				// +" from :"+words[from]+from+" to "+words[from+count-1]+(from+count-1));
				if (c > count) {
					c = count;
					t = from;
					f = from + count;
					if (c == k) {
						break;
					}
				}
			}
		}
		if (c == Integer.MAX_VALUE) {
			System.out.println("NO SUBSEGMENT FOUND");
		} else {
			for (int i = t; i < f; i++) {
				if (words[i].endsWith(".")) {
					words[i] = words[i].substring(0, words[i].length() - 1);
				}
				System.out.print(words[i]);
				if (i != f - 1) {
					System.out.print(" ");
				}
			}
		}
	}

	private static int getLength(String[] words, int k, int from,
			Set<String> copy) {
		int count = 1;
		for (int i = from + 1; i < words.length; i++) {
			String word = words[i];
			if (word.endsWith(".")) {
				word = word.substring(0, word.length() - 1);
			}
			word = word.toLowerCase();
			// System.out.println(copy);
			if (copy.contains(word)) {
				copy.remove(word);
				// System.out.println("copy: "+copy);
				if (copy.isEmpty()) {
					count++;
					break;
				}
			}
			count++;
		}
		if (!copy.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return count;
	}

}
