package hackerearth.examples;

import java.util.HashMap;
import java.util.Scanner;

public class WordGame {
	public static void main(String[] args) {
		HashMap<String, int[]> table = new HashMap<String, int[]>();
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int raju = in.nextInt();
			int rajuScore = 0;
			int ramu = in.nextInt();
			int ramuScore = 0;
			int rakesh = in.nextInt();
			int rakeshScore = 0;
			for (int w = 0; w < raju; w++) {
				table.put(in.next(), new int[] { 1, 0, 0 });
				rajuScore += 3;
			}
			for (int w = 0; w < ramu; w++) {
				String word = in.next();
				if (table.containsKey(word)) {
					table.put(word, new int[] { 1, 1, 0 });
					rajuScore -= 1;
					ramuScore += 2;
				} else {
					table.put(word, new int[] { 0, 1, 0 });
					ramuScore += 3;
				}
			}
			for (int w = 0; w < rakesh; w++) {
				String word = in.next();
				if (table.containsKey(word)) {
					rakeshScore += 3;
					int history[] = table.get(word);
					if (history[0] == 1) {
						rajuScore--;
						rakeshScore--;
					}
					if (history[1] == 1) {
						ramuScore--;
						rakeshScore--;
					}
				} else {
					rakeshScore += 3;
				}
			}
			if(rajuScore>ramuScore && rajuScore>rakeshScore){
				System.out.println("Raju");
			}else if(rajuScore<ramuScore && ramuScore>rakeshScore){
				System.out.println("Ramu");
			}else if(rakeshScore>rajuScore && rakeshScore>ramuScore){
				System.out.println("Rakesh");
			}else{
				System.out.println("Tie");
			}
		}
	}
}
