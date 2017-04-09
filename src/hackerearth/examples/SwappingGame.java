package hackerearth.examples;

import java.util.Scanner;

public class SwappingGame {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int swaps = in.nextInt();
		char[] text = in.next().toCharArray();
		int n = text.length;
		int periodicity = getK(text);
		System.out.println(periodicity);
		swaps=swaps%periodicity;
		for (int i = 1; i <=swaps; i++) {
			text = swap(text).toCharArray();
			 System.out.println(i + ":" + new String(text));
		}
		System.out.println(new String(text));
	}

	private static int getK(char[] text) {
		int k = 1;
		String returned;
		String t = new String(text);
		while (!(returned = swap(text)).equals(t)) {
			text = returned.toCharArray();
			k++;
		}
		// System.out.println("matchFoundAt " + k);
		return k;
	}

	public static String swap(char text[], int startIndex) {
		int n = text.length;
		StringBuilder b = new StringBuilder();
		b.append(text[0]);
		for (int i = text.length - 1; i >= startIndex; i--) {
			b.append(text[i]);
			b.append(text[n - i]);
		}
		if (n % 2 == 0) {
			b.append(text[startIndex - 1]);
		}
		return b.toString();
	}

	public static String swap(char text[]) {
		int n = 0;
		if (text.length % 2 != 0) {
			n = text.length / 2;
		} else {
			n = (text.length / 2) - 1;
		}
		int j = text.length - 1;
		int m=0;
		char fixed[] = new char[text.length];
		for (int i = 0; i <text.length; i++) {
			if (i % 2 == 1 && i < 2 * n) {
				fixed[j] = text[i];
				j--;
			}else{
				fixed[m]=text[i];
				m++;
			}

		}
		return new String(fixed);
	}
}
