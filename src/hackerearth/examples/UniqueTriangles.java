package hackerearth.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class UniqueTriangles {
	static class Triangle {
		final long code;
		boolean isU = true;

		Triangle(Long a[]) {
			List<Long> l = Arrays.asList(a);
			Collections.sort(l);
			code = l.get(0) * 100 + l.get(1) * 10 + l.get(2);
			System.out.println(code);
		}

	}

	static class TriangleComparator implements Comparator<Triangle> {

		@Override
		public int compare(Triangle t1, Triangle t2) {
			if (t1.code == t2.code) {
				System.out.println("C1:"+t1.code);
				System.out.println("C2:"+t2.code);
				t1.isU = false;
				t2.isU=false;
				return 0;
			}
			if (t1.code < t2.code) {
				return -1;
			}
			return 1;
		}
	}

	public static void main(String args[]) {
		TreeSet<Triangle> t = new TreeSet<Triangle>(new TriangleComparator());
		t.clear();
		Scanner in = new Scanner(System.in);
		if (in.hasNextInt()) {
			int instances = in.nextInt();
			System.out.println(instances);
			for (int i = 1; i <= instances; i++) {
				// for each triangle
				long a = in.nextLong();
				long b = in.nextLong();
				long c = in.nextLong();
				Triangle tri = new Triangle(new Long[] { a, b, c });
				if (t.add(tri)) {
					 System.out.println("added");
				}
			}
		}
		int uniques = 0;
		for (Triangle temp : t) {
			if (temp.isU) {
				System.out.println(temp.code);
				uniques++;
			}
		}
		System.out.println(uniques);
	}

	/*
	 * public static void rough() throws NumberFormatException, IOException {
	 * BufferedReader reader = new BufferedReader(new InputStreamReader(
	 * System.in)); int instances = Integer.parseInt(reader.readLine());
	 * System.out.println(instances); for (int i = 1; i <= instances; i++) {
	 * System.out.println(reader.readLine()); }
	 * 
	 * }
	 */
}
