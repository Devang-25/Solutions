package flipkart.problems.snakeandladder;

public class Game {

	BoardCreator gen;
	private Dice dice = new Dice();
	private NextPlayerDecider decider;
	private PositionMover mover;
	private Board board;
	private WinCriteria criteria;

	public static void main(String[] args) {
		Player[] players = new Player[3];
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player(i);
			players[i].setPosition(1);
		}
		Game g = new Game();
		NextPlayerDecider decider=new NextPlayerDeciderImpl(g, players);
		g.setDecider(decider);
		BoardCreator gen = new BoardCreator();
		g.setBoardCreator(gen);
		Board board = gen.createBoardWithSnakesLadderAndJackpot();
		PositionMover mover = new PositionMover(board);
		g.setPositionMover(mover);
		WinCriteria criteria = new WinCriteria(g);
		g.setCriteria(criteria);
		g.play();
	}

	public void setPositionMover(PositionMover mover2) {
		this.mover = mover2;

	}

	public void setBoardCreator(BoardCreator gen2) {
		this.gen = gen2;

	}

	public void play() {
		while (true) {
			Player p = decider.nextPlayer();
			System.out.println("Player "+p.getPlayerId()+" at "+p.getPosition());
			int score = dice.throwDice();
			System.out.println("rolled "+score);
			this.mover.movePlayer(p, score);
			System.out.println("Now at "+p.getPosition());
			if (criteria.winSituation(p)) {
				break;
			}
		}

	}

	public void setGen(BoardCreator gen) {
		this.gen = gen;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public void setDecider(NextPlayerDecider decider) {
		this.decider = decider;
	}

	public void setCriteria(WinCriteria criteria) {
		this.criteria = criteria;
	}

	public BoardCreator getGenerator() {
		return gen;
	}

	public Dice getDice() {
		return dice;
	}

	public Player getCurrentPlayer() {
		return this.decider.getCurrentPlayer();
	}
}
