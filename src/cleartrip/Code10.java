package cleartrip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Code10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String example = in.nextLine();
		String query = example.substring(example.indexOf("?") + 1);
		String keyVal[] = query.split("&");
		Map<String, String> pairs = new HashMap<String, String>();
		String ppts[] = { "username", "pwd", "profile", "role", "key" };
		for (int i = 0; i < keyVal.length; i++) {
			String kV[] = keyVal[i].split("=");
			String key = kV[0];
			String val = kV[1];
			pairs.put(key, val);
		}
		for (String s : ppts) {
			System.out.println(s + ": "
					+ (pairs.containsKey(s) ? pairs.get(s) : ""));
		}

	}
}
