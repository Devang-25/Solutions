package flipkart.problems.snakeandladder;

public class Dice {

	private int score;

	public int throwDice() {
		score = (int) (Math.random() * 6 )+ 1;
		return score;
	}

	public int getScore() {
		return score;
	}

}
