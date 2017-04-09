package hackerearth.examples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FundForPrayas2 {

	private static TreeSet<Coin> coinsSet = null;
	private static int cache[] = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int p = in.nextInt();
			int q = in.nextInt();
			int capacity = q - p;
			int N = in.nextInt();
			cache = new int[capacity + 1];
			coinsSet = new TreeSet<>(new Coin());
			for (int i = 0; i < N; i++) {
				int val = in.nextInt();
				int weight = in.nextInt();
				Coin c = new Coin();
				c.value = val;
				c.weight = weight;
				coinsSet.add(c);
			}

			int min = min(capacity);
			if (min == Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE.");
			} else {
				System.out.println(min);
			}
		}
	}

	private static int t = 0;

	private static int min(int capacity) {
		if (cache[capacity] != 0) {
			return cache[capacity];
		}
		t++;
		print("Min(" + capacity + ")", t);
		if (capacity == 0) {
			print("ret:" + 0, t);
			t--;
			return 0;
		}
		Coin temp = new Coin();
		temp.weight = capacity;
		Set<Coin> lowers = coinsSet.headSet(temp, true);
		if (lowers == null || lowers.isEmpty()) {
			print("ret:" + Integer.MAX_VALUE, t);
			t--;
			return Integer.MAX_VALUE;
		}
		int min = Integer.MAX_VALUE;
		for (Coin c : lowers) {
			int m = min(capacity - c.weight) + c.value;
			if (m > 0) {
				min = Math.min(min, m);
			}
		}
		print("ret:" + min, t);
		t--;
		cache[capacity] = min;
		return min;
	}

	static class Coin implements Comparator<Coin> {
		int value;
		int weight;

		@Override
		public int compare(Coin c1, Coin c2) {
			return c1.weight - c2.weight;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.value + ":" + this.weight;
		}
	}

	private static void print(String s, int t) {
		for (int i = 0; i < t; i++) {
			System.out.print("   ");
		}
		System.out.println(s);
	}
}
