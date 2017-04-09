package codechef.problems;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeSet;

public class MBOARD {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream s=new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(s);
		int n = in.nextInt() + 1;
		int q = in.nextInt();
		int rs0ts[] = new int[n];
		int rs1ts[] = new int[n];
		int cs0ts[] = new int[n];
		int cs1ts[] = new int[n];
		TreeSet<Integer> row0Set = new TreeSet<>();
		TreeSet<Integer> row1Set = new TreeSet<>();
		TreeSet<Integer> col0Set = new TreeSet<>();
		TreeSet<Integer> col1Set = new TreeSet<>();
		for (int timeStamp = 1; timeStamp <= q; timeStamp++) {
			final String code = in.next();
			if (code.equals("RowQuery")) {
				int x = in.nextInt();
				if (rs0ts[x] >= rs1ts[x]) {
					int latest = rs0ts[x];
					int ones = col1Set.subSet(latest, true, Integer.MAX_VALUE,
							false).size();
					System.out.println(n - ones - 1);
				} else {
					int latest = rs1ts[x];
					int zeroes = col0Set.subSet(latest, true,
							Integer.MAX_VALUE, false).size();
					System.out.println(zeroes);
				}
			} else if (code.equals("ColSet")) {
				int i = in.nextInt();
				int x = in.nextInt();
				if (cs0ts[i] > cs1ts[i]) {
					col0Set.remove(cs0ts[i]);
				} else {
					col1Set.remove(cs1ts[i]);
				}
				if (x == 0) {
					col0Set.add(timeStamp);
					cs0ts[i] = timeStamp;
				} else {
					col1Set.add(timeStamp);
					cs1ts[i] = timeStamp;
				}
			} else if (code.equals("ColQuery")) {
				int x = in.nextInt();
				if (cs0ts[x] >= cs1ts[x]) {
					int latest = cs0ts[x];
					int ones = row1Set.subSet(latest, true, Integer.MAX_VALUE,
							false).size();
					System.out.println(n - ones - 1);
				} else {
					int latest = cs1ts[x];
					int zeroes = row0Set.subSet(latest, true,
							Integer.MAX_VALUE, false).size();
					System.out.println(zeroes);
				}
			} else if (code.equals("RowSet")) {
				int i = in.nextInt();
				int x = in.nextInt();
				if (rs0ts[i] > rs1ts[i]) {
					row0Set.remove(rs0ts[i]);
				} else {
					row1Set.remove(rs1ts[i]);
				}
				if (x == 0) {
					row0Set.add(timeStamp);
					rs0ts[i] = timeStamp;
				} else {
					row1Set.add(timeStamp);
					rs1ts[i] = timeStamp;
				}
			}

		}
		System.out.flush();
	}
}
