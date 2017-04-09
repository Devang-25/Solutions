/**
 * 
 */
package hackerrank;

import java.util.Scanner;

/**
 * @author makkg
 *
 */
public class SubstringDiffEditorial {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int s = in.nextInt();
			char[] a = in.next().toCharArray();
			char b[] = in.next().toCharArray();
			int L = a.length;
			int diff[][] = new int[L][L];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < L; j++) {
					diff[i][j] = a[i] == b[j] ? 0 : 1;
				}
			}
			int maxL=Integer.MIN_VALUE;
			for(int i=0;i<L;i++){
				int sumAB=0;int sumBA=0;
				int skippedSumAB=0;int skippedSumBA=0;
				int bAB=-1;
				int bBA=-1;
				for(int j=0;j+i<L;j++){
					sumAB+=diff[j][j+i];
					sumBA+=diff[j+i][j];
					while(sumAB-skippedSumAB>s){
						bAB++;
						skippedSumAB+=diff[bAB][bAB+i];
					}
					
					while(sumBA-skippedSumBA>s){
						bBA++;
						skippedSumBA+=diff[bBA+i][bBA];
					}
					
					if(j-bAB>maxL){
						maxL=j-bAB;
					}
					if(j-bBA>maxL){
						maxL=j-bBA;
					}
				}
			}
			System.out.println(maxL);
		}
	}
}
