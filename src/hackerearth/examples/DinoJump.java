package hackerearth.examples;

import java.util.Scanner;

public class DinoJump {
public static void main(String args[]){
	Scanner in =new Scanner(System.in);
	long a=in.nextLong();
	long b=in.nextLong();
	long c=in.nextLong();
	System.out.println(Math.max(Math.abs(a-b), Math.abs(b-c))-1);
	
}
}
