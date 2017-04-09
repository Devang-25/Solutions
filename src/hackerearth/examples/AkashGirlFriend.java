package hackerearth.examples;

import java.util.Scanner;

public class AkashGirlFriend {
	public static void main(String[] args) {
		long[][] binomialCofficientsTable = new long[19][19];
		for (int i = 18; i > 0; i--) {
			int max = i % 2 == 0 ? i - 1 : i;
			for (int j = 1; j <= max; j += 2) {
				binomialCofficientsTable[i][j] = combinations(i, j);
			}
		}
		for (int i = 18; i > 0; i--) {
			int max = i % 2 == 0 ? i - 1 : i;
			for (int j = 1; j <= max; j += 2) {
				System.out.println("combination("+i+","+j+")"+binomialCofficientsTable[i][j]);
			}
		}
		long [] nineCache=new long[19];
		nineCache[0]=1;
		long nine=1;
		for(int i=1;i<=18;i++){
			nineCache[i]=nine*9;
			System.out.println(nineCache[i]);
			nine=nine*9;
			//nine=nine%1000000009;
		}
		Scanner in =new Scanner(System.in);
		StringBuilder b=new StringBuilder();
		int cases=in.nextInt();
		for(int j=1;j<=cases;j++){
			//cache has been built till this point.
			int n=in.nextInt();
			int max = n % 2 == 0 ? n - 1 : n;
			long sum=0;
			for(int i=1;i<=max;i+=2){
				long mul=binomialCofficientsTable[n][i]*nineCache[n-i];
				System.out.println(mul);
				sum+=mul;
				sum=sum%1000000009;
			}
			b.append(sum);
			if(j!=cases){
				b.append("\n");
			}
		}
		System.out.println(b.toString());
		
	}

	static long combinations(int n, int k) {
		long coeff = 1;
		for (int i = n - k + 1; i <= n; i++) {
			coeff *= i;
			//coeff=coeff%1000000009;
		}
		for (int i = 1; i <= k; i++) {
			coeff /= i;
		}
		return coeff;
	}
}
