package hackerearth.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AltF4AndHackerEarthProblemSetting {
	private static ProblemSetter[] setters = null;
	private static int k = 0;
	private static int cache[]=null;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			k = in.nextInt();
			cache=new int[n+1];
			setters = new ProblemSetter[n];
			
			for (int i = 0; i < n; i++) {
				int price = in.nextInt();
				ProblemSetter s = new ProblemSetter(price, -1);
				setters[i] = s;
			}
			
			for (int i = 0; i < n; i++) {
				int tasks = in.nextInt();
				setters[i].tasks = tasks;
			}
			Arrays.sort(setters, new ProblemSetter(-1, -1));
			int min = minimum(0);
			System.out.println(min);
		}
	}

	private static int minimum(int t) {
		if (t == setters.length) {
			return 0;
		}
		
		if(cache[t]!=0){
			//System.out.println("hit");
			return cache[t];
		}
		
		//System.out.println("Min(" + (t) + ")");
		int min = Integer.MAX_VALUE;
		int cost = setters[t].price * k;
		for (int i = t; i < setters.length; i++) {
			cost += setters[t].price * setters[i].tasks;
			//System.out.println(cost);
			int tCost = minimum(i + 1)+cost;
			//System.out.println("=" + tCost);
			min = Math.min(tCost, min);

		}
		cache[t]=min;
		return min;
	}

	static class ProblemSetter implements Comparator<ProblemSetter> {
		int price;
		int tasks;

		public ProblemSetter(int price, int tasks) {
			super();
			this.price = price;
			this.tasks = tasks;
		}

		@Override
		public String toString() {
			return this.price + ";" + this.tasks;
		}

		@Override
		public int compare(ProblemSetter s1, ProblemSetter s2) {
			if (s1.price > s2.price) {
				return -1;
			}
			return 1;
		}

	}
}
