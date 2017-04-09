package hackerearth.examples;

import java.util.Scanner;

public class EquationSolver {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int testCases=in.nextInt();
	for(int i=1;i<=testCases;i++){
		int a=in.nextInt();
		int b=in.nextInt();
		int c=in.nextInt();
		double d=Math.sqrt(b*b-4*a*c);
		int root1=(int) Math.round((-1*b+d)/(2*a));
		int root2=(int) Math.round((-1*b-d)/(2*a));
		if(a<0){
			System.out.println(Math.min(root1, root2));
		}else{
			System.out.println(Math.max(root1, root2));
		}
		
	}
}
}
