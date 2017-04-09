package hackerrank;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class JimAndTheSkyscrapers {
	// think more about this datastructure here.
	private static HashMap<Integer, TreeSet<Integer>> heightIndexMap = new HashMap<Integer, TreeSet<Integer>>();
	private static TreeSet<Integer> heights=new TreeSet<Integer>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int skyscrapers = in.nextInt();
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < skyscrapers; i++) {
			int hi = in.nextInt();
			if (!heightIndexMap.containsKey(hi)) {
				heightIndexMap.put(hi, new TreeSet<Integer>());
			}
			heightIndexMap.get(hi).add(i);
			if(hi>max){
				max=hi;
			}
			heights.add(hi);
		}
		System.out.println(heightIndexMap);
		// now we have an index of skyscrapper locations.
		long routes = getRoutes(max, -1, 1000000);
		System.out.println(routes);
	}

	private static long getRoutes(Integer skyscrapper, int a, int b) {
		if (skyscrapper==null ||skyscrapper == 0 || b - a < 2) {
			return 0;
		}
		System.out.println("Height:" + skyscrapper + "{" + a + "," + b + "}");
		TreeSet<Integer> allLocs = heightIndexMap.get(skyscrapper);
		long routes = 0;
		Collection<Integer> set = null;
		if (allLocs != null && !allLocs.isEmpty()
				&& !(set = allLocs.subSet(a, false, b, false)).isEmpty()) {
			int t = set.size();
			System.out.println("Comb:" + t * (t - 1));
			routes += t * (t - 1);
			System.out.println(set + ";" + routes);
			if (!set.isEmpty()) {
				int s = a;
				for (int e : set) {
					routes += getRoutes(heights.floor(skyscrapper - 1), s, e);
					s = e;
				}
				routes += getRoutes(heights.floor(skyscrapper - 1), s, b);
			}
		} else {
			routes += getRoutes(heights.floor(skyscrapper - 1), a, b);
		}
		return routes;
	}
}
