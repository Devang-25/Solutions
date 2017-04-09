package codechef.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class RRDAG {

	private static int outDegree[];
	private static boolean edges[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		edges = new boolean[N][N];
		outDegree = new int[N];
		for (int i = 0; i < N; i++) {
			String edgeStr = in.next();
			System.out.println(edgeStr);
			for (int c = 0; c < edgeStr.length(); c++) {
				if (edgeStr.charAt(c) == '1') {
					edges[i][c] = true;
					outDegree[i]++;
				}
			}
		}
		int edgeC = 0;
		ArrayList<TreeSet<Integer>>orders = new ArrayList<TreeSet<Integer>>(N);
		for(int i=0;i<N;i++){
			orders.add(new TreeSet<Integer>());
		}
		boolean used[] = new boolean[N];
		
		for (int i = 0; i < N; i++) {

			int v = -1;
			for (int j = N - 1; j >= 0; j--) {
				if (!used[j] && outDegree[j] == 0) {
					v = j;
					break;
				}
			}
			System.out.println("outdegree O= "+ v);
			used[v] = true;
			for (int j = 0; j < N; j++) {
				if (j != v && !used[j]) {
					if (!edges[j][v]) {
						edgeC += 1;
						orders.get(j).add(v);
					} else {
						if (edges[j][v]) {
							outDegree[j]--;
						}
					}
				}
			}
		}
		System.out.println(edgeC);
		int i=0;
		for (TreeSet<Integer> edges : orders) {
			for(int v:edges){
				System.out.println(i+" "+v);
			}
			i++;
		}

	}

}
