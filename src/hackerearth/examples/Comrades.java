package hackerearth.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Comrades {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int s = in.nextInt();
			List<LinkedList<Integer>> soldiers = new ArrayList<LinkedList<Integer>>(
					s + 1);
			for (int sol = 0; sol < s+1; sol++) {
				soldiers.add(new LinkedList<Integer>());
			}
			int superior = 0;
			for (int i = 1; i <= s; i++) {
				// for the ith soldiers, the val is its superior's id.
				int superiorId = in.nextInt();
				if (superiorId == 0) {
					superior = i;
				}
				soldiers.get(superiorId).add(i);
			}
			int level = 1;
			long handshakes = handshakes(soldiers, superior, level);
			long fistBumps=((s*(s-1))/2)-handshakes;
			System.out.println(handshakes + " " +fistBumps );
		}

	}


	private static long handshakes(List<LinkedList<Integer>> soldiers,
			int superior, int level) {
		long handshakes = soldiers.get(superior).size() * level;
		for (int sol : soldiers.get(superior)) {
			handshakes += handshakes(soldiers, sol, level + 1);
		}
		return handshakes;
	}
	

}
