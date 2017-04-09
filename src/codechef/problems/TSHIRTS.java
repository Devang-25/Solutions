package codechef.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class TSHIRTS {
	
	private static long  choices=0;
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCases = Integer.parseInt(in.readLine());
			for (int t = 1; t <= testCases; t++) {
				int shirtT[][] = new int[101][10];
				int persons = /*(int)(Math.random()*10);*/Integer.parseInt(in.readLine());
				int personOptions[][] = new int[persons][101];
				int totalOptions[] = new int[persons];
				for (int i = 0; i < persons; i++) {
					String tShirts[] = /*genRandom();*/in.readLine().split(" ");
					totalOptions[i] = tShirts.length;
					for (String tS : tShirts) {
						int shirtId = Integer.parseInt(tS);
						shirtT[shirtId][shirtT[shirtId][0] + 1] = i;
						shirtT[shirtId][0]++;
						personOptions[i][personOptions[i][0]+1] = shirtId;
						personOptions[i][0]++;
					}
				}
				boolean used[]=new boolean[101];
				choose(personOptions, 0, used);
				System.out.println(choices);
				choices=0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String[] genRandom() {
		int times=(int)(Math.random()*100);
		TreeSet<String> set=new TreeSet<>();
		for(int i=1;i<=times;i++){
			set.add(((int)(Math.random()*100)+1)+"");
		}
		return set.toArray(new String[set.size()]);
	}

	//this is brute force..
	//shudn't work for big input.
	private static void choose(int[][] personOptions, int i, boolean used[]) {
		if(i==personOptions.length){
			choices++;
			return ;
		}
		//System.out.println("Person "+i);
		for(int sh=1;sh<=personOptions[i][0];sh++){
			//System.out.println("Color :"+personOptions[i][sh]);
			if(!used[personOptions[i][sh]]){
				used[personOptions[i][sh]]=true;
				choose(personOptions, i+1, used);
				used[personOptions[i][sh]]=false;
			}
		}
		
	}
}
