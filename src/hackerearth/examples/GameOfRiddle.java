package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class GameOfRiddle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int sandQuantityAvailable = in.nextInt();
			ArrayList<SandDigit> list = new ArrayList<SandDigit>(9);
			for (int j = 1; j <= 9; j++) {
				list.add(new SandDigit(j, in.nextInt()));
			}
			Collections.sort(list, new SandDigitSorter());
			System.out.println(list);
			SandDigit best = list.get(0);
			if(best.quantity>sandQuantityAvailable){
				System.out.println(-1);
				continue;
			}
			// System.out.println(best);
			SandDigit prevBest = best;
			int digits = (sandQuantityAvailable / best.quantity);
			LinkedList<Integer> no = new LinkedList<Integer>();
			int dgt = digits;
			StringBuilder b = new StringBuilder();
			for (int d = 1; d <= digits; d++) {
				for (int j = 1; j < list.size(); j++) {
					int itsDigits = (sandQuantityAvailable / list.get(j).quantity);
					if (itsDigits < dgt) {
						break;
					}
					if (list.get(j).val > best.val) {
						best = list.get(j);
					}
				}
				System.out.println(best);
				if (sandQuantityAvailable % best.quantity == 0) {
					for (int m = 0; m < no.size(); m++) {
						b.append(no.get(m));
					}
					for (int k = 1; k <= dgt; k++) {
						b.append(best.val);
					}
					display(b);
					break;
				}
				sandQuantityAvailable -= best.quantity;
				no.add(best.val);
				best = prevBest;
				dgt--;
			}
		}
	}

	private static void display(StringBuilder buffer) {
		System.out.println(buffer.toString());
		int a = 0;
		String str = buffer.toString();
		int b = str.length() - 1;
		System.out.println(b);
		while (a != b && a + 1 != b) {
			if (str.charAt(a) > str.charAt(b)) {
				System.out.println(buffer.toString());
				return;
			} else if (str.charAt(a) < str.charAt(b)) {
				System.out.println(buffer.reverse().toString());
				return;
			} else {
				a++;
				b--;
			}
		}
		System.out.println(str);
	}

	static class SandDigitSorter implements Comparator<SandDigit> {

		@Override
		public int compare(SandDigit d1, SandDigit d2) {
			if (d1.quantity < d2.quantity) {
				return -1;
			}
			if (d1.quantity > d2.quantity) {
				return 1;
			} else {
				if (d1.val > d2.val) {
					return -1;
				}
				return 1;
			}
		}

	}

	static class SandDigit {
		int val;
		int quantity;

		public SandDigit(int val, int quantity) {
			super();
			this.val = val;
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return quantity + ":" + val;
		}

	}
}
