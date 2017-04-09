package hackerearth.examples;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*only one test case was accepted :( */
public class Compiler {
	public static void main(String args[]) throws IOException {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			
			process(line);
		}
//		String line="String a=a->process(\" bild a.->//cnet \")//a->b//a";
//		process(line);
	}

	private static Pattern pattern = Pattern.compile("\".*(//|->).*\"");

	private static void process(String line) {
		int safe = 0;
		StringBuilder b = new StringBuilder();
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			int start = matcher.start();
			String fixed = line.substring(safe, start).replace("->", ".");
			b.append(fixed);
			b.append(matcher.group());
			safe = matcher.end();
		}
		String left = line.substring(safe);
		if (left.indexOf("//") != -1) {
			String parts[] = left.split("//");
			String code = parts[0].replace("->", ".");
			String fixedString = code;
			for (int i = 1; i < parts.length; i++) {
				fixedString += "//" + parts[i];
			}
			b.append(fixedString);

		} else {
			b.append(left.replace("->", "."));
		}
		System.out.println(b.toString());
	}

}
