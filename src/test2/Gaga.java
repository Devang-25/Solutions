package test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Gaga {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char garbled[] = in.readLine().toCharArray();
		String wordz = in.readLine();
		String actual = wordz.substring(1, wordz.length() - 1);
		String words[] = actual.split(" ");
		ArrayList<String> str = new ArrayList<String>();
		ArrayList<Integer> at = new ArrayList<Integer>();
		TreeSet<String> set = new TreeSet<String>(Arrays.asList(words));
		int i = 0;
		String temp = "";
		boolean found = false;
		str.add("");
		at.add(0);
		//System.out.println(str.size());
		while (!found) {
			int last = str.size() - 1;
			temp=str.get(last);
			str.remove(last);
			i=at.get(at.size()-1);
			at.remove(at.size()-1);
			while (i < garbled.length) {
				temp += garbled[i];
				if (!set.contains(temp)) {
					found = false;
				} else {
					//System.out.println(temp);
					str.add(temp);
					at.add(i+1);
					temp = "";
					found = true;
				}
				i++;
			}
		}
		String t="";
		for(String k:str){
			t+=k+" ";
		}
		System.out.println(t);

	}
}
