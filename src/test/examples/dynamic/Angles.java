package test.examples.dynamic;

import java.util.Scanner;

public class Angles {
	public static void main(String args[]) {
		int MAX = 365;
		int RANGE = 360;
		int anglesCoverage[] = new int[MAX];
		int angles[] = new int[10];
		Scanner in = new Scanner(System.in);
		int rajuACount = in.nextInt();
		int raniACount = in.nextInt();
		for (int i = 0; i < rajuACount; i++) {
			angles[i] = in.nextInt() % RANGE;
		}
		anglesCoverage[0] = 1;
		/*
		 * for each angle , 1.find all possible angles that can be generated.
		 * Use this to update the angles coverage table which is for all angles.
		 * 2.if we can reach ith angle already and from first step,we can reach
		 * more angles then they will be + or - from the given reachable angles.
		 */
		for (int i = 0; i < rajuACount; ++i) {
			int ithAngleCoverage[] = new int[MAX];
			// roam around the circle of 360 degree unit and cover all angles
			// that can be covered.
			for (int newAngle = 0; ithAngleCoverage[newAngle] == 0; newAngle %= RANGE) {
				ithAngleCoverage[newAngle] = 1;
				newAngle += angles[i];
			}
			for (int alrdyAt = 0; alrdyAt < RANGE; ++alrdyAt) {
				if (anglesCoverage[alrdyAt] == 0)
					continue;
				for (int more = 0; more < RANGE; ++more) {
					// up to this point j can be covered.
					anglesCoverage[(alrdyAt + more) % RANGE] |= ithAngleCoverage[more];
					anglesCoverage[(alrdyAt - more + RANGE) % RANGE] |= ithAngleCoverage[more];
				}
			}
		}
		for (int i = 0; i < raniACount; ++i) {
			int angle = in.nextInt();
			angle %= RANGE;
			if (anglesCoverage[angle] == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}