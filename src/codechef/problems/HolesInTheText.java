package codechef.problems;

import java.util.Scanner;

public class HolesInTheText {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	final String oneHole="ADOPRQ";
	int testCases=in.nextInt();
	for(int t=1;t<=testCases;t++){
		String text=in.next();
		int count=0;
		for(char c:text.toCharArray()){
			if(oneHole.contains(c+"")){
				count++;
			}else if(c=='B'){
				count+=2;
			}
		}
		System.out.println(count);
	}
}
}
