package hackerrank;

import java.util.Scanner;

public class TwoStrings {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		for(int t=1;t<=testCases;t++){
			String a=in.next();
			String b=in.next();
			boolean [] tab=new boolean[26];
			char aC[]=a.toCharArray();
			char bC[]=b.toCharArray();
			boolean found=false;
			for(int i=0;i<aC.length;i++){
				tab[aC[i]-97]=true;
			}
			for(int i=0;i<bC.length;i++){
				if(tab[bC[i]-97]){
					found=true;
					break;
				}
			}
			if(found){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
