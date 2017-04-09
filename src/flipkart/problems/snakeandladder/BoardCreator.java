package flipkart.problems.snakeandladder;

public class BoardCreator {
	public Board createBoardWithSnakesLadderAndJackpot() {
		Board b = new Board();
		for (int i = 1; i <= 10; i++) {
			int start = (int) (Math.random() * 70);
			int end = start+(int)(Math.random()*(100-start))+1;
			Ladder s = new Ladder(start, end);
			b.addGameObjectAt(s);
		}

		for (int i = 1; i <= 10; i++) {
			int start = (int) (Math.random() * 100);
			int end = (int) (Math.random()*start)+1;
			Snake s = new Snake(start, end);
			b.addGameObjectAt(s);
		}
		
		return b;
	}
}
