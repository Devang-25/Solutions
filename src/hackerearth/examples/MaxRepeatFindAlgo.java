package hackerearth.examples;

import java.util.HashMap;

/*Given array of N integers ranging from 0 to N-1. 
 * Output maximum repeating integer. 
 * */
public class MaxRepeatFindAlgo {
	private HashMap<Integer, Integer> map;

	public MaxRepeatFindAlgo(int max) {
		map = new HashMap<Integer, Integer>();
	}

	public int[] getMaxFrequency(int array[]) {
		for (int n : array) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}
		int max = -1;
		int no = -1;
		for (int n : map.keySet()) {
			if (map.get(n) > max) {
				max = map.get(n);
				no = n;
			}
		}
		return new int[] { no, max };
	}
	
	public static void main(String args[]){
		MaxRepeatFindAlgo algo=new MaxRepeatFindAlgo(18);
		int array[]={7,1,3,2,6,17,14,2,1,3,3,7,2,3,3,2,2,2,2};
		int val[]=algo.getMaxFrequency(array);
		System.out.println(val[0]+":"+val[1]);
	}

}
