package hackerearth.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BattleOfPanipat {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int vertices = in.nextInt();
		List<List<Integer>> aCyclicTree = new ArrayList<List<Integer>>(vertices);
		for (int i = 1; i <= vertices; i++) {
			aCyclicTree.add(new LinkedList<Integer>());
		}
		int i = 1;
		while (i <= vertices - 1) {
			int s = in.nextInt();
			int e = in.nextInt();
			aCyclicTree.get(s).add(e);
			i++;
		}
		System.out.println(aCyclicTree);
		int countOfPaths=1;
		int level=0;//till now. the node itself.
		Queue<Integer> q=new LinkedList<Integer>();
		for(int j=0;j<vertices;j++){
			q.add(j);
		}
		q.add(null);
		while(level<=vertices-1){
			Integer v=null;
			while((v=q.remove())!=null){
				countOfPaths++;	
				q.addAll(aCyclicTree.get(v));
			}
			q.add(null);
			level++;
		}
		System.out.println(countOfPaths);
		long c=(countOfPaths%((long)(Math.pow(10, 9)+7)));
		System.out.println(c);

	}
}
