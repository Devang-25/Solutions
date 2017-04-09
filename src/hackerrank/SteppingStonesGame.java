/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * @author makkg
 *
 */
public class SteppingStonesGame {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	int testCases=in.nextInt();
	for(int t=1;t<=testCases;t++){
		long N=in.nextLong();
		double sqrt=Math.sqrt(8*N+1);
		if((long)sqrt==sqrt){
			//answer is a number
			long steps=(long) ((-1+sqrt)/2);
			System.out.println("Go On Bob "+steps);
		}else{
			System.out.println("Better Luck Next Time");
		}
	}
	
}
}
