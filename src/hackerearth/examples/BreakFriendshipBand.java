package hackerearth.examples;

import java.util.Scanner;

public class BreakFriendshipBand {
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int len=in.nextInt();
		String str=in.next();
		char  beads[]=str.toCharArray();
		int count = 0;
		Character color = null;
		int i = 0;
		Character otherColor = null;
		while (i != beads.length) {
			if (beads[i] == 'w' || (color != null && beads[i] == color)) {
				count++;
			} else if (color == null) {
				count++;
				color = beads[i];
			} else {
				otherColor = beads[i];
				break;
			}
			i++;
		}
		int j = beads.length - 1;
		while (j != -1) {
			if (beads[j] == 'w' || beads[j] == color) {
				count++;
			} else {
				break;
			}
			j--;
		}
		int fCount = count;
		int thisCount = 0;
		int max = Integer.MIN_VALUE;
		int wCount=0;
		int prevwCount=0;
		while (i <= j) {
			if (beads[i] == otherColor) {
				thisCount++;
				wCount=0;
			} else if (beads[i] == 'w') {
				thisCount++;
				wCount++;
			} else {
				System.out.println(thisCount);
				Character temp = otherColor;
				otherColor = color;
				color = temp;
				if (count + thisCount-prevwCount > max) {
					max = count + thisCount-prevwCount;
				}
				count = thisCount;
				thisCount = 1+wCount;
				prevwCount=wCount;
				wCount=0;
			}
			i++;
		}
		System.out.println(thisCount);
		if (thisCount + fCount > max) {
			max = thisCount + fCount;
		}
		System.out.println(max);

	}
}
