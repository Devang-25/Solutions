package networking.examples;

import java.net.MalformedURLException;
import java.net.URL;

public class URLEquality {
	public static void main(String[] args) {
		try {
			URL www = new URL("http://www.ibiblio.org/");
			URL ibiblio = new URL("http://ibiblio.org/");
			if (ibiblio.equals(www)) {
				System.out.println(ibiblio + " is the same as " + www);
			} else {
				System.out.println(ibiblio + " is not the same as " + www);
			}
		} catch (MalformedURLException ex) {
			System.err.println(ex);
		}
	}
}
/*
 * When you run this program, you discover: <programlisting
 * format="linespecific" id="I_7_tt233">% <userinput moreinfo= "none"> java
 * URLEquality</userinput> http://www.ibiblio.org/ is the same as
 * http://ibiblio.org/</programlisting>
 */