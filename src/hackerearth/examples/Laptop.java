package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Laptop {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(br);
		int N = in.nextInt();
		String best = null;
		int max = Integer.MIN_VALUE;
		HashMap<String, Integer> table = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String company = in.next();
			//System.out.println(company);
			if (!table.containsKey(company)) {
				table.put(company, 1);
			} else {
				table.put(company, table.get(company) + 1);
			}
			int count = table.get(company);
			if (count > max) {
				best = company;
				max=count;
			} else if (count == max) {
				if (company.compareTo(best) < 0) {
					best = company;
				}
			}
		}
		System.out.println(best);
	}
}
