package flipkart.problems;

public class PossibleWordsFromPhoneDigits {
	public static void main(String[] args) {

		String numPad[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		int noDialed[] = { 0, 2, 4 };
		print(numPad, noDialed, 0, "");
	}

	private static void print(String[] numPad, int[] noDialed, int i,
			String output) {
		if (i == noDialed.length) {
			System.out.println(output);
			return;
		}
		if (numPad[noDialed[i]].length() == 0) {
			print(numPad, noDialed, i + 1, output);
		} else {
			for (char c : numPad[noDialed[i]].toCharArray()) {
				print(numPad, noDialed, i + 1, output + c);
			}
		}
	}
}
