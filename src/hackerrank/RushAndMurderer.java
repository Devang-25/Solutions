package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RushAndMurderer {
	static ArrayList<TreeSet<Integer>> adj;

	public static void main(String args[])

	{
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();

		for (int t = 1; t <= testCases; t++)

		{

			int n = in.nextInt();
			adj = new ArrayList<TreeSet<Integer>>(n+1);
			for (int i = 0; i <=n; i++) {
				adj.add(new TreeSet<Integer>());
			}
			int m = in.nextInt();

			for (int e = 1; e <= m; e++) {
				int a = in.nextInt();
				int b = in.nextInt();
				adj.get(a).add(b);
				adj.get(b).add(a);
			}
			int s = in.nextInt();
			boolean vis[] = new boolean[n + 1];
			// memset(vis,false,sizeof(vis));
			vis[s] = true;
			Set<Integer> l1 = new TreeSet<Integer>();
			Set<Integer> l2 = new TreeSet<Integer>();
			for (int i = 1; i <= n; i++) {
				if (i != s)
					l1.add(i);
			}

			Queue<Integer> q = new LinkedList<Integer>();
			q.add(s);
			int dist[] = new int[n + 1];
			// memset(steps,0,sizeof(steps));
			while (!q.isEmpty()) {
				int u = q.peek();
				q.remove();
				for (int edge : adj.get(u)) {
					if (!vis[edge]) {
						l1.remove(edge);
						l2.add(edge);
					}
				}
				for (int z : l1) {
					vis[z] = true;
					q.add(z);
					dist[z] = dist[u] + 1;
				}
				l1 = l2;
				l2=new TreeSet<Integer>();
				//l2.clear();
			}
			for (int j = 1; j < dist.length; j++) {
				if (j != s) {
					System.out.print(dist[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
