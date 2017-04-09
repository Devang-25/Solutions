package geek.examples;

public class OptimalReadListForDays {
	// Define total chapters in the book
	// Number of days user can spend on reading
	private static int CHAPTERS = 4;
	private static int DAYS = 3;
	private static int NOLINK = -1;

	// Array to store the final balanced schedule
	static int optimal_path[] = new int[DAYS + 1];

	// Graph - Node chapter+1 is the sink described in the
	// above graph
	static int DAG[][] = new int[CHAPTERS + 1][CHAPTERS + 1];

	// A DFS based recursive function to store the optimal path
	// in path[] of size path_len. The variable sum stores sum of
	// of all edges on current path. k is number of days spent so
	// far.
	static void assignChapters(int u, int[] path, int path_len, int sum, int k) {
		int min = Integer.MAX_VALUE;

		// Ignore the assignment which requires more than required days
		if (k < 0)
			return;

		// Current assignment of chapters to days
		path[path_len] = u;
		path_len++;

		// Update the optimal assignment if necessary
		if (k == 0 && u == CHAPTERS) {
			if (sum < min) {
				updateAssignment(path, path_len);
				min = sum;
			}
		}

		// DFS - Depth First Search for sink
		for (int v = u + 1; v <= CHAPTERS; v++) {
			sum += DAG[u][v];
			assignChapters(v, path, path_len, sum, k - 1);
			sum -= DAG[u][v];
		}
	}

	// This function finds and prints optimal read list. It first creates a
	// graph, then calls assignChapters().
	static void minAssignment(int pages[]) {
		// 1) ............CONSTRUCT GRAPH.................
		// Partial sum array construction S[i] = total pages
		// till ith chapter
		int avg_pages = 0, sum = 0, S[] = new int[CHAPTERS + 1], path[] = new int[DAYS + 1];
		S[0] = 0;

		for (int i = 0; i < CHAPTERS; i++) {
			sum += pages[i];
			S[i + 1] = sum;
		}

		// Average pages to be read in a day
		avg_pages = Math.round(sum / DAYS);

		/*
		 * DAG construction vertices being chapter name & Edge weight being
		 * |avg_pages - pages in a chapter| Adjacency matrix representation
		 */
		for (int i = 0; i <= CHAPTERS; i++) {
			for (int j = 0; j <= CHAPTERS; j++) {
				if (j <= i)
					DAG[i][j] = NOLINK;
				else {
					sum = Math.abs(avg_pages - (S[j] - S[i]));
					DAG[i][j] = sum;
				}
			}
		}

		// 2) ............FIND OPTIMAL PATH................
		assignChapters(0, path, 0, 0, DAYS);

		// 3) ..PRINT OPTIMAL READ LIST USING OPTIMAL PATH....
		System.out.println("Optimal Chapter Assignment");
		int ch;
		for (int i = 0; i < DAYS; i++) {
			ch = optimal_path[i];
			System.out.println("Day" + (i + 1) + ": " + ch + " ");
			ch++;
			while ((i < DAYS - 1 && ch < optimal_path[i + 1]) || (i == DAYS - 1 && ch <= CHAPTERS)) {
				System.out.println(ch);
				ch++;
			}
		}
	}

	// This funtion updates optimal_path[]
	static void updateAssignment(int[] path, int path_len) {
		for (int i = 0; i < path_len; i++)
			optimal_path[i] = path[i] + 1;
	}

	// Driver program to test the schedule
	public static void main(String args[]) {
		int pages[] = new int[] { 7, 5, 6, 12 };

		// Get read list for given days
		minAssignment(pages);
	}
}
