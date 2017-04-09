package hackerearth.examples;

import java.util.Scanner;

public class TheHomeAwayConundrum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int teams = in.nextInt();
		int colors[] = new int[100000 + 1];
		int teamAway[] = new int[teams];
		for (int i = 1; i <= teams; i++) {
			int homeColor = in.nextInt();
			int awayColor = in.nextInt();
			colors[homeColor]++;
			teamAway[i - 1] = awayColor;
		}
		int homeMatches = teams - 1;
		for (int i = 0; i < teams; i++) {
			int clash = colors[teamAway[i]];
			int homeColor = homeMatches + clash;
			System.out.println(homeColor + " " + (2 * homeMatches - homeColor));
		}
	}
}
