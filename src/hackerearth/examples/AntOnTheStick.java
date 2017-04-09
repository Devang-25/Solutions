package hackerearth.examples;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AntOnTheStick {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		in.nextLine();
		for (int t = 1; t <= testCases; t++) {
			String days[] = in.nextLine().split("\\s");
			Day.sticks = days[0].length();
			Day[] daysList = new Day[days.length];
			//System.out.println(Arrays.asList(days));
			int m = 0;
			for (String d : days) {
				daysList[m] = new Day(d);
				m++;
			}
			int totalLength = 0;
			for (int i = 0; i < days[0].length(); i++) {
				int maxLen = -1;
				for (Day d : daysList) {
					int len = d.getMinLenStick();
					if (len > maxLen) {
						maxLen = len;
					}
				}
				//System.out.println(maxLen);
				totalLength += maxLen;
			}
			System.out.println(totalLength);

		}
	}

}

class Day {
	private PriorityQueue<Integer> queue = null;
	static int sticks = 0;

	Day(String day) {
		queue = new PriorityQueue<Integer>(sticks, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				if (a <= b) {
					return -1;
				}
				return 1;
			}
		});
		char stickLengths[] = day.toCharArray();
		for (int i = 0; i < stickLengths.length; i++) {
			int len = Integer.parseInt(stickLengths[i] + "");
			queue.add(len);
		}
	}

	int getMinLenStick() {
		return this.queue.remove();
	}
}
