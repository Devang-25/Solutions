package hackerearth.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GottaCatchThemAll {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int pokemons = in.nextInt();
		Integer days[] = new Integer[pokemons];
		for (int i = 0; i < days.length; i++) {
			days[i] = in.nextInt()+1;
		}
		Arrays.sort(days, Collections.reverseOrder());
		int max = days[0];
		for (int i = 1; i < days.length; i++) {
			if (i > max - days[i]) {
				max += (i - (max - days[i]));
			}
		}
		System.out.println(max+1);
	}
}
