package hackerearth.examples;

import java.util.Scanner;

public class AirTraffic {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		for(int i=1;i<=testCases;i++){
			int pV1[] =getVector(in);
			int sV1[] = getVector(in);
			int pV2[] = getVector(in);
			int sV2[] = getVector(in);
			// of the quadratic equation Ax^2 +Bx+C, we want to find A,B,C
			int thres=in.nextInt();
			//System.out.println("Thres:"+thres);
			int a = pV1[0] - pV2[0];
			int c = pV1[1] - pV2[1];
			int e = pV1[2] - pV2[2];
			int b = sV1[0] - sV2[0];
			int d = sV1[1] - sV2[1];
			int f = sV1[2] - sV2[2];
			long A = b * b + d * d + f * f;
			long B = 2 * a * b + 2 * c * d + 2 * e * f;
			long C = a * a + c * c + e * e -thres*thres;
			double root = Math.sqrt(B * B - 4 * A * C);
			//System.out.println("root :"+root);
			double t = (-1 * B + root) / (2 * A);
			//System.out.println(t);
			if (t > 0) {
				System.out.println("YES");
			} else {
				t = (-1 * B - root) / (2 * A);
				if (t > 0) {
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}
		
		

	}
	
	private static int[] getVector(Scanner in){
		int vector[]=new int[3];
		for(int i=0;i<vector.length;i++){
			vector[i]=in.nextInt();
		}
		return vector;
	}
}
