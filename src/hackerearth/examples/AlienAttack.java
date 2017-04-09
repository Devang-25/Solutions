package hackerearth.examples;

public class AlienAttack {
	public static void main(String[] args) {
		int s[][] = new int[20][2];
		s[1][0] = 0;
		s[1][1] = 1;
		s[0][0] = 1;
		s[0][1] = 0;
		for (int i = 2; i < s.length; i++) {
			s[i][0] = s[i - 1][0] + 2 * s[i - 2][0];
			s[i][1] = s[i - 1][1] + 2 * s[i - 2][1];
		}

		for (int i = 0; i < s.length; i++) {
			System.out.println("s(" + i + ")=" + s[i][0] + "a, " + s[i][1]
					+ "b");
		}
	}
}
