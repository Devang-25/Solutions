package hackerearth.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneDirect {
	static int rows = 0;
	static int paths = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		rows = in.nextInt() + 1;
		House houses[][] = new House[rows][];
		for (int i = 1; i < rows; i++) {
			houses[i] = new House[in.nextInt() + 1];
			// all references are null..
		}
		int roads = in.nextInt();
		for (int i = 0; i < roads; i++) {
			int r1 = in.nextInt();
			int h1 = in.nextInt();
			int r2 = in.nextInt();
			int h2 = in.nextInt();
			if (houses[r1][h1] == null) {
				houses[r1][h1] = new House(r1, h1);
			}

			if (houses[r2][h2] == null) {
				houses[r2][h2] = new House(r2, h2);
			}
			houses[r1][h1].roadsTo.add(houses[r2][h2]);
		}
		int queries = in.nextInt();
		for (int i = 1; i <= queries; i++) {
			int r1 = in.nextInt();
			int h1 = in.nextInt();
			if (houses[r1][h1] == null) {
				System.out.println(0);
			} else {
				pathsNR(houses[r1][h1]);
				System.out.println(paths);
				paths = 0;
			}
		}
	}

	private static void paths(House house) {
		if (house.row == rows - 1) {
			// if we are at the last row.
			paths++;
			return;
		}
		for (House h : house.roadsTo) {
			paths(h);
		}

	}

	private static void pathsNR(House house) {
		java.util.Stack<House> houses = new java.util.Stack<House>();
		houses.push(house);
		while (!houses.isEmpty()) {
			House h = houses.pop();
			if (h.row == rows - 1) {
				paths++;
			} else {
				for (House hz : h.roadsTo) {
					houses.push(hz);
				}
			}
		}

	}

	static class House {
		int row;
		int houseNo;

		House(int x, int y) {
			this.row = x;
			this.houseNo = y;
		}

		List<House> roadsTo = new ArrayList<House>();
	}

}
