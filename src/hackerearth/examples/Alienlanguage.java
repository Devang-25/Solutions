package hackerearth.examples;

import java.util.Scanner;

public class Alienlanguage {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			String text = in.next();
			boolean lettersText[] = new boolean[26];
			for (int i = 0; i < text.length(); i++) {
				lettersText[text.charAt(i) - 'a'] = true;
			}
			String pattern = in.next();
			boolean lettersPattern[] = new boolean[26];
			for (int i = 0; i < pattern.length(); i++) {
				lettersPattern[pattern.charAt(i) - 'a'] = true;
			}
			boolean match=false;
			for(int i=0;i<26;i++){
				if(lettersPattern[i]==lettersText[i] && lettersPattern[i]){
					match=true;
					break;
				}
			}
			if(match){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}
}
