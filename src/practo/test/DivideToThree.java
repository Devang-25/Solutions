package practo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DivideToThree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> sets = new ArrayList<Integer>(3);
		sets.add(0);
		sets.add(0);
		sets.add(0);
		ArrayList<Integer> strengths=new ArrayList<>();
		for(int i=0;i<n;i++){
			strengths.add(in.nextInt());
		}
		Collections.sort(strengths, Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int minIndex = sets.indexOf(Collections.min(sets));
			sets.set(minIndex, sets.get(minIndex) + strengths.get(i));
		}
		System.out.println(Collections.max(sets));
	}
}
