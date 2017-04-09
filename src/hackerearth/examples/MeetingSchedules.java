package hackerearth.examples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class MeetingSchedules {
	public static void main(String[] args) {
		TreeSet<Interval> intervalTree = new TreeSet<>(new IntervalComparator());
		Scanner in = new Scanner(System.in);
		int intervals = in.nextInt();
		int k = in.nextInt();
		for (int i = 1; i <= intervals; i++) {
			String sHr = in.next();
			String sMin = in.next();
			String endHr = in.next();
			String endMin = in.next();
			Interval interval = new Interval(sHr, sMin, endHr, endMin);
			intervalTree.add(interval);
		}
		//System.out.println(intervalTree);
		Stack<Interval> stack = new Stack<Interval>();
		stack.push(intervalTree.pollFirst());
		while (!intervalTree.isEmpty()) {
			Interval e = intervalTree.pollFirst();
			if (stack.peek().perfectOverLaps(e)) {
				// ignore..
				continue;
			}
			if (stack.peek().partialOverLaps(e, k)) {
				//System.out.println(stack.peek() + ":Partial :" + e);
				stack.peek().endHr = e.endHr;
				stack.peek().endMin = e.endMin;
				stack.peek().end=e.end;
			} else {
				stack.push(e);
			}
		}
		//System.out.println(stack);
		if(!stack.isEmpty()){
			if(stack.get(0).minuteS()>=k){
				System.out.println("00 00 "+stack.get(0).start);	
			}
		}
		for(int i=0;i<stack.size()-1;i++){
			System.out.println((stack.get(i).end+" "+stack.get(i+1).start));
		}
		if(stack.get(stack.size()-1).minuteE()+k<=24*60){
			System.out.println(stack.get(stack.size()-1).end+" 00 00");
		}
	}

	static class IntervalComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			if (o1.sHr < o2.sHr) {
				return -1;
			}
			if (o1.sHr > o2.sHr) {
				return 1;
			}
			if (o1.sMin < o2.sMin) {
				return -1;
			}
			return 1;
		}

	}

	static class Interval {
		int sHr;
		int sMin;
		int endHr;
		int endMin;
		String start;
		String end;
		public Interval(String sHr, String sMin, String endHr, String endMin) {
			super();
			this.sHr = Integer.parseInt(sHr);
			this.sMin = Integer.parseInt(sMin);
			this.endHr = Integer.parseInt(endHr);
			this.endMin = Integer.parseInt(endMin);
			this.start=sHr+" "+sMin;
			this.end=endHr+" "+endMin;
		}

		@Override
		public String toString() {
			return this.start+" "+this.start+" "+this.end+" "+this.end;
		}

		private int minuteS() {
			return this.sHr * 60 + this.sMin;
		}

		private int minuteE() {
			return this.endHr * 60 + this.endMin;
		}

		boolean perfectOverLaps(Interval b) {
			if (b.minuteS() >= this.minuteS() && b.minuteE() <= this.minuteE()) {
				return true;
			}
			return false;

		}

		boolean partialOverLaps(Interval b, int k) {
			/*
			 * either b's start lies in between this s and end or its start must
			 * lies with in k mins.
			 */
			if ((b.minuteS() >= this.minuteS() && b.minuteS() < this.minuteE() && b
					.minuteE() > this.minuteE())
					|| ((this.minuteE() + k > b.minuteS()))) {
				return true;
			}
			return false;

		}
	}
}
