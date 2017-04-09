package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PromNight {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	int testCases=in.nextInt();
	for(int t=1;t<=testCases;t++){
		int b=in.nextInt();
		int g=in.nextInt();
		ArrayList<Integer> boys=new ArrayList<Integer>(b);
		ArrayList<Integer> girls=new ArrayList<Integer>(g);
		for(int i=0;i<b;i++){
			boys.add(in.nextInt());
		}
		for(int i=0;i<g;i++){
			girls.add(in.nextInt());
		}
		if(b<=g){
			Collections.sort(boys, Collections.reverseOrder());
			Collections.sort(girls, Collections.reverseOrder());
			int i=0;
			int j=0;
			while(i<b && b-i <=g-j){
				if(girls.get(j)<boys.get(i)){
					i++;
				}
				j++;
			}
			if(i==b){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}else{
			System.out.println("NO");
		}
	}
}
}
