package flipkart.problems.cardgame;

public class NextPlayerPicker implements NextPicker {
	private int turnIndex = 0;
	private GamePlayer[] players = null;

	public NextPlayerPicker(GamePlayer[] players) {
		this.players = players;
	}

	/* (non-Javadoc)
	 * @see flipkart.problems.cardgame.NextPicker#pickNextPlayer()
	 */
	@Override
	public GamePlayer pickNextPlayer() {
		GamePlayer p = players[turnIndex];
		turnIndex++;
		if (turnIndex == players.length) {
			turnIndex=0;
		}
		return p;
	}

	@Override
	public void setReferncePlayer(GamePlayer player) {
		//left
	}

}
