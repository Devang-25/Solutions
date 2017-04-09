package hackerearth.examples;

import java.util.Scanner;

public class Comrades1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		StringBuilder b=new StringBuilder();
		for (int t = 1; t <= testCases; t++) {
			int s = in.nextInt();
			int superiors[] = new int[s + 1];
			for (int i = 1; i < superiors.length; i++) {
				superiors[i] = in.nextInt();
			}
			int queries = in.nextInt();
			for (int i = 1; i <= queries; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				int reviews = 0;
				boolean invalid = false;
				while (superiors[x] != y) {
					reviews++;
					x = superiors[x];
					if (x == 0) {
						invalid = true;
						break;
					}
				}
				if (invalid) {
					b.append(-1);
				} else {
					b.append(reviews);
				}
				if(i != queries){
					b.append("\n");
				}
			}
		}
		System.out.println(b.toString());
	}
}
