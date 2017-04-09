package hackerearth.examples;

import java.util.Scanner;

public class LuckyTime {
	static int digits[] = new int[6];
	static boolean used[] = new boolean[10];
	static int newTime[] = new int[6];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int l = 1; l <= 1; l++) {
			used = new boolean[10];
			newTime = new int[6];
			char time[] = in.next().toCharArray();
			int de = 0;
			for (char t : time) {
				if (t != ':') {
					digits[de] = t - 48;
					de++;
				}
			}
			boolean changed = false;
			for (int i = 0; i < 6; i++) {
				if (!changed) {
					if (!used[digits[i]]) {
						newTime[i] = digits[i];
						used[digits[i]] = true;
						continue;
					}
					System.out.println("!changed");
					if (used[digits[i]]) {
						incrementAfter(i);
						changed = true;
					}
				} else {
					setToFirstUnused(i);
				}
			}
			System.out.println(newTime[0] + "" + newTime[1] + ":" + newTime[2]
					+ newTime[3] + ":" + newTime[4] + newTime[5]);
		}
	}

	static void incrementAfter(int pos) {
		System.out.println("Increment after:" + digits[pos]);
		int limit = -1;
		if (pos % 2 == 1) {
			if (pos == 1 && digits[0] == 2) {
				limit = 3;
			} else {
				limit = 9;
			}
		} else {
			if (pos == 0) {
				limit = 2;
			} else {
				limit = 5;
			}
		}
		System.out.println("Limit:" + limit);
		if (digits[pos] == limit) {
			if (limit == 2) {
				used[digits[pos]] = false;
				newTime[pos] = 0;
				used[0] = true;
			} else {
				used[digits[pos - 1]] = false;
				incrementAfter(pos - 1);
				setToFirstUnused(pos);
			}
		} else {
			setToFirstUnusedAfter(pos);
		}
	}

	private static void setToFirstUnusedAfter(int pos) {
		for (int i = digits[pos] + 1; i < used.length; i++) {
			if (!used[i]) {
				// used[digits[pos]] = false;
				used[i] = true;
				newTime[pos] = i;
				System.out.println("set next to:" + i);
				break;
			}
		}
	}

	private static void setToFirstUnused(int pos) {
		System.out.println("set to first unused:" + pos);
		for (int i = 0; i < 6; i++) {
			if (!used[i]) {
				// used[digits[pos]]=false;
				used[i] = true;
				newTime[pos] = i;
				System.out.println("set to :" + i);
				break;
			}
		}
	}
}
