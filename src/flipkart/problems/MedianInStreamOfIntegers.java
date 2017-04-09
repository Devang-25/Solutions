package flipkart.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianInStreamOfIntegers {

	public static void main(String args[]) {
		Integer arr[] = new Integer[] { 2, 5, 12, 3, 34, 22, 54 };
		List<Integer> list = Arrays.asList(arr);
		process(list.iterator());
	}

	private static void process(Iterator<Integer> iterator) {
		PriorityQueue<Integer> l=new PriorityQueue<Integer>(100,Collections.reverseOrder());
		PriorityQueue<Integer> r=new PriorityQueue<Integer>();
		double medianSoFar=0;
		while(iterator.hasNext()){
			int n=iterator.next();
			if(l.size()>r.size()){
				if(n<medianSoFar){
					r.add(l.poll());
					l.add(n);
				}else{
					r.add(n);
				}
				medianSoFar=((double)l.peek()+r.peek())/2;
			}else if(l.size()<r.size()){
				if(n>medianSoFar){
					l.add(r.poll());
					r.add(n);
				}else{
					l.add(n);
				}
				medianSoFar=((double)l.peek()+r.peek())/2;
			}else{
				//sizes are same.
				if(n<medianSoFar){
					l.add(n);
					medianSoFar=l.peek();
				}else{
					r.add(n);
					medianSoFar=r.peek();
				}
			}
			System.out.println(medianSoFar);
		}
		
	}
}