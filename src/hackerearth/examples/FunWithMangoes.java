package hackerearth.examples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FunWithMangoes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int u = in.nextInt();
			TreeSet<Interval> set = new TreeSet<>(new Comparator<Interval>() {

				@Override
				public int compare(Interval i1, Interval i2) {
					if ( i1.e<i2.s) {
						return -1;
					}
					if(i1.s>i2.e){
						return 1;
					}
					return 0;
					
				}
			});
			for (int ui = 0; ui < u; ui++) {
				Interval i = new Interval(in.nextInt(), in.nextInt(),
						in.nextInt());
				set.add(i);
			}
			System.out.println(set);
			int q=in.nextInt();
			for(int i=1;i<=q;i++){
				int basket=in.nextInt();
				Set<Interval> range=set.subSet(new Interval(0, 0,0),true,new Interval(basket, basket, 0) , true);
				System.out.println(range);
				int count=0;
				for(Interval interval:range){
					count+=interval.v;
				}
				System.out.println(count);
			}
		}

	}

	static class Interval {
		int s;
		int e;
		int v;

		public Interval(int s, int e, int v) {
			super();
			this.s = s;
			this.e = e;
			this.v = v;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" + s + "," + e + "->" + v + "]";
		}
	}
}
