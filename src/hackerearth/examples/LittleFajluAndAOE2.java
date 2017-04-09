package hackerearth.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//this approach is flawed..I thought i wud use greedy approach but it did not give optimal solution.
//look for the other implementation better one.
public class LittleFajluAndAOE2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			Food food = new Food();
			food.food = in.nextInt();
			Gold gold = new Gold();
			gold.gold = in.nextInt();
			int pSamurai = in.nextInt();
			int pPaladin = in.nextInt();
			int pChampion = in.nextInt();
			int lalBadshah = in.nextInt();
			Soldier samurai = new Soldier(100, 0);
			samurai.setPower(pSamurai);
			Soldier paladin = new Soldier(125, 50);
			paladin.setPower(pPaladin);
			Soldier champion = new Soldier(50, 100);
			champion.setPower(pChampion);
			Soldier[] soldiers = new Soldier[3];
			soldiers[0] = samurai;
			soldiers[1] = paladin;
			soldiers[2] = champion;
			int totalVal = 0;
			Arrays.sort(soldiers, new SoldierValueComparator());
			for (int i = 0; i < soldiers.length; i++) {
				int val=soldiers[i].getTotalPower(food, gold);
				totalVal+=val;
			}
			System.out.println(totalVal);
			if (lalBadshah >= totalVal) {
				System.out.println(-1);
			} else {
				System.out.println(totalVal - lalBadshah);
			}
		}
	}

	static class SoldierValueComparator implements Comparator<Soldier> {

		public int compare(Soldier o1, Soldier o2) {
			if (o1.getValue() > o2.getValue()) {
				return -1;
			}
			return 1;
		}
	}

	static class Food {
		int food;
	}

	static class Gold {
		int gold;
	}

	static class Soldier {
		private int food;
		private int gold;
		int power;

		public void setPower(int power) {
			this.power = power;
		}

		double getValue() {
			return (double)this.power / (this.food + this.gold);
		}

		Soldier(int food, int gold) {
			this.food = food;
			this.gold = gold;
		}

		public int getTotalPower(Food food, Gold gold) {
			if (gold.gold < this.gold || food.food < this.food) {
				return 0;
			}
			if (this.gold == 0) {
				int pow= ((int) Math.floor((double)food.food / this.food)) * this.power;
				food.food = food.food % this.food;
				return pow;
			} else if (this.food == 0) {
				int pow= ((int) Math.floor((double)gold.gold / this.gold)) * this.power;
				gold.gold = gold.gold % this.gold;
				return pow;
				
			} else {
				int foodUnits = (int) Math.floor((double)food.food
						/ (this.food));
				int goldUnits = (int) Math.floor((double)gold.gold
						/ (this.gold));
				if (foodUnits < goldUnits) {
					gold.gold -= foodUnits * this.gold;
					food.food %= this.food;
				} else {
					gold.gold %= this.gold;
					food.food -= goldUnits * this.food;
				}
				return Math.min(foodUnits, goldUnits) * this.power;
			}
		}
	}
}
