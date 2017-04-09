package codechef.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HealthDinnerPartySomebody{
 
	public String findIngredients(int[] proteinContents, String ingredients,int proteinReq){
		int n = ingredients.length();
 
		int[][] table = new int[n][proteinReq+1];
 
		java.util.LinkedList[] freq = new  java.util.LinkedList[26];
 
		
		for(int i = 0; i < n ; i++){
			int index = (int)ingredients.charAt(i) - (int)'a';
			if(freq[index] == null)
				freq[index] = new java.util.LinkedList();
			freq[index].add(new Integer(i));
		}
 
	
		int index = (int)ingredients.charAt(n-1) - (int)'a';
		for(int k = 0; k <= proteinReq; k++){
			if(proteinContents[index] == k)
				table[n-1][k] = 1; 
			else if(k == 0)
				table[n-1][k] = 0;
			else
				table[n-1][k] = -1;
		}
		for(int i = 0; i <= n-2; i++)
			for(int k = 0; k <= proteinReq; k++)
				table[i][k] = -1;
 
		for(int i = n-2; i >= 0; i--){
			for(int j = 0; j <= proteinReq; j++){
				if(table[i+1][j] == 0 || table[i+1][j] == 1)
					table[i][j] =	0;
			}
			for(int j = 0; j <= proteinReq; j++){	
				if(table[i+1][j] == 0 || table[i+1][j] == 1){	
					index = (int)ingredients.charAt(i)-(int)'a';
					if(j+proteinContents[index] <= proteinReq)
						table[i][j+proteinContents[index]] = 1;
				}
			}
		}
 
		
		int stillRequired = proteinReq;	
		int lastIndex = -1;	
		StringBuilder sequence = new StringBuilder();
		while(stillRequired > 0){
			
			boolean found = false;
			for(int i = 0; i < 26 ; i++){
				if(freq[i] == null)
					continue;	
 
				java.util.Iterator occurencesIter = freq[i].iterator();
				while(occurencesIter.hasNext()){
					int nextIndex = ((Integer)(occurencesIter.next())).intValue();
					if(nextIndex <= lastIndex)	//useless
						occurencesIter.remove();
					else{
						if(table[nextIndex][stillRequired] == 1){	//good
							found = true;
							stillRequired -= proteinContents[i];
							lastIndex = nextIndex;
							sequence.append((char)(i+(int)'a'));
							break;
						}
						else if(table[nextIndex][stillRequired] == -1)
							break;
					}
				}
				if(found)
					break;
			}
			if(!found)
				return new String("IMPOSSIBLE");
		}
	
		return new String(sequence);
	}
	
       public static void main(String[] args)throws IOException{
	       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       int numberOfTestCases = Integer.parseInt(br.readLine());
	       for(int i = 0; i < numberOfTestCases; i++){
		       int[] proteinContents = new int[26];
		       String ingredients;
		       int requirement;
		       String[] proteinData = br.readLine().split(" ");
		       for(int j = 1; j < proteinData.length; j++)
			       if(proteinData[j].length() > 0)
				       proteinContents[j-1] = Integer.parseInt(proteinData[j]);
		       ingredients = br.readLine();
		       requirement = Integer.parseInt(br.readLine());
		       HealthDinnerPartySomebody ingredientFinder = new HealthDinnerPartySomebody();
		       System.out.println(ingredientFinder.findIngredients(proteinContents,ingredients,requirement));
	       }
       }				
}
 

