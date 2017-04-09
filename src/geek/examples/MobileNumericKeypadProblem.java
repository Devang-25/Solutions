/**
 * 
 */
package geek.examples;

/**
 * @author makkg
 *
 */
public class MobileNumericKeypadProblem {
	public static void main(String[] args) {
		char keypad[][] = { { '1', '2', '3' }, { '4', '5', '6' },
				{ '7', '8', '9' }, { '*', '0', '#' } };
		long count = getCount(keypad, 27);
		System.out.println(count);
	}

	/**
	 * @param keypad
	 * @return
	 */
	private static long getCount(char[][] keypad, int n) {
		long count[][] = new long[10][n + 1];
		int row[] = { 0, 0, -1, 0, 1 };
		int col[] = { 0, -1, 0, 1, 0 };
		for (int i = 0; i < 10; i++) {
			count[i][0] = 0;
			count[i][1] = 1;
		}
		// for 2,3,4,5,6,,,,,length of phone number.
		for (int k = 2; k <= n; k++) {
			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 2; j++) {
					if (keypad[i][j] != '*' && keypad[i][j] != '#') {
						int num = keypad[i][j] - '0';
						// i, j is current position.
						for (int dir = 0; dir < row.length; dir++) {
							int newI = i+row[dir];
							int newJ = j+col[dir];
							// ensure this is a valids position.
							if (newI >= 0 && newI <= 3 && newJ >= 0
									&& newJ <= 2 && keypad[newI][newJ] != '*'
									&& keypad[newI][newJ] != '#') {
								int nextNum = keypad[newI][newJ] - '0';
								/*
								 * */
								count[num][k] += count[nextNum][k - 1];
							}
						}

					}
				}
			}
		}

		long total = 0;
		for (int i = 0; i < 10; i++) {
			total += count[i][n];
		}
		return total;
	}
}
