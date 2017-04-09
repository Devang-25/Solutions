package hackerearth.examples;

import java.util.LinkedList;
import java.util.Scanner;

public class HelpCaptainGorden {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int victims = in.nextInt();
		int actions = in.nextInt();
		System.out.println("actions: "+actions);
		LinkedList<Modification> list = new LinkedList<Modification>();
		for (int i = 0; i < actions; i++) {
			int actionId = in.nextInt();
			if (actionId == 2) {
				int sum = 0;
				int start=in.nextInt();
				int end=in.nextInt();
				for (Modification m : list) {
					int s= m.getSum(start, end);
					System.out.println("sum:"+s);
					sum+=s;
				}
				System.out.println(sum);
			} else {
				list.add(new Modification(in.nextInt(), in.nextInt(), in
						.nextInt()));
			}
		}
	}

	static class Modification {
		int start;
		int end;
		int val;

		public Modification(int start, int end, int val) {
			super();
			this.start = start;
			this.end = end;
			this.val = val;
			System.out.println(this.start+";"+this.end+";"+this.val);
		}

		int getSum(int start, int end) {
			int a = Math.max(start, this.start);
			int b = Math.min(end, this.end);
			if (a < b) {
				return (b-a + 1) * val;
			}
			return 0;
		}

	}
}
