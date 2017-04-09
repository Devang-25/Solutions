package hackerearth.examples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleKuldeepAndContests {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		TreeSet<Interval> intervalTree = new TreeSet<Interval>(new IntervalComparator());
		Pattern p = Pattern.compile("(\\d\\d):(\\d\\d)-(\\d\\d):(\\d\\d)");
		Integer time[][] = new Integer[N][2];
		for (int i = 0; i < N; i++) {
			String interval = in.next();
			Matcher m = p.matcher(interval);
			m.matches();
			Interval intervalObj= new Interval(m.group(1) ,m.group(2),m.group(3) , m.group(4));
			intervalTree.add(intervalObj);
		}
		System.out.println(intervalTree);
		Stack<Interval> stack = new Stack<Interval>();
		stack.push(intervalTree.pollFirst());
		boolean can=true;
		while (!intervalTree.isEmpty()) {
			Interval e = intervalTree.pollFirst();
			Interval stackTop=stack.peek();
			if(e.sHr>stackTop.endHr||(e.sHr==stackTop.endHr&& e.sMin>=stackTop.endMin)){
				stack.push(e);
			}else{
				can=false;
				break;
			}
			
		}
		if(can){
			System.out.println("Who needs a moderator?");
		}else{
			System.out.println("Will need a moderator!");
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
			this.start=sHr+":"+sMin;
			this.end=endHr+":"+endMin;
		}
		
		@Override
		public String toString() {
			return this.start+"-"+this.end;
		}
	}
}
