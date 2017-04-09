package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

public class MyNephewsGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			ArrayList<Integer> edges = new ArrayList<Integer>();
			int eCount = in.nextInt();
			double constant = 0;
			for (int i = 1; i <= eCount; i++) {
				int val = in.nextInt();
				edges.add(val);
				constant += val;
			}
			constant /= 2;
			Collections.sort(edges);
			Collections.reverse(edges);
			System.out.println(edges);
			checkPolygon(edges, constant);
			if(edges.size()==2){
				System.out.println(-1);
			}else{
				System.out.println(edges.size());
			}
		}
	}

	private static void checkPolygon(ArrayList<Integer> edges, double constant) {
		if(edges.size()==2){
			return ;
		}
		ListIterator<Integer> i = edges.listIterator();
		while (i.hasNext()) {
			int val = i.next();
			System.out.println("constant:"+constant);
			if (val >=constant) {
				i.remove();
				System.out.println(edges);
				checkPolygon(edges, constant - val / 2);
				break;
			}
		}

	}
}
