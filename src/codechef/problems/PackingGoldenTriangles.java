package codechef.problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class PackingGoldenTriangles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = 20;//in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int boxes=(int)(Math.random()*1000);//in.nextInt();
			ArrayList<Long> list=new ArrayList<Long>();
			for(int i=0;i<boxes;i++){
				list.add((long)(Math.random()*10000000)+1);
			}
			int rubbers=(int)(Math.random()*1000);
			Long rubL[]=new Long[rubbers];
			Long rubU[]=new Long[rubbers];
			for(int i=0;i<rubbers;i++){
				rubL[i]=(long)(Math.random()*(10000000-1))+1;
				rubU[i]=rubL[i]+(long)(Math.random()*(10000000-rubL[i]))+1;
			}
			int alloc=process(boxes, rubbers, list, rubL, rubU);
			try {
				int alloc2=new PackingTheGoldenTriangleTester().task(boxes, rubbers, list, rubL, rubU);
				if(alloc2!=alloc){
					System.out.println(alloc2+";"+alloc);
					System.out.println("horror..");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	static int process(int N,int M,  List<Long> boxz, Long rubL[], Long rubU[]){
		int boxes = N;
		ArrayList<Long>list=new ArrayList<Long>(boxes);
		for (int b = 0; b < boxes; b++) {
			list.add(boxz.get(b) * 4*7);
		}
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		int rubberBands = M;
		TreeMap<Long, TreeMap<Long, Integer>> table = new TreeMap<Long, TreeMap<Long, Integer>>();
		for (int r = 0; r < rubberBands; r++) {
			long circumL = rubL[r] * 44;
			long circumU = rubU[r] * 44;
			if (table.containsKey(circumL)) {
				TreeMap<Long, Integer> uppers = table.get(circumL);
				if (uppers.containsKey(circumU)) {
					uppers.put(circumU, uppers.get(circumU) + 1);
				}else{
					uppers.put(circumU, 1);
				}
			} else {
				TreeMap<Long, Integer> uppers = new TreeMap<Long, Integer>();
				uppers.put(circumU, 1);
				table.put(circumL, uppers);
			}
		}
		System.out.println(table);
		int alloc=0;
		for(long box:list){
			System.out.println("Matching "+box);
			Entry<Long, TreeMap<Long, Integer>> entry=table.lowerEntry(box);
			System.out.println(entry);
			if(entry!=null){
				TreeMap<Long, Integer> val=entry.getValue();
				Entry<Long, Integer> entry2=val.ceilingEntry(box);
				//System.out.println(entry2);
				if(entry2!=null){
					/*if(entry2.getValue()>1){
						val.put(box, entry2.getValue()-1);
					}else{
						val.remove(box);
					}*/
					table.remove(box);
					alloc++;
				}
			}
		}
		return alloc;
	}
}
