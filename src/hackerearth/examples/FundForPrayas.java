package hackerearth.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FundForPrayas {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int p = in.nextInt();
			int q = in.nextInt();
			int capacity = q - p;
			int N = in.nextInt();
			Coin coins[] = new Coin[N];
			int minVal[] = new int[capacity + 1];
			for (int i = 0; i < N; i++) {
				int val = in.nextInt();
				int weight = in.nextInt();
				Coin c = new Coin();
				c.value = val;
				c.weight = weight;
				coins[i] = c;
			}
			Arrays.sort(coins, new Coin());
			int i = 0;
			for (int cap = 1; cap <= capacity; cap++) {
				while (i<coins.length && coins[i].weight <= cap) {
					i++;
				}
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					int thatCapVal = minVal[cap - coins[j].weight]
							+ coins[j].value;
					if (thatCapVal < min) {
						min = thatCapVal;
					}
				}
				if (min != Integer.MAX_VALUE) {
					minVal[cap] = min;
					System.out.println("MinVal["+cap+"]="+min);
				}
			}
			System.out.println(minVal[minVal.length - 1]);
		}
	}

	static class Coin implements Comparator<Coin> {
		int value;
		int weight;

		@Override
		public int compare(Coin c1, Coin c2) {
			return c1.weight - c2.weight;
		}
	}

}
