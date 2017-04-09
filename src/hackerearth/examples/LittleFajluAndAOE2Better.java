package hackerearth.examples;

import java.util.Scanner;

public class LittleFajluAndAOE2Better {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int food = in.nextInt();
			int gold = in.nextInt();
			int pSam = in.nextInt();
			int pPal = in.nextInt();
			int pChamp = in.nextInt();
			int lBad = in.nextInt();
			int max = Integer.MIN_VALUE;
			for (int samC = 0; samC * 100 <= food; samC++) {
				for (int palC = 0; samC * 100 + palC * 125 <= food
						&& palC * 50 <= gold; palC++) {
					for (int champC = 0; samC * 100 + palC * 125 + champC * 50 <= food
							&& palC * 50 + champC * 100 <= gold; champC++) {
						max = Math.max(max, samC * pSam + palC * pPal + champC
								* pChamp);
					}
				}
			}
			if(lBad>=max){
				System.out.println(-1);
			}else{
				System.out.println(max-lBad);
			}
		}

	}
}
