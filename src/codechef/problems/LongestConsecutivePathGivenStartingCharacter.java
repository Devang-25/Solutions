package codechef.problems;

public class LongestConsecutivePathGivenStartingCharacter {

	public static void main(String[] args) {
		char mat[][] = new char[][] { { 'a', 'c', 'd' }, { 'h', 'b', 'a' },
				{ 'i', 'g', 'f' } };

		char s = 'a';
		int max = new LongestConsecutivePathGivenStartingCharacter().getLen(
				mat, s);
		System.out.println(max);
	}

	// tool matrices to recur for adjacent cells.
	int x[] = { 0, 1, 1, -1, 1, 0, -1, -1 };
	int y[] = { 1, 0, 1, 1, -1, -1, 0, -1 };

	// Used to keep track of visited cells.
	boolean visited[][];

	int dp[][][];

	// check whether mat[i][j] is a valid cell or not.
	boolean isvalid(int i, int j) {
		if (i < 0 || j < 0 || i >= R || j >= C)
			return false;
		return true;
	}

	// Check whether current character is adjacent to previous
	// character (character processed in parent call) or not.
	boolean isadjacent(char prev, char curr) {
		return ((curr - prev) == 1);
	}

	private int R;
	private int C;

	int getLen(char mat[][], char s) {
		int ans = 0;
		this.R = mat.length;
		this.C = mat[0].length;
		visited = new boolean[R][C];
		this.dp = new int[R][C][26];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				// check for each possible starting point
				if (mat[i][j] == s) {
					System.out.println(" getLenUtilA -mat[" + i + "][" + j
							+ "], this:" + s);
					// recur for all eight adjacent cells
					for (int k = 0; k < 8; k++) {
						ans = Math.max(ans,
								1 + getLenUtil(mat, i + x[k], j + y[k], s));
					}
				}
			}
		}
		return ans;
	}

	int getLenUtil(char mat[][], int i, int j, char prev) {

		if (!isvalid(i, j) || !isadjacent(prev, mat[i][j]) || visited[i][j])
			return 0;
		System.out.println(" getLenUtilB -mat[" + i + "][" + j + "], prev:"
				+ prev + "->" + mat[i][j]);
		// If this subproblem is already solved , return the answer
		if (dp[i][j][prev - 'a'] != 0)
			return dp[i][j][prev - 'a'];

		int ans = 0; // Initialize answer

		// mark current node, so it does not get included again.
		visited[i][j] = true;

		// recur for paths with differnt adjacent cells and store
		// the length of longest path.
		for (int k = 0; k < 8; k++) {
			ans = Math.max(ans,
					1 + getLenUtil(mat, i + x[k], j + y[k], mat[i][j]));
		}
		System.out.println(ans);

		// unmark current node so can be processed later as part of
		// some another path if possible
		visited[i][j] = false;

		// save the answer and return
		dp[i][j][prev - 'a'] = ans;
		return ans;
	}

}
