package hackerearth.examples;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*Its a crucial learning question*/
/*an optimization that can be done at this level is to check if a word failed to go furthur, then we must exit.
 * */
public class AttendingEvent {
	private static Map<Character, List<String>> cache = null;
	static int eventCount = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			testChain(in);
		}
	}

	private static void testChain(Scanner in) {
		int events = in.nextInt();
		eventCount = events;
		String words[] = new String[events];
		for (int j = 0; j < events; j++) {
			words[j] = in.next();
		}
		buildCache(words);
		boolean found = false;
		for (int j = 0; j < words.length; j++) {
			System.out.println(words[j]);
			remove(words[j]);
			if (isChainingPossible(words[j].charAt(words[j].length() - 1), 1)) {
				found = true;
				break;
			}
			add(words[j]);
		}
		if (found) {
			System.out.println("YES");
		} else
			System.out.println("NO");

	}

	private static void add(String match) {
		if (cache.containsKey(match.charAt(0))) {
			cache.get(match.charAt(0)).add(0,match);
		}
	}

	private static boolean isChainingPossible(char charAt, int processed) {
		List<String> matches = cache.get(charAt);
		if (matches == null || matches.isEmpty()) {
			if (eventCount == processed) {
				return true;
			}
			return false;
		}
		for (int i = 0; i < matches.size(); i++) {
			String s = matches.get(i);
			System.out.println(s);
			System.out.println(cache.get(s.charAt(0)));
			matches.remove(i);
			System.out.println(cache.get(s.charAt(0)));
			if (isChainingPossible(s.charAt(s.length() - 1), processed + 1)) {
				return true;
			}
			matches.add(i,s);
			System.out.println(cache.get(s.charAt(0)));
		}
		return false;
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
				cache.get(s.charAt(0)).add(0,s);
			} else {
				List<String> words = new LinkedList<String>();
				words.add(s);
				cache.put(s.charAt(0), words);
			}
		}
	}
}
