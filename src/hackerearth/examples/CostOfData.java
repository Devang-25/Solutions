package hackerearth.examples;

import java.util.Scanner;

public class CostOfData {

	static class Node {
		int hasNode[] = new int[26];
	};

	static Node trie[] = null;
	static int nodesCount = 1;

	public static void main(String args[]) {
		trie = new Node[1000000];
		for (int i = 0; i < trie.length; i++) {
			trie[i] = new Node();
		}
		nodesCount=1;
		
		/*  String a[] = { "et","eq","bd","be","bdp" };{ "happy", "hatim",
		  "guppy", "laddy", "laptop", "gupgappy" };*/
		 Scanner in = new Scanner(System.in);
		int inputSize = in.nextInt();
		for (int i = 1; i <=inputSize; i++) {
			String s = in.next();
			System.out.println(s);
			add(s);
		}
		System.out.println(nodesCount);
	}

	static void add(String word) {
		int level = 0;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';
			if (trie[level].hasNode[c] == 0) {
				{
					trie[level].hasNode[c] = nodesCount;
					nodesCount++;
				}
			}
			level = trie[level].hasNode[c];
		}
	}
}
