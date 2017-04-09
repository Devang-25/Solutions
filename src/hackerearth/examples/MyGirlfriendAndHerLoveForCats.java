package hackerearth.examples;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MyGirlfriendAndHerLoveForCats {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int catsAndPackets = in.nextInt();
		int strength[] = new int[catsAndPackets];
		int calorificValue[] = new int[catsAndPackets];
		for (int i = 0; i < catsAndPackets; i++) {
			strength[i] = in.nextInt();
		}
		for (int i = 0; i < catsAndPackets; i++) {
			calorificValue[i] = in.nextInt();
		}
		Arrays.sort(strength);
		Arrays.sort(calorificValue);
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < catsAndPackets; i++) {
			long l = calorificValue[i] * strength[i];
			sum = sum.add(new BigInteger(l + ""));
		}
		System.out.println(sum.toString());
	}
}
