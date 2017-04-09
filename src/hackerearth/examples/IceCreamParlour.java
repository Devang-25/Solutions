package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class IceCreamParlour {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		for (int i = 1; i <= testcases; i++) {
			int sum = in.nextInt();
			int icecreams = in.nextInt();
			ArrayList<IceCream> list = new ArrayList<IceCream>();
			for (int ic = 0; ic < icecreams; ic++) {
				int cost = in.nextInt();
				if (cost < sum) {
					IceCream icecream = new IceCream();
					icecream.index = ic;
					icecream.cost = cost;
					list.add(icecream);
				}
			}
			Comparator<IceCream> comp= new Comparator<IceCream>() {

				public int compare(IceCream a, IceCream b) {
					if (a.cost < b.cost) {
						return -1;
					}
					if(a.cost==b.cost){
						return 0;
					}
					return 1;
				}
			};
			//System.out.println(list);
			Collections.sort(list,comp);
			for(int j=0;j<list.size();j++){
				IceCream left=new IceCream();
				left.cost=sum-list.get(j).cost;
				int returned=Collections.binarySearch(list,left, comp);
				System.out.println(returned);
				if(returned>=0 && returned!=j){
					if((list.get(j).index+1)<(list.get(returned).index+1)){
						System.out.println((list.get(j).index+1)+" "+(list.get(returned).index+1));
					}else{
						System.out.println((list.get(returned).index+1)+" "+(list.get(j).index+1));
					}
					break;
				}
			}
		}
	}

	static class IceCream {
		int index;
		int cost;
		@Override
		public String toString() {
			return index+";"+cost;
		}
	}
}
