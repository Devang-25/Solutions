package hackerearth.examples;

public class LittleStuartAndEviilHacker {
	static long cache[][];

	public static void main(String args[]) {
		cache=new long[10000+1][10000+1];
		for(int i=1;i<cache.length;i++){
			cache[i][0]=1;
			cache[i][cache.length-1]=1;
			cache[i][1]=i;
			cache[i][cache.length-1-1]=i;
		}
		System.out.println(C(400,100));
	}

	public static long C(int n, int i) {
		if (i == 0 || i == n) {
			return 1;
		}
		if (i == 1 || i == n - 1) {
			return i;
		}
		if (cache[n][i] != 0) {
			return cache[n][i];
		}
		if (cache[n - 1][i] != 0 && cache[n - 1][i - 1] != 0) {
			return cache[n][i];
		}
		int div = Math.max(i, n - i);
		int t = n - div;
		System.out.println(div + ";" + t);
		long mul = 1;
		for (int j = div + 1; j <= n; j++) {
			mul *= j;
			mul = mul % ((long) (Math.pow(10, 9) + 7));
		}
		long deno = 1;
		for (int k = 1; k <= t; k++) {
			deno *= k;
			deno = deno % ((long) (Math.pow(10, 9) + 7));
		}
		long val = mul / deno;
		cache[n][i] = cache[n][n - i] = val;
		if (cache[n - 1][i] != 0 && cache[n - 1][i - 1] == 0) {
			cache[n - 1][i - 1] = val - cache[n - 1][i];
		} else if (cache[n - 1][i - 1] == 0 && cache[n - 1][i] == 0) {
			cache[n - 1][i] = val - cache[n - 1][i - 1];
		}
		return val;
	}

}
