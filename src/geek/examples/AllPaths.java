package geek.examples;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//to be continued.
public class AllPaths {
	private static List<LinkedList<City>> allPaths = new LinkedList<LinkedList<City>>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		City[] cities = new City[n];
		for (int i = 0; i < cities.length; i++) {
			cities[i] = new City(i, in.nextInt());
		}
		for (int i = 1; i < n; i++) {
			int cityA = in.nextInt();
			int cityB = in.nextInt();
			if (cityA > cityB) {
				int temp = cityA;
				cityA = cityB;
				cityB = temp;
			}
			cities[cityA].addNeighbour(cities[cityB]);
		}
		LinkedList<City> path = new LinkedList<City>();
		dfs(cities[0], path);
		System.out.println(allPaths);

	}

	private static void dfs(City city, LinkedList<City> path) {
		if (city.connectedCities.isEmpty()) {
			// this is a leaf
			allPaths.add(path);
			return;
		}
		for (City c : city.connectedCities) {
			LinkedList<City> cloned = new LinkedList<City>(path);
			cloned.add(c);
			dfs(c, cloned);
		}
	}

	static class City {
		public final int profit;
		private final int id;
		List<City> connectedCities = new LinkedList<City>();

		City(int id, int profit) {
			this.id = id;
			this.profit = profit;
		}

		void addNeighbour(City city) {
			this.connectedCities.add(city);
		}

		@Override
		public String toString() {
			return "" + id;
		}
	}
}
