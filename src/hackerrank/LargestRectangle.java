/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * @author makkg
 *
 */
public class LargestRectangle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		int height[]=new int[N];
		for(int i=0;i<height.length;i++){
			height[i]=in.nextInt();
		}
		long answer = 0L;
        for (int i = 0; i < N; i++) {
            int idx0 = i;
            for (; idx0 >= 1; idx0--) {
                if (height[idx0 - 1] < height[i]) {
                    break;
                }
            }
            int idx1 = i;
            for (; idx1 < height.length - 1; idx1++) {
                if (height[idx1 + 1] < height[i]) {
                    break;
                }
            }
            final long area = height[i] * (idx1 - idx0 + 1);
            if (area > answer) {
                answer = area;
            }
        }
        System.out.println(answer);
	}
	
	/*
	 * Problem Statement

There are N buildings in a certain one-dimensional landscape. If you join K adjacent buildings, they will form a solid rectangle of area K×min(h1,h2…,hk).

Given N buildings, find the greatest such solid area formed by consecutive buildings.

Input Format 
The first line contains N, the number of buildings altogether. 
The second line contains N space-separated integers, each representing the height of a building.

Constraints 
1≤N≤105 
1≤hi≤106
Output Format 
One integer representing the maximum area of rectangle formed.

Sample Input

5
1 2 3 4 5
Sample Output

9*/
}
