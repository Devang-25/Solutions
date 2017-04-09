package hackerrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
//a change
public class BiggerIsGreater {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		Scanner f = new Scanner(new File("Untitled.txt"));
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			String str = in.next();
			String exp = f.nextLine();
			char strC[] = str.toCharArray();
			String act = answer(strC);
			if (!act.equals(exp)) {
				System.out.println(act + "\n" + act + "\n" + exp);
			}
		}
	}

	private static String answer(char[] c) {
		TreeSet<Character> set = new TreeSet<Character>();
		int chTab[]=new int[26];
		set.add(c[c.length - 1]);
		int i = c.length - 2;
		if(i==-1){
			return "no answer";
		}
		Character ch = null;
		chTab[c[c.length - 1]-97]=c.length-1;
		char temp=(char) (c[i] + 1);
		while ((ch = set.ceiling(temp) )== null) {
			set.add(c[i]);
			chTab[c[i]-97]=i;
			i--;
			if(i==-1){
				break;
			}
			temp=(char) (c[i] + 1);
		}
		if (i != -1) {
			char t=c[i];
			c[i]=ch;
			c[chTab[ch-97]]=t;
			String fixed = new String(c, 0, i + 1);
			Arrays.sort(c, i + 1, c.length);
			String rest = new String(c, i + 1, c.length - i - 1);
			String act = fixed + rest;
			return act;
		} else {
			return "no answer";
		}
	}
}
