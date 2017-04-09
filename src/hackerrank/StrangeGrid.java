package hackerrank;

import java.util.Scanner;

public class StrangeGrid {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	long r=in.nextLong()-1;
	int c=in.nextInt();
	long first=10*(r/2);
	if(r%2==1){
		first=first+1;
	}
	System.out.println(first+(c-1)*2);
}
}
