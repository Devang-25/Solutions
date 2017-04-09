package codechef.problems;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StableMarriageProblemIncorrect {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		PrintStream s=new PrintStream(new BufferedOutputStream(System.out));
		System.setOut(s);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int people = in.nextInt();
			int womenpref[][] = new int[people + 1][people + 1];
			for (int i = 1; i <= people; i++) {
				int womenId = in.nextInt();
				for (int j = 1; j <= people; j++) {
					int manId = in.nextInt();
					//preference of the woman for manId is j th
					womenpref[womenId][manId] = j;
				}
			}
			int menpref[][] = new int[people + 1][people + 1];
			for (int i = 1; i <= people; i++) {
				int menId = in.nextInt();
				for (int j = 1; j <= people; j++) {
					int womanId = in.nextInt();
					//man's j th preference id this woman with womanId
					menpref[menId][j] = womanId;
				}
			}
			int men[] = new int[people + 1];
			int women[] = new int[people + 1];
			while (true) {
				int thisMan = 0;
				//find a man that has not yet been allocated a woman.
				for (int j = 1; j <= people; j++) {
					if (men[j] == 0) {
						thisMan = j;
						break;
					}
				}
				//every man has been allocated, so quit.
				if (thisMan == 0)
					break;
				else {
					int i = 1;
					while (i <= people) {
						int thisWoman=menpref[thisMan][i];
						int manAllocated=women[thisWoman];
						if (women[thisWoman] == 0) {
							//this woman is available.
							women[thisWoman] = thisMan;//allocate this man.
							men[thisMan] = thisWoman;//allocate this woman.
							break;
						} else if (womenpref[thisWoman][manAllocated] > womenpref[thisWoman][thisMan]) {
							//we would like to pair this couple 
							/* thisMan's ith preference , this woman was already allocated a man, but this woman likes thisMan more.
							 * i.e more pref, we deallocate that man and allocate this woman. and vica versa. 
							 * */
							men[manAllocated] = 0;//unallocate.
							women[thisWoman] = thisMan;//allocate this man.
							men[thisMan] = thisWoman;//allocate this woman.
							break;
						} else
							i++;
					}
				}
			}
			for (int j = 1; j <= people; j++)
				s.println(j + " " + men[j]);
		}
		s.flush();
	}
}