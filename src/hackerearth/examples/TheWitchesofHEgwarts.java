package hackerearth.examples;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
//this code is correct..but is not scalable.
public class TheWitchesofHEgwarts {
	private static Map<Long, Long> cache=new TreeMap<Long, Long>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			long no = in.nextLong();
			System.out.println(magicHits(no));
		}
	}
	
	private static long magicHits(long no) {
		if(no==1){
			return 0;
		}
		Long val=cache.get(no);
		if(val!=null){
			return val;
		}
		long by2=Long.MAX_VALUE;
		long by3=Long.MAX_VALUE;
		long minus1=Long.MAX_VALUE;
		if(no%3==0){
			System.out.println(3+"=>"+no/3);
			by3=1+magicHits(no/3);
			cache.put(no, by3);
		}
		if(no%2==0){
			System.out.println(2+"=>"+no/2);
			by2=1+magicHits(no/2);
		}
		System.out.println(-1+"=>"+(no-1));
		minus1=1+magicHits(no-1);//stack overflow exception comes here..
		long min=Math.min(by3, by2);
		min= Math.min(minus1, min);
		cache.put(no, min);
		return min;
	}
}
