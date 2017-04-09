package hackerearth.examples;

public class RoyAndDNATest {
	public static void main(String args[]) {
		char[] parentDNA = "royeria".toCharArray();
		char[] childDNA = "km".toCharArray();
		int [] table=new int[26];
		for(int i=0;i<childDNA.length;i++){
			//System.out.println(childDNA[i]);
			int loc=((int)childDNA[i])-97;
			table[loc]++;
		}
		process(childDNA,parentDNA, table);
	}
	
	public static void process(char childDNA[],char [] parentDNA, int table[]){
		int count=0;
		for(int i=childDNA.length-1;i<=parentDNA.length-childDNA.length;i++){
			int loc=((int)parentDNA[i])-97;
			if(table[loc]!=-1){
				count+=table[loc];
			}
		}
		//System.out.println(count);
		for(int i=0;i<childDNA.length-1;i++){
			for(int j=0;j<=i;j++){
				//System.out.println(parentDNA[i]+"=="+childDNA[j] );
				if(parentDNA[i]==childDNA[j]){
					//System.out.println("match");
					count++;
				}
			}
		}
		
		for(int i=parentDNA.length-childDNA.length+1;i<parentDNA.length;i++){
			for(int j=i-childDNA.length;j<childDNA.length;j++){
				//System.out.println(parentDNA[i]+"=="+childDNA[j] );
				if(parentDNA[i]==childDNA[j]){
					//System.out.println("match2");
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
