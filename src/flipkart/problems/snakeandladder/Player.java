package flipkart.problems.snakeandladder;

public class Player {

	private int position;
	private int playerId;

	Player(int id) {
		this.playerId = id;
	}

	public int getPlayerId() {
		return playerId;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int p) {
		this.position = p;

	}

}
