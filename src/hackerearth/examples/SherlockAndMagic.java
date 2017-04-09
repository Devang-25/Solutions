package hackerearth.examples;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class SherlockAndMagic {
	static Prisoner[] prisoners = null;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		ThreatDetector detector = new ThreatDetector();
		for (int t = 1; t <= testCases; t++) {
			int prisonersC = in.nextInt();
			prisoners = new Prisoner[prisonersC];
			Prisoner firstPrisoner = new Prisoner(0, in.nextInt(),
					in.nextInt(), in.next().charAt(0));
			prisoners[0] = firstPrisoner;
			for (int i = 1; i < prisonersC; i++) {
				Prisoner ithP = new Prisoner(i, in.nextInt(), in.nextInt(), in
						.next().charAt(0));
				prisoners[i] = ithP;
				for (int p = 0; p < i; p++) {
					detector.isThreat(ithP, prisoners[p]);
					if (detector.isThreat) {
						int steps = detector.steps;
						Threat threat = new Threat();
						threat.steps = steps;
						threat.prisoner = prisoners[p];
						ithP.threats.add(threat);
						threat = new Threat();
						threat.steps = steps;
						threat.prisoner = ithP;
						prisoners[p].threats.add(threat);
					}
				}
			}
			//display(prisoners);
			for (Prisoner p : prisoners) {
				if (p.existsAt != -1) {
					isConsumed(p, Integer.MAX_VALUE, null);
				}
			}
			int rem = 0;
			for (int c = 0; c < prisoners.length; c++) {
				if (prisoners[c].existsAt != -1) {
					rem++;
				}
			}
			System.out.println(rem);
		}
	}

	public static void display(Prisoner[] prisoners) {
		for (Prisoner p : prisoners) {
			System.out.print(p.x + "," + p.y + ":" + p.direction + ":"
					+ p.threats.size() + "{");
			for (Threat t : p.threats) {
				System.out.print(t.prisoner.x + "," + t.prisoner.y + ":"
						+ t.prisoner.direction + " steps:" + t.steps + "  ");
			}
			System.out.println("}");
			System.out.println();
		}
	}

	// => will srcPrisoner collide with p within 'steps' steps.
	private static boolean isConsumed(Prisoner p, int steps,
			Prisoner srcPrisoner) {
		if (p.threats.isEmpty()) {
			return true;
		}
		boolean consumed = false;
		Threat consumedWith = null;
		for (Threat threat : p.threats) {
			if (threat.prisoner.existsAt != -1) {
				if (srcPrisoner != null && threat.prisoner == srcPrisoner) {
					if (p.threats.size() == 1) {
						break;
					}
					continue;
				} else if (threat.steps < steps
						&& !isConsumed(threat.prisoner, threat.steps, p)) {
					consumed = true;
					consumedWith = threat;
					prisoners[consumedWith.prisoner.existsAt].existsAt = -1;
					prisoners[p.existsAt].existsAt = -1;
					break;
				}
			}
		}
		if (consumed) {
			for (Threat t : p.threats.tailSet(consumedWith, false)) {
				if (t.prisoner.existsAt != -1 && t.steps == consumedWith.steps) {
					if (!isConsumed(t.prisoner, consumedWith.steps, p)) {
						prisoners[t.prisoner.existsAt].existsAt = -1;
					}
				}
			}
			return true;
		}
		return false;
	}

	static class ThreatDetector {
		private boolean isThreat = false;
		private int steps = -1;

		private void isThreat(Prisoner p1, Prisoner p2) {
			isThreat = false;
			steps = -1;
			int x1 = p1.x;
			int y1 = p1.y;
			int x2 = p2.x;
			int y2 = p2.y;
			boolean rightAngleCollision = false;
			if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
				steps = Math.abs(x1 - x2);
				rightAngleCollision = true;
			}
			boolean headOnCollision = false;
			if (p1.direction != p2.direction) {
				if (((x1 == x2) && (y1 + y2) % 2 == 0)
						&& ((p1.direction == 'N' && p2.direction == 'S' && y2 > y1) || (p1.direction == 'S'
								&& p2.direction == 'N' && y2 < y1))) {
					steps = Math.abs(y1 - y2) / 2;
					headOnCollision = true;

				} else if (((y1 == y2) && ((x1 + x2) % 2 == 0))
						&& ((p1.direction == 'E' && p2.direction == 'W' && x2 > x1) || (p1.direction == 'W'
								&& p2.direction == 'E' && x2 < x1))) {
					headOnCollision = true;
					steps = Math.abs(x1 - x2) / 2;
				}
			}
			if (!rightAngleCollision && !headOnCollision) {
				return;
			}
			switch (p1.direction) {
			case 'N':
				if (y2 < y1) {
					if (((x2 < x1 && p2.direction == 'E') || (x2 > x1 && p2.direction == 'W'))
							|| headOnCollision) {
						isThreat = true;
					}
				}
				break;
			case 'E':
				if (x2 > x1) {
					if (((y2 < y1 && p2.direction == 'N') || (y2 > y1 && p2.direction == 'S'))
							|| headOnCollision) {
						isThreat = true;
					}
				}
				break;
			case 'W':
				if (x2 < x1) {
					if (((y2 < y1 && p2.direction == 'N') || (y2 > y1 && p2.direction == 'S'))
							|| headOnCollision) {
						isThreat = true;
					}
				}
				break;
			case 'S':
				if (y2 < y1) {
					if (((x2 < x1 && p2.direction == 'E') || (x2 > x1 && p2.direction == 'W'))
							|| headOnCollision) {
						isThreat = true;
					}
				}
				break;
			}
		}
	}

	static class Prisoner {
		int existsAt;
		int x;
		int y;
		char direction;

		Prisoner(int index, int x, int y, char direction) {
			this.x = x;
			this.existsAt = index;
			this.y = y;
			this.direction = direction;
		}

		TreeSet<Threat> threats = new TreeSet<Threat>(new ThreatComparator());

		@Override
		public String toString() {
			return x + "," + y + " :" + direction + "==" + threats.size();
		}
	}

	static class Threat {
		int steps;
		Prisoner prisoner;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return prisoner + ".";
		}
	}

	static class ThreatComparator implements Comparator<Threat> {

		@Override
		public int compare(Threat threat1, Threat threat2) {
			if (threat1.steps < threat2.steps) {
				return -1;
			}
			return 1;
		}
	}
}
