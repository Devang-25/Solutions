package hackerearth.examples;

import java.util.Scanner;

public class PrisonBreak {
	

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();

		for (int m = 1; m <= testCases; m++) {
			int matrixSize = in.nextInt();
			Cell[][] cells = new Cell[matrixSize][matrixSize];
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells.length; j++) {
					cells[i][j] = new Cell(in.nextInt() == 1);
				}
			}
			if (cells[0][0].hasCamera
					|| cells[cells.length - 1][cells.length - 1].hasCamera) {
				return;
			}
			int moves = move(cells, 0, 0);
			System.out.println(moves);
		}

	}

	public static int move(Cell[][] cells, int i, int j) {
		if (i < 0 || j < 0 || i == cells.length || j == cells.length) {
			return 0;
		}
		if (cells[i][j].hasCamera) {
			return 0;
		}
		if (i == cells.length - 1 && j == cells.length - 1) {
			return 1;
		}
		if (!cells[i][j].isVisited) {
			cells[i][j].isVisited = true;
			int moves = move(cells, i + 1, j) + move(cells, i, j + 1)
					+ move(cells, i - 1, j) + move(cells, i, j - 1);
			cells[i][j].isVisited = false;
			return moves;
		}
		return 0;
	}
}

 class Cell {
	final boolean hasCamera;
	boolean isVisited = false;

	Cell(boolean c) {
		hasCamera = c;
	}
}