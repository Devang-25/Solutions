package hackerearth.examples;

public class SumFibonacciEven {
	public static void main(String[] args) {
		long sum=0;
		long first=1;
		long second=2;
		while(first<=4000000){
			long next=first+second;
			System.out.println(next);
			if(next%2==0){
				System.out.println(next+" added");
				sum+=next;
			}
			first=second;
			second=next;
		}
		System.out.println(sum);
	}
}
