package hackerearth.examples;

public class Palindrome {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		int a = 0, b = 0;
		for (int i = 99999; i >= 10000; i--) {
			for (int j = i; j >= 10000; j--) {
				long mul = i * j;
				if (isPalindrome(mul + "")) {
					// System.out.println(i+"*"+j+"="+mul);
					if (mul > max) {
						max = i * j;
						a = i;
						b = j;
					}
				}
			}
		}
		System.out.println();
		System.out.println(a + "*" + b + "=" + max);
	}

	static boolean isPalindrome(String original) {
		for (int i = 0; i < original.length() / 2; i++) {
			if (original.charAt(i) != original.charAt(original.length() -1- i)) {
				return false;
			}
		}
		return true;
	}
}
