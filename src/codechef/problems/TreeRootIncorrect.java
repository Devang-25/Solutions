package codechef.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TreeRootIncorrect {
	private static HashMap<Integer, ArrayList<Integer>> sumT = null;
	private static int[] nodesSum = null;
	private static TreeSet<Integer> roots;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			roots=new TreeSet<Integer>();
			int nodes = in.nextInt();
			nodesSum = new int[31];
			nodesSum[0]=-1;
			sumT = new HashMap<>();
			for (int n = 1; n <= nodes; n++) {
				int nodeId = in.nextInt();
				int sum = in.nextInt();
				nodesSum[nodeId] = sum;
				if (!sumT.containsKey(sum)) {//O(1)
					sumT.put(sum, new ArrayList<Integer>());//O(1)
				}
				sumT.get(sum).add(nodeId);//O(1)
			}
			//System.out.println(sumT);
			processSum(0);
			Integer[] list=roots.toArray(new Integer[roots.size()]);
			for(int i=0;i<list.length-1;i++){
				System.out.print(list[i]+" ");
			}
			System.out.print(list[list.length-1]);
			System.out.println();
		}

	}

	private static boolean processSum(int sum) {
		//System.out.println("sum:" + sum);
		List<Integer> candidates = sumT.get(sum);
		if (sum == 0) {
			sumT.remove(sum);
		}
		if (candidates != null) {
			//display(candidates);
			for (int id : candidates) {
				processId(id);
			}
			return true;
		}
		return false;
	}

	private static void display(List<Integer> candidates) {
		System.out.print("[");
		for (Integer i : candidates) {
			if (nodesSum[i] != -1)
				System.out.print(i + ",");
		}
		System.out.println("]");
	}

	private static void processId(int id) {
		int sumK = nodesSum[id];
		if (nodesSum[id] == -1) {
			return;
		}
		nodesSum[id] = -1;
		//System.out.println("try alone:"+id);
		boolean possibleAlone=processSum(id);
		// scan the sum table and look for all positives
		Set<Integer> allSums = sumT.keySet();
		boolean possibleComb=false;
		for (Integer thisSum : allSums) {
			if (thisSum - id >= 0) {
				int searchId = thisSum - id;
				if (nodesSum[searchId] != -1) {
					possibleComb=true;
					if(searchId>id){// we have our parent node.
					//System.out.println("try "+id+" with:" + searchId);
					// we have an id here and a sum to guide us to the
					// next level.
					int temp = nodesSum[searchId];
					nodesSum[searchId] = -1;
					processSum(thisSum);
					nodesSum[searchId] = temp;
					}
				}
			}
		}
		if(!possibleAlone && !possibleComb){
			roots.add(id);
			//System.out.println("done:::::"+id);
		}
		nodesSum[id] = sumK;
	}
}
