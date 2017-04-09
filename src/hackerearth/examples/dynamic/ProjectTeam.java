package hackerearth.examples.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/*
 * A Professor of Physics gave projects to the students of his class. The students have to form a team of two for doing the project. The professor left the students to decide the teams. The number of students in a class will be even.

 Each student has a knowledge level. It tells how much knowledge each student has. The knowledge level of a team is the sum of the knowledge levels of both the students.

 The students decide to form groups such that the difference between the team with highest knowledge and the one with lowest knowledge is minimum.

 Input

 First line of the input will contain number of test cases t; In the next t lines the first number is n the number of students in the class followed by n integers denoting the knowledge levels of the n students

 Output

 Your output should be a single line containing the lowest possible difference between the team with highest knowledge and the one with lowest knowledge.

 Sample Input (Plaintext Link)
 2
 4 2 6 4 3
 6 1 1 1 1 1 1
 Sample Output (Plaintext Link)
 1
 0
 Explanation
 Input Constraints are

 1 <= t <= 100
 1 <= n <= 100
 1 <= knowledge level <= 10000
 
 
 */
public class ProjectTeam {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n / 2; i++) {
				min = Math.min(min, arr[i] + arr[n - i - 1]);
				max = Math.max(max, arr[i] + arr[n - i - 1]);
			}
			System.out.println(max - min);
		}
	}
}
