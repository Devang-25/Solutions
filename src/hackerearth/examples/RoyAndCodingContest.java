package hackerearth.examples;

import java.util.Scanner;

public class RoyAndCodingContest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++) {
			long maxPCs = in.nextLong();
			if(maxPCs==1){
				System.out.println(0);
				continue;
			}
			long maxPendrives = in.nextLong();
			int readyPCs = 1;
			int readyPenDrives = 1;
			int time = 1;
			while (readyPenDrives < maxPendrives && readyPCs<maxPCs) {
				int prevReadyDrives=readyPenDrives;
				readyPenDrives += Math.min(readyPCs, maxPendrives
						- readyPenDrives);
				readyPCs += prevReadyDrives;
				time++;
				System.out.println(time + "\t" + readyPCs + "\t"
						+ readyPenDrives);

			}if(readyPCs>maxPCs){
				System.out.println(time);
			}else{
			time += Math.ceil((double)(maxPCs - readyPCs) / maxPendrives);
			System.out.println(time);
			}
		}
	}
}
