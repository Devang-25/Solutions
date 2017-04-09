package networking.examples;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncoderTest {
	public static void main(String[] args) {
		try {
			System.out.println(URLEncoder.encode("This string has spaces",
					"UTF-8"));
			System.out.println(URLEncoder.encode("This*string*has*asterisks",
					"UTF-8"));
			System.out.println(URLEncoder.encode(
					"This%string%has%percent%signs", "UTF-8"));
			System.out.println(URLEncoder.encode("This+string+has+pluses",
					"UTF-8"));
			System.out.println(URLEncoder.encode("This/string/has/slashes",
					"UTF-8"));
			System.out.println(URLEncoder.encode(
					"This\"string\"has\"quote\"marks", "UTF-8"));
			System.out.println(URLEncoder.encode("This:string:has:colons",
					"UTF-8"));
			System.out.println(URLEncoder.encode("This~string~has~tildes",
					"UTF-8"));
			System.out.println(URLEncoder.encode(
					"This(string)has(parentheses)", "UTF-8"));
			System.out.println(URLEncoder.encode("This.string.has.periods",
					"UTF-8"));
			System.out.println(URLEncoder.encode(
					"This=string=has=equals=signs", "UTF-8"));
			System.out.println(URLEncoder.encode("This&string&has&ampersands",
					"UTF-8"));
			System.out.println(URLEncoder.encode(
					"Thiséstringéhasé non-ASCII characters", "UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
	}

	/*
	 * % javac -encoding UTF8 EncoderTest % java EncoderTest
	 * This+string+has+spaces This*string*has*asterisks
	 * This%25string%25has%25percent%25signs This%2Bstring%2Bhas%2Bpluses
	 * This%2Fstring%2Fhas%2Fslashes This%22string%22has%22quote%22marks
	 * This%3Astring%3Ahas%3Acolons This%7Estring%7Ehas%7Etildes
	 * This%28string%29has%28parentheses%29 This.string.has.periods
	 * This%3Dstring%3Dhas%3Dequals%3Dsigns This%26string%26has%26ampersands
	 * This%C3%A9string%C3%A9has%C3%A9non-ASCII+characters</programlisting>
	 */

	/*
	 * String url = "https://www.google.com/search?"; url +=
	 * URLEncoder.encode("hl", "UTF-8"); url += "="; url +=
	 * URLEncoder.encode("en", "UTF-8"); url += "&"; url +=
	 * URLEncoder.encode("as_q", "UTF-8"); url += "="; url +=
	 * URLEncoder.encode("Java", "UTF-8"); url += "&"; url +=
	 * URLEncoder.encode("as_epq", "UTF-8"); url += "="; url +=
	 * URLEncoder.encode("I/O", "UTF-8");
	 */
}
