package hackerearth.examples.Strings;

import java.util.Scanner;

public class BattleOfWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		in.next();
		for (int t = 1; t <= testCases; t++) {
			String s=in.nextLine();
			//System.out.println(s);
			char bob[] = s.toCharArray();
			char[] alice = in.nextLine().toCharArray();
			//System.out.println("Input "+new String(bob)+","+new String(alice));
			int count[] = new int[26];
			for (int i = 0; i < bob.length; i++) {
				if (bob[i] != ' ') {
					count[bob[i] - 97]++;
				}
			}
			boolean aliceLeft = false;
			for (int i = 0; i < alice.length; i++) {
				if (alice[i] != ' ') {
					if (count[alice[i] - 97] != 0) {
						count[alice[i] - 97]--;
					} else {
						aliceLeft = true;
					}
				}
			}
			boolean bobLeft = false;
			for (int i = 0; i < 26; i++) {
				if (count[i] != 0) {
					bobLeft = true;
					break;
				}
			}
			if (aliceLeft && bobLeft) {
				System.out.println("You draw some.");
			} else if (aliceLeft) {
				System.out.println("You lose some.");
			} else {
				System.out.println("You win some.");
			}
		}
	}
}
