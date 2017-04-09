package geek.examples;

import java.util.LinkedList;
import java.util.Queue;
//this code is not tested.
public class RottenOranges {
	// function to check whether a cell is valid / invalid
	static boolean isvalid(int[][] arr, int i, int j) {
		return (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length);
	}

	// structure for storing coordinates of the cell
	static class Orange {
		int x, y;
	}

	// Function to check whether the cell is delimiter
	// which is (-1, -1)
	static boolean isdelim(Orange temp) {
		return (temp.x == -1 && temp.y == -1);
	}

	// Function to check whether there is still a fresh
	// orange remaining
	static boolean checkall(int arr[][]) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}

	// This function finds if it is possible to rot all oranges or not.
	// If possible, then it returns minimum time required to rot all,
	// otherwise returns -1
	static int rotOranges(int arr[][]) {
		// Create a queue of cells
		Queue<Orange> Q = new LinkedList<>();
		Orange temp = new Orange();
		int ans = 0;

		// Store all the cells having rotten orange in first time frame
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 2) {
					// if this is a rotten orange.
					temp.x = i;
					temp.y = j;
					Q.add(temp);
				}
			}
		}

		// Separate these rotten oranges from the oranges which will rotten
		// due the oranges in first time frame using delimiter which is (-1, -1)
		temp.x = -1;
		temp.y = -1;
		Q.add(temp);
		System.out.println(Q);
		// Process the grid while there are rotten oranges in the Queue
		while (!Q.isEmpty()) {
			// This flag is used to determine whether even a single fresh
			// orange gets rotten due to rotten oranges in current time
			// frame so we can increase the count of the required time.
			boolean flag = false;

			// Process all the rotten oranges in current time frame.
			while (!isdelim(Q.peek())) {
				temp = Q.remove();
				System.out.println(temp);
				// Check right adjacent cell that if it can be rotten
				if (isvalid(arr, temp.x + 1, temp.y) && arr[temp.x + 1][temp.y] == 1) {
					// if this is the first orange to get rotten, increase
					// count and set the flag.
					if (!flag) {
						ans++;
						flag = true;
					}

					// Make the orange rotten
					arr[temp.x + 1][temp.y] = 2;

					// push the adjacent orange to Queue
					temp.x++;
					Q.add(temp);

					temp.x--; // Move back to current cell
				}

				// Check left adjacent cell that if it can be rotten
				if (isvalid(arr, temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x - 1][temp.y] = 2;
					temp.x--;
					Q.add(temp); // push this cell to Queue
					temp.x++;
				}

				// Check top adjacent cell that if it can be rotten
				if (isvalid(arr, temp.x, temp.y + 1) && arr[temp.x][temp.y + 1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y + 1] = 2;
					temp.y++;
					Q.add(temp); // Push this cell to Queue
					temp.y--;
				}

				// Check bottom adjacent cell if it can be rotten
				if (isvalid(arr, temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y - 1] = 2;
					temp.y--;
					Q.add(temp); // push this cell to Queue
				}

				Q.remove();
			}

			// Pop the delimiter
			Q.remove();

			// If oranges were rotten in current frame than separate the
			// rotten oranges using delimiter for the next frame for processing.
			if (!Q.isEmpty()) {
				System.out.println(Q);
				temp.x = -1;
				temp.y = -1;
				Q.add(temp);
			}

			// If Queue was empty than no rotten oranges left to process so exit
		}

		// Return -1 if all arranges could not rot, otherwise -1.
		return (checkall(arr)) ? -1 : ans;
	}

	// Drive program
	public static void main(String args[]) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotOranges(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot\n");
		else
			System.out.println("Time required for all oranges to rot => " + ans);
	}
}
