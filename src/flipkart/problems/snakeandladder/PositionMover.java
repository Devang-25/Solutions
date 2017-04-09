package flipkart.problems.snakeandladder;

public class PositionMover {
	private final Board board;
	public PositionMover(Board board) {
		this.board=board;
	}
	public void movePlayer(Player p, int score) {
		int pos=p.getPosition()+score;
		
		while(pos!=p.getPosition()){
			Step step=board.getStep(pos);
			p.setPosition(pos);
			if(step.getGameObjects().isEmpty()){
				break;
			}
			for(GameObject obj:step.getGameObjects()){
				//only one object is assumed to impact position.
				obj.impact(p);
				pos=p.getPosition();
			}
			
		}
	}

}
