/**
 * 
 */
package geek.examples;

/**
 * @author makkg
 *
 */
public class OptimalBinarySearchTree {
	private static int keys[] = { 10, 12, 20, 40, 45, 50, 65};
	private static int freq[] = { 34, 8, 50, 12, 45, 23,13};
	//this code does optimize time using cache but is not optimal for space.
	/*
	 * am using O(n^3 for space)
	 * the solution in book uses O(n^2)space.. that a dp one which computes diagonally.
	 * */
	private static int cache[][][] = new int[keys.length][keys.length][keys.length];
	private static int hit = 0;

	public static void main(String[] args) {

		for (int i = 0; i < keys.length; i++)
			cache[i][i][i] = freq[i];

		int optimal = optimal(0, keys.length - 1, 1);
		System.out.println(optimal);
		System.out.println(hit + " hits");
	}

	/**
	 * @param keys2
	 * @param freq2
	 */
	private static int optimal(int s, int e, int level) {
		System.out.println("C(" + s + "," + e + "," + level + ")");
		if (s > e) {
			System.out.println("-");
			return 0;
		}
		if (s == e) {
			System.out.println("s==e " + freq[s] * level);
			return freq[s] * level;
		}
		if (cache[s][e][level] != 0) {
			System.out.println("cache " + s + "," + e+" "+level);
			hit++;
			return cache[s][e][level];
		}
		int min = Integer.MAX_VALUE;
		for (int node = s; node <= e; node++) {
			System.out.println("node at " + keys[node] + " level " + level);
			int cost = optimal(s, node - 1, level + 1)
					+ optimal(node + 1, e, level + 1) + freq[node] * level;
			System.out.println("cost :" + cost + " at level " + level);
			if (cost < min) {
				min = cost;
			}
		}
		System.out.println("min cost :" + min + " at level " + level);
		cache[s][e][level] = min;
		return min;
	}

}
