package hackerearth.examples;


public class DigitCount {
	public static void main(String args[]) {
		//C(7, 5);
		  long count = 0;
		for (int d = 11; d <= 11; d++) {
			int n = d;
			for (int i = 1; i < n; i++) {
				long power =  (long) Math.pow(9, n - i - 1);
				System.out.println("power:" + power);
				long c = C(n, i) * i * power * 9 - power * C(n - 1, n - i - 1)
						* i;
				System.out.println("c:" + c);
				count += c;
			}
			System.out.println(C(n, n) * n);
			count += C(n, n) * n;
			System.out.println(count);
		}
		System.out.println((count>=Long.MAX_VALUE-1?"too big":count+" "));
	}
	
	private static int C(int n, int i) {
		if (n == i || i == 0) {
			System.out.println("C(" + n + "," + i + ")=1");
			return 1;
		}
		if (i == 1|| i==n-1) {
			System.out.println("C(" + n + "," + i + ")=" + n);
			return n;
		}
		
		int c=fact(n)/(fact(i)*fact(n-i));
		System.out.println(c);
		return c;
	}
	
	private static int fact(int n){
		int fact = 1;
		for (int s = 1; s <= n; s++) {
			fact *= s;
		}
		return fact;
	}

}
