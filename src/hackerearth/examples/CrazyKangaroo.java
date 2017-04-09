package hackerearth.examples;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CrazyKangaroo {
public static void main(String[] args) throws FileNotFoundException {
	Scanner in =new Scanner(new BufferedInputStream(System.in));
	//Scanner fIn =new Scanner(new File("/Users/gopimac/Documents/output.txt"));
	int testCases=in.nextInt();
	StringBuilder builder=new StringBuilder();
	for(int t=1;t<=testCases;t++){
		long start=in.nextLong();
		long end=in.nextLong();
		long M=in.nextLong();
		long ans=(end/M)-((start-1)/M);
		/*long exp=fIn.nextLong();
		if(exp!=ans){
			System.out.println("Failed for "+start+"-"+end+"-"+M);
			System.out.println(exp+":"+ans);
		}*/
		builder.append(ans);
		builder.append("\n");
	}
	System.out.println(builder.toString());
}
}
