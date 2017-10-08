package hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class StockMaximize {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int days =  in.nextInt();
			PriorityQueue<Prediction> pQ = new PriorityQueue<Prediction>(days,
					(p1, p2) -> {
                        if (p1.val > p2.val) {
                            return -1;
                        } else if (p1.val == p2.val) {
                            if (p1.day < p2.day) {
                                return -1;
                            }
                        }
                        return 1;
                    });
			int val[] = new int[days];
			for (int d = 0; d < days; d++) {
				val[d] = /*(int) (10000 * Math.random());*/ in.nextInt();
				pQ.add(new Prediction(d, val[d]));
			}
			int profit = getMaxProfit(val, pQ);
			System.out.println(profit);
		}
	}

	private static int getMaxProfit(int[] val, PriorityQueue<Prediction> pQ) {
		int money = 0;
		int i = 0;
		while (i < val.length) {
			int share = val[i];
			while (!pQ.isEmpty() && pQ.peek().day <= i) {
				Prediction pred = pQ.poll();
				if (pred == null) {
					continue;
				}
			}
			if (pQ.isEmpty()) {
				break;
			}
			if (pQ.peek().val <= share) {
				// there is no prediction in future with greater value.
				i++;
				continue;
			}
			for (int j = i; j < pQ.peek().day; j++) {
				// i purchase.
				money -= val[j];
			}
			// i sell.
			money += pQ.peek().val * (pQ.peek().day - i);
			i = pQ.peek().day + 1;
			pQ.poll();
		}
		return money;
	}

	static class Prediction {
		int day;
		int val;

		Prediction(int day, int val) {
			this.day = day;
			this.val = val;
		}

		@Override
		public String toString() {

			return this.day + ":val:" + this.val;
		}
	}
}
