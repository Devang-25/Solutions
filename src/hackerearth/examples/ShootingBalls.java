package hackerearth.examples;

import java.math.BigInteger;
import java.util.Scanner;

public class ShootingBalls {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	int testCases=in.nextInt();
	for(int t=1;t<=testCases;t++){
		long shotA=in.nextLong();
		long shotB=in.nextLong();
		BigInteger balls=new BigInteger(shotA+"");
		balls=balls.add(new BigInteger(shotB+""));
		balls=balls.subtract(new BigInteger("1"));
		System.out.print(balls.subtract(new BigInteger(""+shotA)));
		System.out.print(" "+balls.subtract(new BigInteger(""+shotB)));
		System.out.println();
	}
}
}
