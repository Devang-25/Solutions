package thoughtworks.questions;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Romans {
	private String regex = "M{0,3}?((D?C{0,3})|C(D|M))?((L?X{0,3})|X(L|C))?((V?I{0,3})|I(V|X))?";
	private final Pattern pattern = Pattern.compile(regex);
	HashMap<Character, Integer> valTab = new HashMap<Character, Integer>();
	HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {

	}

	void process() {

		String[][] table = new String[][] { { "glob", "I" }, { "prok", "V" },
				{ "pish", "X" }, { "tegj", "L" } };
		for (String[] s : table) {
			map.put(s[0], s[1]);
		}
		char[] chars = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		int val[] = { 1000, 500, 100, 50, 10, 5, 1 };

		for (int i = 0; i < val.length; i++) {
			valTab.put(chars[i], val[i]);
		}
		Scanner in = new Scanner(System.in);
		int silver = credits(toRoman(in.nextLine()));
		int silvercredits=in.nextInt();
		double valS=((double)silver)/silvercredits;
		int gold = credits(toRoman(in.nextLine()));
		int goldcredits=in.nextInt();
		double valG=((double)gold)/goldcredits;
		int iron = credits(toRoman(in.nextLine()));
		int ironcredits=in.nextInt();
		double valI=((double)iron)/ironcredits;
		int queries=in.nextInt();
		for(int q=1;q<=queries;q++){
			String query=in.nextLine();
			String type=in.nextLine();
			int credits=credits(toRoman(query));
			switch (type) {
			case "Silver":
				System.out.println(credits*valS);
				break;
			case "Gold":
				System.out.println(credits*valG);
				break;
			case "Iron":
				System.out.println(credits*valI);
				break;
			default:
				break;
			}
		}

	}

	private int credits(String roman) {
		int sum = 0;
		char prev = roman.charAt(roman.length() - 1);
		for (int i = roman.length() - 2; i >= 0; i--) {
			if (precedence(prev) <= precedence(roman.charAt(i))) {
				sum += valTab.get(roman.charAt(i));
			} else {
				sum += (valTab.get(prev) - valTab.get(roman.charAt(i)));
				i--;
			}
			prev = roman.charAt(i);
		}
		return sum;
	}

	private int precedence(char charAt) {
		// TODO Auto-generated method stub
		return 0;
	}

	private String toRoman(String nextLine) {
		String blabblab[] = nextLine.split(" ");
		StringBuilder bu = new StringBuilder();
		for (String b : blabblab) {
			bu.append(map.get(b));
		}
		return bu.toString();
	}

	private static void test(Pattern pattern) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String roman = in.nextLine();
			if (!roman.equals(-1)) {
				Matcher matcher = pattern.matcher(roman);
				if (matcher.matches()) {
					System.out.println("Y");
				} else {
					System.out.println("N");
				}
			}

		}
	}
}
