package geek.examples;

import java.util.TreeSet;

public class Permutation {
public static void main(String[] args) {
	String str="bcdaae";
	permutate(str);
}


private static void permutate(String str) {
	TreeSet<Character> set=new TreeSet<Character>();
	for(char c:str.toCharArray()){
		set.add(c);
	}
	permutate("",set);
	System.out.println(count);
}
private static int count=0;
private static void permutate(String str, TreeSet<Character> set) {
	if(set.isEmpty()){
		count++;
		System.out.println(str);
	}
	Character arr[]=set.toArray(new Character[set.size()]);
	for(char c:arr){
		set.remove(c);
		permutate(str+c,set);
		set.add(c);
	}
}
}
