package hackerearth.examples;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Boxes {
	public static void main(String args[]) {
		Scanner in =new Scanner(System.in);
		int testCases=in.nextInt();
		//System.out.println(testCases);
		in.nextLine();
		for (int i=1;i<=testCases;i++) {
			String line=in.nextLine();
			//System.out.println(line);
			String boxesS[]=line.split(" ");
			//System.out.println(Arrays.asList(boxesS));
			LinkedList<Integer> list = new LinkedList<Integer>();
			for(String b:boxesS){
				list.add(Integer.parseInt(b));
			}
			process(list);
		}
		
	}
	
	static private void process(LinkedList<Integer> list){
		Collections.sort(list);
		Collections.reverse(list);
		//System.out.println(list);
		int noOBoxes = 0;
		while (!list.isEmpty()) {
			int boxW = list.removeFirst();
			//System.out.println(boxW+" goes ");
			if(list.isEmpty()){
				noOBoxes++;
				break;
			}
			if (boxW >= 101 && boxW <= 199) {
				//look for the first largest no. that can be removed.
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j) <= 300 - boxW) {
						//System.out.println(list.get(j)+" goes too.");
						list.remove(j);
						break;
					}
				}
			}
			noOBoxes++;
			//System.out.println(noOBoxes);
		}
		System.out.println(noOBoxes);
	}
}
