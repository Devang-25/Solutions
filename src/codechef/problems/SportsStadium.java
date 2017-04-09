package codechef.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SportsStadium {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int stadiums = in.nextInt();
		Slot[] slots = new Slot[stadiums];
		for (int s = 0; s < stadiums; s++) {
			slots[s] = new Slot(in.nextInt(), in.nextInt());
		}
		Arrays.sort(slots, new Slot(-1, -1));
		//System.out.println(Arrays.asList(slots));
		int max = getMaxAlloc(slots);
		System.out.println(max);
	}

	private static int getMaxAlloc(Slot[] slots) {
		// greedy approach.
		int count = 1;
		int end = slots[0].end;
		for (int i = 1; i < slots.length; i++) {
			//System.out.println(slots[i].start);
			if (slots[i].start >= end) {
				count++;
				end = slots[i].end+1;
			}
			
		}
		return count;
	}

	static class Slot implements Comparator<Slot> {
		private final int start, end;

		public Slot(int start, int length) {
			this.start = start;
			this.end = this.start + length;
		}

		@Override
		public String toString() {
			return this.start+"-"+this.end;
		}

		@Override
		public int compare(Slot s1, Slot s2) {
			return  (s1.end - s2.end);
		}
	}
}
