package codechef.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class FriendsSlow {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<LinkedList<Integer>> fList = new ArrayList<LinkedList<Integer>>(
				n);
		for (int i = 0; i < n; i++) {
			fList.add(new LinkedList<Integer>());
		}
		for (int i = 1; i < n; i++) {
			String rel = in.next().substring(i);
			//System.out.println(rel);
			int j = i;
			for (char c : rel.toCharArray()) {
				if (c == '1') {
					fList.get(i - 1).add(j);
					fList.get(j).add(i - 1);
				}
				j++;
			}
		}
		in.next();
		//System.out.println(fList);
		int friendRequests = 0;
		for (int i = 0; i < n; i++) {
			TreeSet<Integer> set = new TreeSet<Integer>();
			set.add(i);
			set.addAll(fList.get(i));
			TreeSet<Integer> potentials = new TreeSet<Integer>();
			for (int neighbour : fList.get(i)) {
				for (int p : fList.get(neighbour)) {
					if (!set.contains(p)) {
						potentials.add(p);
					}
				}
			}
			//System.out.println(potentials);
			friendRequests += potentials.size();
		}
		System.out.println(friendRequests);

	}
}
