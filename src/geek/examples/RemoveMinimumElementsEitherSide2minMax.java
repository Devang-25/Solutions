package geek.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class RemoveMinimumElementsEitherSide2minMax {
	static int cache[][] = new int[1000][1000];
	static TreeSet<Integer> sortTable = new TreeSet<>();
	static Map<Integer, Integer> countTable = new HashMap<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int elements=in.nextInt();
		int arr[]=new int[elements];
		for(int i=0;i<elements;i++){
			arr[i]=in.nextInt();
			if(sortTable.contains(arr[i])){
				countTable.put(arr[i], countTable.get(arr[i])+1);
			}else{
				sortTable.add(arr[i]);
				countTable.put(arr[i], 1);
			}
		}
		System.out.println(process(arr, 0, arr.length-1));

	}

	private static int process(int arr[],int i, int j) {
		System.out.println("Process("+i+","+j+")");
		if(i==j){
			return Integer.MAX_VALUE;
		}
		if (cache[i][j] != 0) {
			return cache[i][j];
		}
		if(2*sortTable.first()<=sortTable.last()){
			int c1=1+reCallProcess(arr, arr[i], i+1, j);
			int c2=1+reCallProcess(arr, arr[j], i, j-1);
			cache[i][j]=c1>c2?c2:c1;
			return cache[i][j];
		}else{
			return 0;
		}
	}
	
	private static int reCallProcess(int arr[], int ithArr, int i, int j){
		System.out.println("Remove "+ithArr);
		if(countTable.get(ithArr)>1){
			countTable.put(ithArr, countTable.get(ithArr)-1);
		}else{
			sortTable.remove(ithArr);
		}
		
		int c1=process(arr, i,j);
		if(sortTable.contains(ithArr)){
			countTable.put(ithArr, countTable.get(ithArr)+1);
		}else{
			sortTable.add(ithArr);
		}
		System.out.println("Added "+ithArr);
		return c1;
	}
}
