package flipkart.problems.snakeandladder;

public class Snake implements GameObject {
	private final int start;
	private final int end;

	public Snake(int start, int end) {
		this.start = start;
		this.end = end;
		System.out.println("Created snake from "+start+","+end);
	}

	@Override
	public void impact(Player player) {
		System.out.println("Down to "+this.end);
		player.setPosition(this.end);
		
	}

	@Override
	public int getPosition() {
		return this.start;
	}

}
