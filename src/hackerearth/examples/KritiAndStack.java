package hackerearth.examples;

import java.util.Scanner;
import java.util.TreeSet;

public class KritiAndStack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int kSize = in.nextInt();
		int meSize = in.nextInt();
		TreeSet<Integer> kSet = new TreeSet<Integer>();
		TreeSet<Integer> meSet = new TreeSet<Integer>();
		for (int i = 1; i <= kSize; i++) {
			kSet.add(in.nextInt());
		}

		for (int i = 1; i <= meSize; i++) {
			meSet.add(in.nextInt());
		}
		int queries = in.nextInt();
		for (int i = 1; i <= queries; i++) {
			int n = in.nextInt();
			char start = in.next().charAt(0);
			boolean iWin = doIWin(new TreeSet<Integer>(kSet), new TreeSet<Integer>(meSet), n, start == 'K' ? false : true);
			if(iWin){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

	private static boolean doIWin(TreeSet<Integer> kSet, TreeSet<Integer> sSet, int n,
			boolean me) {
		System.out.println("----------TEST-------------");
		TreeSet<Integer> first,second;
		if(me){
			first=sSet;
			second=kSet;
		}else{
			first=kSet;
			second=sSet;
		}
		while (n >= 0) {
			System.out.println("Floor :"+n+" in "+first);
			Integer max=getMax(first, second, n);
			System.out.println(max);
			if(max!=null && max==n ){
				return me;
			}
			if(max==null){
				return !me;
			}
			first.remove(max);
			n=n-max;
			System.out.println("Floor :"+n+" in "+second);
			max=getMax(second, first, n);
			System.out.println(max);
			if(max!=null && max==n ){
				return !me;
			}
			if(max==null){
				return me;
			}
			second.remove(max);
			n=n-max;
		}
		return false;
	}

	private static Integer getMax(TreeSet<Integer> first, TreeSet<Integer> second, int n) {
		Integer val=first.floor(n);
		while(val!=null){
			if(!second.contains(n-val)){
				first.remove(val);
				return val;
			}
			val=first.floor(val-1);
		}
		return val;
	}
}
