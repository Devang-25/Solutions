package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;
/*I miss understood the problem..thought the bag could have only two.
 * */
public class CriminalsLittleDeepuAndLittleKuldeepIncorrect {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases =in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int boxCount =in.nextInt();
			Integer boxes[] = new Integer[boxCount];
			for(int i=0;i<boxCount;i++){
				boxes[i]=/*(int) (Math.random()*40);*/in.nextInt();
			}
			System.out.println(boxesNeeded(boxes));
		}
	}
//there is no constraint of two.
	static int boxesNeeded(Integer boxes[]) {
		Arrays.sort(boxes);
		System.out.println(Arrays.asList(boxes));
		int count = 0;
		int notPacked=1;
		int beginsAt=0;
		for (int i = 1; i < boxes.length; i++) {
			if(notPacked!=0){
				if(boxes[beginsAt]<boxes[i]){
					notPacked--;
					count++;
					beginsAt+=2;
				}else{
					notPacked++;
				}
			}else{
				notPacked++;
			}
		}
		System.out.println("left:"+notPacked);
		return count+notPacked;
	}
}
