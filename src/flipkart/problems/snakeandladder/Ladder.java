package flipkart.problems.snakeandladder;

public class Ladder implements GameObject {
	private final int start;
	private final int end;

	public Ladder(int start, int end) {
		this.start = start;
		this.end = end;
		System.out.println("Created Ladder from "+ start+","+end);
	}

	@Override
	public void impact(Player player) {
		System.out.println("Encountered Ladder : Jumped to "+this.end);
		player.setPosition(this.end);
	}

	@Override
	public int getPosition() {
		return this.start;
	}

}
