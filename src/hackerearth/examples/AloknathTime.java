package hackerearth.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AloknathTime {
	
	static class PlayerComparator implements Comparator<Player>{
		@Override
		public int compare(Player p1, Player p2) {
			if(p1.score>p2.score){
				return 1;
			}
			return -1;
		}
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int noOfPlayers = in.nextInt();
		ArrayList<Player> pL = new ArrayList<Player>();
		for (int i = 1; i <= noOfPlayers; i++) {
			pL.add(new Player(in.nextInt() == 1 ? false : true, in.nextInt()));
		}
		ArrayList<Player> pLCopy=new ArrayList<Player>(pL);
		Collections.sort(pL,new PlayerComparator());
		System.out.println(pL);
		double x=100/(Math.pow(2,noOfPlayers)-1);
		System.out.println(x);
		for(Player p:pL){
			p.amount=(int) x;
			x=x*2;
		}
		for(Player p:pLCopy){
			System.out.println(p.amount);
		}
	}

	static class Player {
		Player(boolean bareFeet, int sc) {
			this.score=sc;
			if (bareFeet) {
				score += ((20 * score) / 100);
			} else {
				score -= ((10 * score) / 100);
			}
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.score+" ";
		}

		int score;
		int amount;
	}

}
