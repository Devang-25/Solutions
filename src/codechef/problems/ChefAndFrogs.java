package codechef.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ChefAndFrogs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int frogCount = in.nextInt();
		int distance = in.nextInt();
		int pairs = in.nextInt();
		ArrayList<Frog> frogs = new ArrayList<Frog>();
		for (int f = 0; f < frogCount; f++) {
			Frog frog = new Frog();
			frog.index = f;
			frog.pos = in.nextInt();
			frogs.add(frog);
		}
		Collections.sort(frogs, new FrogComparator());
		int[] frogRepTable = new int[100001];
		int repId = 0;
		frogRepTable[frogs.get(0).index]= repId;
		int lastFrogPos = frogs.get(0).pos;
		for (int i = 1; i < frogs.size(); i++) {
			int posFrogI = frogs.get(i).pos;
			if (posFrogI - lastFrogPos > distance) {
				repId++;
			}
			frogRepTable[frogs.get(i).index]= repId;
			lastFrogPos = posFrogI;
		}
		for (int pair = 0; pair < pairs; pair++) {
			int frog1 = in.nextInt()-1;
			int frog2 = in.nextInt()-1;
			if(frogRepTable[frog1]==frogRepTable[frog2]){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}

		}

	}

	static class FrogComparator implements Comparator<Frog> {

		@Override
		public int compare(Frog frog1, Frog frog2) {
			if (frog1.pos < frog2.pos) {
				return -1;
			}
			return 1;
		}

	}

	static class Frog {
		int index;
		int pos;
		
		public String toString() {
			return "A"+(index+1)+" "+pos;
		}
	}
}
