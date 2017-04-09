package hackerearth.examples;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BotsProblem {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			String start = in.next();
			String end = in.next();
			//System.out.println(start + "-" + end);
			process(start, end);
		}
		// #A#B# #B#A#

	}

	private static List<Integer> getPos(char[] state, char bot) {
		List<Integer> botAIPos = new LinkedList<Integer>();
		for (int i = 0; i < state.length; i++) {
			if (state[i] == bot) {
				botAIPos.add(i);
			}
		}
		return botAIPos;
	}

	private static boolean[] aCanBeAt(char[] initial) {
		boolean canABeAt[] = new boolean[initial.length];
		//System.out.println(canABeAt[0]);
		int i = initial.length - 1;
		while (i >= 0) {
			if (initial[i] == 'A') {
				while (i > -1 && (initial[i] == 'A' || initial[i] == '#')) {
					canABeAt[i] = true;
					i--;

				}
			} else {
				i--;
			}

		}
		return canABeAt;
	}

	private static void process(String start, String end) {
		char initialState[] = start.toCharArray();
		char finalState[] = end.toCharArray();
		boolean bCanBeAt[] = bCanBeAt(initialState);
		boolean aCanBeAt[] = aCanBeAt(initialState);
		// now that A has moved..lets fix B's canBeAt to reflect that.
		List<Integer> initPosA = getPos(initialState, 'A');
		//System.out.println(initPosA);
		List<Integer> finalPosA = getPos(finalState, 'A');
		//System.out.println(finalPosA);
		int init = 0;
		for (Integer p : finalPosA) {
			if (!aCanBeAt[p]) {
				System.out.println("NO");
				return;
			} else {
				//System.out.println(p + "-" + initPosA.get(init));
				for (int ps = p; ps < initPosA.get(init); ps++) {
					bCanBeAt[ps] = false;
				}
			}
			init++;
		}
		List<Integer> finalPosB = getPos(finalState, 'B');
		for (Integer p : finalPosB) {
			if (!bCanBeAt[p]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static boolean[] bCanBeAt(char[] initial) {
		boolean canBBeAt[] = new boolean[initial.length];
		int i = 0;
		while (i < initial.length) {
			if (initial[i] == 'B') {
				while (i < initial.length
						&& (initial[i] == 'B' || initial[i] == '#')) {
					canBBeAt[i] = true;
					i++;

				}
			} else {
				i++;
			}

		}
		return canBBeAt;
	}
}
