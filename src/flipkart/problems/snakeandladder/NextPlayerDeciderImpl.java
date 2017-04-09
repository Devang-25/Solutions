package flipkart.problems.snakeandladder;

public class NextPlayerDeciderImpl implements NextPlayerDecider {

	private int currentPlayer;

	private final Player players[];
	private int chances[];
	private final Game game;

	NextPlayerDeciderImpl(Game game, Player[] players) {
		this.players = players;
		this.game = game;
	}

	@Override
	public Player getCurrentPlayer() {
		return this.players[this.currentPlayer];
	}

	@Override
	public Player nextPlayer() {
		if (game.getDice().getScore() == 6) {
			return this.players[this.currentPlayer];
		}
		
		currentPlayer++;
		if (currentPlayer == this.players.length) {
			currentPlayer=0;
		}
		return this.players[this.currentPlayer];
	}

}
