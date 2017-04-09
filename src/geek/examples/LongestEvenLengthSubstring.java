package geek.examples;

public class LongestEvenLengthSubstring {
	public static void main(String[] args) {
		String str = "1538023";
		char c[] = str.toCharArray();
		int a[] = new int[c.length];
		for (int i = 0; i < c.length; i++) {
			a[i] = Integer.parseInt(c[i] + "");
		}
		int maxLen = getMaxLength(a);
		System.out.println(maxLen);
	}

	private static int getMaxLength(int[] a) {
		int sum[][] = new int[a.length + 1][a.length + 1];
		for (int i = 0; i < a.length; i++) {
			sum[i][i] = a[i];
		}
		int maxLength = Integer.MIN_VALUE;
		for (int gap = 2; gap <= a.length; gap++) {
			for (int i = 0; i <=a.length - gap; i++) {
				int j = i + gap-1;
				int mid = (i + j) / 2;
				int left = sum[i][mid];
				int right = sum[mid + 1][j];
				sum[i][j] = left + right;
				if (gap % 2 == 0) {
					if (left == right) {
						maxLength = gap;
					}
				}
				System.out.println("sum[" + i + "][" + j + "]=" + sum[i][j]);
			}
		}
		return maxLength;
	}
}
