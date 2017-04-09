package test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Petrol {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> no = new ArrayList<Integer>();
		String line = in.readLine();
		String nostring[] = line.split(" ");
		for (String str : nostring) {
			no.add(Integer.parseInt(str));
		}
		Integer[] petrolPrice = no.toArray(new Integer[no.size()]);
		int max=Integer.MIN_VALUE;
		int dayStart=0;
		int dayEnd=0;
		for(int i=0;i<petrolPrice.length;i++){
			for(int j=i;j<petrolPrice.length;j++){
				int dif=petrolPrice[j]-petrolPrice[i];
				if(dif>0){
					if(max<dif){
						max=dif;
						dayStart=i;
						dayEnd=j;
					}
				}
			}
		}
		dayStart++;
		dayEnd++;
		System.out.println(dayStart + " " + petrolPrice[dayStart-1]);
		System.out.println(dayEnd + " " + petrolPrice[dayEnd-1]);

	}
}
