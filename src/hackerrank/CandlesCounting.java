/**
 * 
 */
package hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author makkg
 *
 */
public class CandlesCounting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		//System.out.println(lis(arr, arr.length));
	}

	static int lis(int height[], int color[], int n) {
		int count = 0;
		List<Set<Integer>> lis = new ArrayList<Set<Integer>>(n);

		for (int i = 1; i < n; i++) {
			HashSet<Integer> s=new HashSet<>();
			s.add(color[i]);
			for (int j = 0; j < i; j++) {
				if (height[i] > height[j] ) {
					if(!lis.get(j).contains(color[i]) && lis.get(j).size()==6){
						count++;
					}
				}
			}
		}
		//aven hi
		return -1;
	}
}
