package hackerearth.examples;

import java.util.Scanner;

public class DassuAndInterns {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		int m = in.nextInt();
		int lucky[] = new int[m];
		for (int i = 0; i < m; i++) {
			lucky[i] = in.nextInt();
		}
		int queries = in.nextInt();
		UnionCounter counter=new UnionCounter(lucky);
		for (int q = 1; q <= queries; q++) {
			int l=in.nextInt();
			int r=in.nextInt();
			long rNo = counter.union(r);
			long lNo=counter.union(l-1);
			System.out.println(rNo-lNo);
		}
	}

	static class UnionCounter {
		private int arr[];
		private long students;
		private long sum = 0;

		UnionCounter(int lucky[]) {
			this.arr = lucky;
		}

		private long union(long students) {
			this.students = students;
			long tSum = 0;
			for (int level = 1; level <= arr.length; level++) {
				for (int i = 0; i < arr.length - level + 1; i++) {
					rUnion(1, i, level, 1);
					if (level % 2 == 1) {
						tSum += sum;
					} else {
						tSum -= sum;
					}
					sum = 0;
				}
			}
			return tSum;
		}

		private void rUnion(int level, int i, int r, long mul) {
			// System.out.println("rUnion("+level+",{"+arr[i]+"},"+r+","+mul+")");
			if (level == r) {
				sum += Math.floor(this.students / (mul * arr[i]));
			} else {
				for (int j = i + 1; j < arr.length - (r - level - 1); j++) {
					rUnion(level + 1, j, r, mul * arr[i]);
				}
			}
		}
	}

}
