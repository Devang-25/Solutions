package hackerearth.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MonkInTheLandOfPokemons {
public static void main(String[] args) {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner in = new Scanner(br);
	int testCases = in.nextInt();
	for (int t = 0; t < testCases; t++) {
		int N=in.nextInt();
		int foodTable[]=new int[1000000];
		int foodRequired=0;
		for(int i=1;i<=N;i++){
			int food=in.nextInt();
			int pokemon=in.nextInt();
			if(food!=pokemon){
				if(foodTable[pokemon]>0){
					foodTable[pokemon]--;
				}else{
					foodRequired++;
				}
				foodTable[food]++;
			}
		}
		System.out.println(foodRequired);
	}
}
}
