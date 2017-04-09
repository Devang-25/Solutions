package hackerearth.examples;

import java.util.Scanner;

public class ArithmancyChallenge {
	public static void main(String[] args) {
		int periodicity[] = { 0, 1, 4, 4, 2, 1, 1, 4, 4, 2 };
		int cache[][] = new int[10][10];
		StringBuilder b=new StringBuilder();
		for (int i = 2; i <= 9; i++) {
			cache[i][0] = i;
			int prod = (i * i) % 10;
			for (int j = 1; j < periodicity[i]; j++) {
				cache[i][j] = prod;
				prod = (prod * i) % 10;
			}
		}
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			long B = in.nextLong();
			long E = in.nextLong();
			String BStr = B + "";
			char lastChar = BStr.charAt(BStr.length() - 1);
			if (lastChar == '1') {
				b.append(1);
			} else if (lastChar == '0') {
				b.append(0);
			} else {
				int lPos = Integer.parseInt(lastChar + "");
				if (periodicity[lPos] == 1) {
					b.append(lPos);
				} else {
					int rem = (int) ((E-1) % periodicity[lPos]);
					b.append(cache[lPos][rem]);
				}
			}
			if(i!=testCases){
				b.append("\n");
			}
		}
		System.out.println(b.toString());
	}
}
