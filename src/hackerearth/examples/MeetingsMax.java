/**
 * 
 */
package hackerearth.examples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author makkg
 *
 */
public class MeetingsMax {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c=in.nextInt();
		TreeSet<Interval> intervals=new TreeSet<>(new IntervalComparator());
		for(int i=1;i<=c;i++){
			intervals.add(new Interval(in.nextInt(), in.nextInt()));
		}
		System.out.println(intervals);
		Interval intv[]=intervals.toArray(new Interval[intervals.size()]);
		int j=intv[0].e;
		int total=1;
		for(int i=1;i<intv.length;i++){
			if(intv[i].s>=j){
				total++;
				j=intv[i].e;
				System.out.println(intv[i]);
			}
		}
		System.out.println(total);
	}

	static class Interval {
		int s;
		int e;
		/**
		 * @param s
		 * @param e
		 */
		public Interval(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return this.s+"-"+this.e;
		}
		
	}

	static class IntervalComparator implements Comparator<Interval> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.e < o2.e) {
				return -1;
			}
			if (o1.e == o2.e) {
				if (o1.s < o2.s) {
					return -1;
				}
				return 1;
			}
			return 1;
		}

	}
}
