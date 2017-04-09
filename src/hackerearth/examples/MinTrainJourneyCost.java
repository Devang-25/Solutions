package hackerearth.examples;

import java.util.Scanner;

public class MinTrainJourneyCost {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int testCases=in.nextInt();
		for(int i=1;i<=testCases;i++){
			String path = in.next();
			int minCost = getJourneyCost(path.toCharArray(), 0, 'A');
			if (minCost == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(minCost);
			}
		}
		
	}

	private static int getJourneyCost(char path[], int at, char station) {
		/*System.out.println("getJourneyCost("
				+ new String(path, at, path.length - at) + "," + at + ","
				+ station + ")");*/
		if (at == path.length - 1) {
			return 0;
		}
		char nextPoint = getNextStation(station);
		int min = Integer.MAX_VALUE;
		for (int i = at + 1; i < path.length; i++) {
			if (path[i] == nextPoint) {
				int distance = i - at;
				int costTillNow = distance * distance;
				//System.out.println("---" + costTillNow);
				int cost = getJourneyCost(path, i, nextPoint);
				if (cost != Integer.MAX_VALUE) {
					int totalCost = cost + costTillNow;
					//System.out.println(totalCost);
					if (totalCost < min) {
						min = totalCost;
					}
				}

			}
		}
		return min;
	}

	private static char getNextStation(char thisStation) {
		switch (thisStation) {
		case 'A':
			return 'B';
		case 'B':
			return 'C';
		case 'C':
			return 'A';
		}
		throw new IllegalStateException();
	}
}
