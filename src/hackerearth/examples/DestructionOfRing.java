package hackerearth.examples;

public class DestructionOfRing {
	public static void main(String args[]) {
		System.out.println(Integer.MAX_VALUE);
		int rows = 10000;
		int columns = 10000;
		long field[][] = new long[rows][columns];
		for (int i = 0; i < field[0].length; i++) {
			field[0][i] = 1;
		}
		for (int i = 0; i < field.length; i++) {
			field[i][0] = 1;
		}
		for (int i = 1; i < field[0].length; i++) {
			for (int j = 1; j < field.length; j++) {
				field[i][j]=field[i-1][j]+field[j-1][i];
				field[i][j]=field[i][j]%((long)(Math.pow(10,9)+7));
			}
		}
		System.out.println(field[rows-1][columns-1]);
	}
}
