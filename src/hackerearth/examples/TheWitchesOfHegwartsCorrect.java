package hackerearth.examples;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
//in breadth first search..we move, on step at a time for each branch.
public class TheWitchesOfHegwartsCorrect {

	public static void main(String args[]) {
		TreeSet<Long> s = new TreeSet<Long>();//log(n) search.
		ArrayList<Long> v = new ArrayList<Long>();
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		while (tc != 0) {
			tc--;
			v.clear();
			s.clear();

			long n = in.nextLong();
			int ans = 0;
			v.add(n);

			int i = 0, f = 0, j = 1;

			while (true) {
				if (n == 1)
					break;
				if (f == 1)
					break;
				ans += 1;
				System.out.println(i + ":" + j);
				System.out.println(s);
				System.out.println(v);
				for (int k = i; k < j; k++) {
					long by3 = -1, by2 = -1, minus1 = -1;
					long kth = v.get(k);
					System.out.println("Kth:" + kth);
					if (kth % 3 == 0)
						by3 = kth / 3;
					if (kth % 2 == 0)
						by2 = kth / 2;
					minus1 = kth - 1;
					if (by3 == 1 || by2 == 1 || minus1 == 1) {
						f = 1;
						break;
					}
					if (by3 != -1) {
						System.out.println("x:"+by3);
						if (!s.contains(by3)) {
							s.add(by3);
							v.add(by3);
						}
					}
					if (by2 != -1) {
						System.out.println("y"+by2);
						if (!s.contains(by2)) {
							s.add(by2);
							v.add(by2);
						}
					}
					if (minus1 != -1) {
						System.out.println("z:"+minus1);
						if (!s.contains(minus1)) {
							s.add(minus1);
							v.add(minus1);
						}
					}
				}
				i = j;
				j = v.size();
			}
			System.out.println(ans);
		}
	}
}
