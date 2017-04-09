package hackerearth.examples;

import java.util.Arrays;
import java.util.Scanner;

public class SunnyArpitKunal {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	int testCases=in.nextInt();
	int pos[]=new int[3];
	for (int i = 0; i < testCases; i++) {
		
		pos[0]=in.nextInt();
		pos[1]=in.nextInt();
		pos[2]=in.nextInt();
		Arrays.sort(pos);
		System.out.println(Math.max(pos[1]-pos[0]-1, pos[2]-pos[1]-1));
	}
}
}
