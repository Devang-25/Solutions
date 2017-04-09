package codechef.problems;

import java.util.Scanner;

public class CountSubstrings {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	int testCases=in.nextInt();
	for(int t=1;t<=testCases;t++){
		int n=in.nextInt();
		String binaryText=in.next();
		int ones=0;
		long subStrings=0;
		for(int i=0;i<n;i++){
			char thisChar=binaryText.charAt(i);
			if(thisChar=='1'){
				subStrings+=ones;
				ones++;
			}
		}
		subStrings+=ones;
		System.out.println(subStrings);
	}
}
}
