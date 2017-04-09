package geek.examples;

public class PrintSentences {
	public static void main(String[] args) {
		String input[][] = { { "you", "we" }, { "have", "are" },
				{ "sleep", "eat", "drink" } };
		printSentences(input);
	}

	private static void printSentences(String[][] input) {
		printSent(input, 0,"");

	}

	private static void printSent(String[][] input, int level, String text) {
		for (int w = 0; w < input[level].length; w++) {
			
			if (level + 1 != input.length) {
				printSent(input, level + 1,text+" "+input[level][w] );
			}else{
				System.out.println(text+" "+input[level][w]);
			}
		}

	}
}
