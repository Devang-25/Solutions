package hackerearth.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OldKeyBoardProblem {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int alphabets=in.nextInt();
		Integer frequencies[]=new Integer[alphabets];
		for(int i=0;i<frequencies.length;i++){
			frequencies[i]=in.nextInt();
		}
		int keys=in.nextInt();
		int keySize[]=new int[keys];
		int usedUp[]=new int[keys];
		int tSize=0;
		for(int i=0;i<keys;i++){
			keySize[i]=in.nextInt();
			tSize+=keySize[i];
		}
		if(alphabets>tSize){
			System.out.println(-1);
			return ;
		}
		List<Integer> freqL=new ArrayList<Integer>(Arrays.asList(frequencies));
		Collections.sort(freqL);
		Collections.reverse(freqL);
		//System.out.println(freqL);
		int k=0;
		int strokes=0;
		for(int i=0;i<freqL.size();i++){
			if(usedUp[k]!=keySize[k]){
				usedUp[k]++;
				strokes+=usedUp[k]*freqL.get(i);
			}
			k++;
			if(k==keys){
				k=0;
			}
		}
		System.out.println(strokes);
	}
}


