package hackerearth.examples;

public class LexicalCharacterDisplay {
	public static void display(String sentence) {
		char sentArray[] = sentence.toCharArray();
		int[] temp = new int[8];
		int[] repository = new int[8];
		for (int i = 0; i < sentArray.length; i++) {
			int code = sentArray[i];
			System.out.println(code + ":" + code % 32 + ":" + code / 32);
			if ((temp[code / 32] & (1 << (code % 32))) != 0) {
				repository[code / 32] = repository[code / 32]
						| (1 << (code % 32));
			} else {
				temp[code / 32] = temp[code / 32] | (1 << (code % 32));
			}
		}
		System.out.println("Characters repeating in lexical order.");
		for (int i = 0; i < repository.length; i++) {
			for (int j = 0; j < 32; j++) {
				if (((repository[i] >> j) & 1) == 1) {
					int cod = i * 32 + j;
					char c = (char) cod;
					System.out.println(c);
				}
			}
		}
	}

	public static void main(String args[]) {
		String s = "how are your";
		display(s);
	}
}
