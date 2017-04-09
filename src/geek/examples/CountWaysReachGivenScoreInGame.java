package geek.examples;

public class CountWaysReachGivenScoreInGame {
public static void main(String[] args) {
	int c=count(20);
	System.out.println(c);
}

private static int count(int n){
	int table[]=new int[n+1];
	int coins[]=new int[]{3,5,10};
	table[0]=1;
	for(int c:coins){
		for(int i=c;i<table.length;i++){
			table[i]+=table[i-c];
		}
	}
	return table[n];
}
}
