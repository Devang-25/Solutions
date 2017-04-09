package hackerearth.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MixingStrings {
	private static Map<Character, List<String>> cache = null;

	public static void main(String args[]) {

		/*String input[] = { "gurpreet", "preetinder", "derpan", "erlang",
				"inderpal", "reetkumari", "umraojaan", "aanaji", "mariyan",
				"kumarisung", "angleum" };*/
		 //String input[]={"abc","cde","bc","fpg","gpa","deaf"};
		 String input[]={"ggggg","ggggg","ggggg"};
		// Scanner in = new Scanner(System.in);
		// int noOfWords = in.nextInt();
		// String input[] = new String[noOfWords];
		/*
		 * for (int i = 0; i < noOfWords; i++) { input[i] = in.next(); }
		 */
		// System.out.println(Arrays.asList(input));
		buildCache(input);
		remove(input[0]);
		int maxElimination = process(input[0].toCharArray(), 0);
		int totalLength = 0;
		for (String s : input) {
			totalLength += s.length();
		}
		System.out.println(totalLength);
		System.out.println(totalLength - maxElimination);

	}

	private static int process(char[] input, int index) {
		int maxSaved = 0;
		for (int i = 0; i < input.length; i++) {
			if (cache.containsKey(input[i])) {
				List<String> matches = cache.get(input[i]);
				matches = new ArrayList<String>(matches);
				if (!matches.isEmpty()) {
					System.out.println("@" + i + " " + matches);
				}
				for (String match : matches) {
					int startPoint = match(input, i, match.toCharArray());
					// what if it consumes all.
					System.out.println(startPoint);
					if (startPoint != -1) {
						remove(match);
						System.out.println(match + "," + (input.length - i));
						int saved = input.length - i
								+ process(match.toCharArray(), startPoint);
						if (saved > maxSaved) {
							maxSaved = saved;
						}
						System.out.println("saved :" + saved);
						add(match);
					}
				}
			}
		}
		return maxSaved;
	}

	private static void add(String match) {
		if (cache.containsKey(match.charAt(0))) {
			cache.get(match.charAt(0)).add(match);
		} else {
			List<String> words = new LinkedList<String>();
			words.add(match);
			cache.put(match.charAt(0), words);
		}
	}

	private static int match(char[] input, int i, char[] match) {
		System.out.println(new String(input) + "," + new String(match));
		int k = 1;
		int j = i + 1;
		for (; j < input.length && k < match.length; j++) {
			if (input[j] == match[k]) {
				k++;
			} else {
				return -1;
			}
		}
		if (j == input.length) {
			//System.out.println("match["+match[k]+"]");
			return 0;
		}
		return -1;
	}

	private static void remove(String match) {
		if (cache.containsKey(match.charAt(0))) {
			cache.get(match.charAt(0)).remove(match);
		}
	}

	private static void buildCache(String input[]) {
		// may not be optimal for this cache but works.
		cache = new HashMap<Character, List<String>>();
		for (String s : input) {
			if (cache.containsKey(s.charAt(0))) {
				cache.get(s.charAt(0)).add(s);
			} else {
				List<String> words = new LinkedList<String>();
				words.add(s);
				cache.put(s.charAt(0), words);
			}
		}
	}
}
