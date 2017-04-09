package codechef.problems;

import java.util.Scanner;

public class HealthyDinnerParty {
	static int ingredientVal[] = null;
	static int freq[] = null;

	public static void main(String[] args) {
		HealthDinnerPartySomebody another = new HealthDinnerPartySomebody();
		Scanner in = new Scanner(System.in);
		int testCases = 1000;// in.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int ingredients = (int) (Math.random() * 23) + 3;// in.nextInt();
			ingredientVal = new int[ingredients];
			freq = new int[ingredients];
			for (int i = 0; i < ingredients; i++) {
				ingredientVal[i] = (int) (Math.random() * 15) + 1;// in.nextInt();
			}
			String shelfArrangement = getShelf(ingredients);// in.next();
			//System.out.println(shelfArrangement);
			for (char s : shelfArrangement.toCharArray()) {
				freq[s - 97]++;
			}
			int proteinReq = (int) (Math.random() * 15) + 1;
			int count[] = new int[ingredients];
			if (process(0, proteinReq, count)) {
				StringBuilder b = new StringBuilder();
				for (int i = 0; i < count.length; i++) {
					if (count[i] != 0) {
						for (int j = 1; j <= count[i]; j++) {
							b.append((char) (i + 97));
						}
					}
				}
				String val = another.findIngredients(ingredientVal,
						shelfArrangement, proteinReq);
				if (!val.equals(b.toString())) {
					System.err.println(val);
				}else{
					System.out.println("Success");
				}
			} else {
				
				String val = another.findIngredients(ingredientVal,
						shelfArrangement, proteinReq);
				if(!val.equals("IMPOSSIBLE")){
					System.err.println("Hello");
				}
			}
		}
	}

	private static String getShelf(int ingd) {
		StringBuilder b = new StringBuilder();
		for (int i = 1; i <= 1000; i++) {
			b.append((char) (((int) (Math.random() * ingd)) + 'a'));
		}
		return b.toString();
	}

	private static boolean process(int index, int proteinReq, int[] count) {
		if (proteinReq == 0) {
			return true;
		}
		if (index == ingredientVal.length) {
			return false;
		}
		int units = proteinReq / ingredientVal[index];
		if (units == 0) {
			return process(index + 1, proteinReq, count);
		}
		units = Math.min(freq[index], units);
		proteinReq -= units * ingredientVal[index];
		while (units >= 0 && !process(index + 1, proteinReq, count)) {
			units--;
			proteinReq += ingredientVal[index];
		}
		if (units >= 0) {
			// we had success at the end.
			count[index] = units;
			return true;
		}
		return false;

	}
}
