package hackerearth.examples;

import java.util.Scanner;

public class EasyIPhone {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int X=in.nextInt();
		int Y=in.nextInt();
		int iPhones=X;
		while(X>=Y){
			int newIPhones=X/Y;
			iPhones+=newIPhones;
			X=X%Y+newIPhones;
		}
		System.out.println(iPhones);
	}
}
