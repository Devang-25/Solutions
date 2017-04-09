package test2;

import java.util.ArrayList;
import java.util.Scanner;

public class Numbers {
public static void main(String[] args) {
	Scanner in =new Scanner(System.in);
	String str=in.nextLine();
	Integer arr[]=process(str);
	for(int no:arr){
		System.out.println(no);
	}
	
}

private static Integer[] process(String str) {
	str=str+".";
	ArrayList<Integer> arr=new ArrayList<Integer>();
	String no="";
	for(char c:str.toCharArray()){
		if(c>=48 && c<=57){
			no+=c;
		}else{
			if(!no.equals("")){
				arr.add(Integer.parseInt(no));
			}
			no="";
		}
	}
	return arr.toArray(new Integer[arr.size()]);
}
}
