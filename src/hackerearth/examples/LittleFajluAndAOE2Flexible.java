package hackerearth.examples;

import java.util.Scanner;

public class LittleFajluAndAOE2Flexible {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int food = in.nextInt();
			int gold = in.nextInt();
			Soldier s=new Soldier();
			s.food=100;
			s.gold=0;
			s.power=in.nextInt();
			Soldier p=new Soldier();
			p.food=125;
			p.gold=50;
			p.power=in.nextInt();
			Soldier c=new Soldier();
			c.food=50;
			c.gold=100;
			c.power=in.nextInt();
			Soldier soldiers[] = new Soldier[]{s, p,c};
			int lBad = in.nextInt();
			max = Integer.MIN_VALUE;
			max(soldiers, 0, food, gold, 0);
			if (lBad >= max) {
				System.out.println(-1);
			} else {
				System.out.println(max - lBad);
			}
		}

	}

	private static void max(Soldier[] soldiers, int i, int food, int gold,
			int tPower) {
		if (i == soldiers.length) {
			if (max < tPower) {
				max = tPower;
			}
			return;
		}
		Soldier thisSoldier = soldiers[i];
		int use = 0;
		while (thisSoldier.food * use <= food && thisSoldier.gold * use <= gold) {
			int pow=tPower + thisSoldier.power * use;
			//System.out.println(pow);
			max(soldiers, i + 1, food - thisSoldier.food * use, gold
					- thisSoldier.gold * use, pow);
			use++;
		}
	}

	static class Soldier {
		public int power;
		int food;
		int gold;
	}
}
