package flipkart.problems.cardgame;

public class NextTurnPicker implements NextPicker {
	private GamePlayer[] players;
	private int i = 0;
	private int ref=0;
	// private GamePlayer current;
	public NextTurnPicker(GamePlayer[] players) {
		this.players = players;
	}

	@Override
	public GamePlayer pickNextPlayer() {
		i++;
		if (i == players.length) {
			i = 0;
		}
		if(i==ref){
			return null;
		}
		GamePlayer p = players[i];
		return p;
	}

	@Override
	public void setReferncePlayer(GamePlayer player) {
		this.ref=player.getPosition();
		this.i = this.ref;
	}

}
